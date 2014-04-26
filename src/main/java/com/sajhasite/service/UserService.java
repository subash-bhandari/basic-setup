package com.sajhasite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sajhasite.domain.entity.Authority;
import com.sajhasite.domain.entity.User;
import com.sajhasite.repository.UserRepository;

@Service
public class UserService extends AbstractService {
	

	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAllUsers() {
		return userRepository.getAll();
	}
	
	public void createUser(User user) {
		user.setEnabled(true);
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		user.addAuthority(authority);
		userRepository.save(user);
		userRepository.save(authority);
	}
}
