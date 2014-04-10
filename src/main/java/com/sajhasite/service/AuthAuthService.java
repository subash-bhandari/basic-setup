package com.sajhasite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sajhasite.controller.model.Login;
import com.sajhasite.domain.entity.User;
import com.sajhasite.repository.UserRepository;

@Service
public class AuthAuthService extends AbstractService {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean authenticate(Login login) {
		User user = userRepository.getByEmail(login.getLoginId());
		if(user == null) {
			user = userRepository.getByUserId(login.getLoginId());
		}
		if(user == null) {
			return false;
		}
		return login.getPassword().equals(user.getPassword());
	}
	
	public void createUser(User user) {
		userRepository.save(user);
	}
}
