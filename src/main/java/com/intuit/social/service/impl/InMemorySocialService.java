package com.intuit.social.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.intuit.social.dao.MessageRepository;
import com.intuit.social.dao.UserFollowerRepository;
import com.intuit.social.dao.UserRepository;
import com.intuit.social.entity.Message;
import com.intuit.social.entity.User;
import com.intuit.social.service.SocialService;
import com.intuit.social.entity.FollowedUser;

public class InMemorySocialService implements SocialService {

	private static final Logger logger = Logger
			.getLogger(InMemorySocialService.class);
	
	@Autowired
	private MessageRepository msgRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserFollowerRepository userFollowerRepo;
	
	@Override
	@Cacheable("tweets")
	public List<Message> getLatestOneHundredMessages(String userId) {
		logger.info("retrieve latest 100 message for user id [" + userId + "]");
		
		User loginUser = userRepo.findByEmail(userId + "@intuit.com");
		
		if(loginUser == null) {
			logger.info("no message for user: " + userId);
			return new ArrayList<Message> ();
		}
		
		PageRequest pageRequest =
			    new PageRequest(0, 100, Sort.Direction.DESC, "timeMs");
		Page<Message> msgPage = msgRepo.findByUser(loginUser, pageRequest);
		return msgPage.getContent();		
	}
	
	/*
	 * to prepare and generate data and saved in inMemory repository
	 */
	@PostConstruct
    public void messageGenerator() {	
		// set a few users
		List<User> users = new ArrayList<User> ();
		users.add(new User("bob", "", "bob@intuit.com"));
		users.add(new User("Peter", "Lynn", "peter_lynn@intuit.com"));
		users.add(new User("Lisa", "Tune", "lisa_tune@intuit.com"));
		users.add(new User("Stella", "Chang", "stella_chang@intuit.com"));
		users.add(new User("Jenny", "huston", "jenny_huston@intuit.com"));
		users.add(new User("joe", "", "joe@intuit.com"));
		userRepo.save(users);
		
		// generate messages and persist in-memory 		
		List<Message> mockedMsgs = new ArrayList<Message> ();
		for (int i = 1; i <= 55; i++) {			
			Message msg = new Message ("user 1 Social Service Msg " + i, users.get(1));
			mockedMsgs.add(msg);						
		}
		for (int i = 1; i <= 75; i++) {
			Message msg = new Message ("user 2 Social Service Msg " + i, users.get(2));
			mockedMsgs.add(msg);						
		}
		
		//userRepo.save(users);
		msgRepo.save(mockedMsgs);
		
		// set follow relation		
		List<FollowedUser> followedUsers = new ArrayList<FollowedUser> ();
		followedUsers.add(new FollowedUser(users.get(0), users.get(1)));
		followedUsers.add(new FollowedUser(users.get(0), users.get(2)));
		followedUsers.add(new FollowedUser(users.get(5), users.get(2)));
		userFollowerRepo.save(followedUsers);
		
		return;
	}
}
