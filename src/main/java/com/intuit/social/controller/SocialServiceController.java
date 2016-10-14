package com.intuit.social.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.social.entity.Message;
import com.intuit.social.service.SocialService;

/**
*
* @author bruce.jia
* @Date Oct 13, 2016
* @version 
*/
@RestController
public class SocialServiceController {
	
	private static final Logger logger = Logger.getLogger(SocialServiceController.class);
	
	@Autowired
	SocialService svc;

    @RequestMapping(path="/feed", method = RequestMethod.GET)
    public List<Message> getFeed() {    	
    	String userId = getCurrentUserID();
    	logger.info("user [" + userId + "] access service to get feed.");
    	return svc.getLatestOneHundredMessages(userId);
    }
    
    private String getCurrentUserID() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
    	return authentication.getName();
    }
}
