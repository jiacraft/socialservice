package com.intuit.social.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.social.entity.User;

/**
 *
 * @author bruce.jia
 * @Date Oct 13, 2016
 * @version 
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	
	final static String QUERY_BYEMAIL = "SELECT u from User u WHERE u.email = :email ";
	
	/**
     * Find user by email.
     */
    @Query(QUERY_BYEMAIL)
    public User findByEmail(@Param("email") String email);
}
