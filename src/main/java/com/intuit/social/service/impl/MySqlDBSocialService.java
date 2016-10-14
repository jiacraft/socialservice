package com.intuit.social.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.intuit.social.entity.Message;
import com.intuit.social.service.SocialService;

//@Component(value="mySql")
public class MySqlDBSocialService implements SocialService {

	@Override
	public List<Message> getLatestOneHundredMessages(String ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
