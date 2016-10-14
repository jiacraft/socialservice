package com.intuit.social.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuit.social.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	private static final Logger logger = Logger
			.getLogger(UserRepositoryTest.class);
	
	@Autowired
    private UserRepository repo;
	
	@Test
    public void testUserPersist() throws Exception {
		List<User> users = new ArrayList<User>();
		users.add(new User("Kevin", "Abc"));
		users.add(new User("Peter", "BCD"));
		
		repo.save(users);
		users = repo.findAll();
		
		logger.debug("total user number: " + users.size());
		
		assertEquals(users.size(), 2);
	}
}
