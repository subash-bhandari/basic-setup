package com.sajhasite.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries(value = {
		@NamedQuery(name = "getAllUsers", query = "select u from User u"),
		@NamedQuery(name = "getUserByUserId", query = "select u from User u where u.username =:username"),
		@NamedQuery(name = "getUserByEmail", query = "select u from User u where u.email =:email"),
		@NamedQuery(name = "getUserByDisplayNameLike", query = "select u from User u where u.displayName like:displayName") })
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;
	private String displayName;
	private String email;
	private boolean enabled;
	
	private List<Authority> authorities;

	public User() {
		super();
	}

	public User(String username, String password, String displayName,
			String email) {
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "display_name", nullable = true)
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public void addAuthority(Authority authority) {
		if(authorities == null) {
			authorities = new ArrayList<>();
		}
		authorities.add(authority);
	}
}
