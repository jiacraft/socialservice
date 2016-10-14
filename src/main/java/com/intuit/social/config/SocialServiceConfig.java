package com.intuit.social.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.intuit.social.service.SocialService;
import com.intuit.social.service.impl.InMemorySocialService;

@Configuration
public class SocialServiceConfig {
	
	@Bean
	public SocialService socialService() {
		return new InMemorySocialService();
	}
}
