package com.intuit.social.dao;

import com.intuit.social.entity.Message;
import com.intuit.social.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bruce.jia
 * @Date Oct 13, 2016
 * @version 
 */
@Transactional

public interface MessageRepository extends JpaRepository<Message, Long> {
	
	final static String QUERY_LATEST_MESSAGE = "SELECT m from Message m, FollowedUser fu WHERE fu.followedUser = m.user and fu.user = :user ";
	
	 /**
     * Find messages for one user.
     */
    @Query(QUERY_LATEST_MESSAGE)
    public Page<Message> findByUser(@Param("user") User user, Pageable pageable);
}
