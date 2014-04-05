package com.sajhasite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sajhasite.controller.model.Login;

@Controller
public class LoginController {

	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(final Model model) {
		model.addAttribute("login", new Login(null, null));
		return "login";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String authenticate(@ModelAttribute("login") Login login, final Model model) {
		if("bhesh".equals(login.getLoginId())) {
			if("bhesh".equals(login.getPassword())) {
				return "home";
			}
		}
		return "login";
	}
	
	@RequestMapping(value="forgotpassword.do", method=RequestMethod.GET)
	public String forgotPassword(final Model model) {
		model.addAttribute("login", new Login(null, null));
		return "forgotPassword";
	}
}
