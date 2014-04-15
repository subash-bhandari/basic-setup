package com.sajhasite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sajhasite.domain.entity.User;
import com.sajhasite.repository.UserRepository;

@Service
public class UserService extends AbstractService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAllUsers() {
		return userRepository.getAll();
	}
}
