package com.sajhasite.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sajhasite.domain.entity.User;

@Repository
public class UserRepository extends AbstractRepository<User> {
	
	public List<User> getAll() {
		return executeNamedQuery("getAllUsers");
	}
	
	public User getByUserId(String userId) {
		return executeNamedQueryUniqueResult("getUserByUserId", "userId", userId);
	}
	
	public User getByEmail(String email) {
		return executeNamedQueryUniqueResult("getUserByEmail", "email", email);
	}
}
