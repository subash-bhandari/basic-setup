package com.sajhasite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sajhasite.controller.model.Login;
import com.sajhasite.domain.entity.User;
import com.sajhasite.service.AuthAuthService;

@Controller
@RequestMapping("/signup.do")
public class SignupController {
	
	@Autowired
	private AuthAuthService authAuthService;

	@RequestMapping(method=RequestMethod.GET)
	public String signup(final Model model) {
		model.addAttribute("signup", new User());
		return "signup";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String signup(@ModelAttribute("signup") User user, final Model model) {		
		authAuthService.createUser(user);
		return "login";
	}
}
