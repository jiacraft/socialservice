package com.intuit.social.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4236958924670287975L;

	@Id @GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	private String email;
		
	public User() {
		;
	}
	public User(String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
	}
	
	public User(String fName, String lName, String email) {
		this.firstName = fName;
		this.lastName = lName;
		this.email = email;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}	

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}	
	
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return "First Name: " + this.firstName + ", Last Name: " + this.lastName + ((this.email == null)?"" : ", email: " + this.email);
	}
}
