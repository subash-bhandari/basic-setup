package com.sajhasite.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NamedQueries(
	value={
		@NamedQuery(name="getAllUsers", query="select u from User u"),
		@NamedQuery(name="getUserByUserId", query="select u from User u where u.userId =:userId"),
		@NamedQuery(name="getUserByEmail", query="select u from User u where u.email =:email"),
		@NamedQuery(name="getUserByDisplayNameLike", query="select u from User u where u.displayName like:displayName")		
})
public class User {
	private String userId;
	private String password;
	private String displayName;
	private String email;
	
	public User() {
		super();
	}

	public User(String userId, String password, String displayName, String email) {
		this.userId = userId;
		this.password = password;
		this.displayName = displayName;
		this.email = email;
	}

	@Id
	@Column(name="username",nullable=false)
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="password",nullable=false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="display_name",nullable=true)
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name="email",nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
