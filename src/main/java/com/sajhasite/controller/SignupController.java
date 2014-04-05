package com.sajhasite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signup.do")
public class SignupController {

	@RequestMapping(method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}
}
