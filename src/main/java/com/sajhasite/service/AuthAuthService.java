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
	
	
	
	
}
