package com.intuit.social.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.social.entity.FollowedUser;

/**
 *
 * @author bruce.jia
 * @Date Oct 13, 2016
 * @version 
 */
@Transactional
public interface UserFollowerRepository extends JpaRepository<FollowedUser, Long> {
	
}
