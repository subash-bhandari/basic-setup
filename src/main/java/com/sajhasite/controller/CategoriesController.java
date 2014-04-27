package com.sajhasite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sajhasite.domain.entity.User;
import com.sajhasite.service.UserService;

@Controller
@RequestMapping("/categories.do")
public class CategoriesController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String users(final Model model) {
		List<User> users = userService.listAllUsers();
		model.addAttribute("users", users);
		return "categories";
	}
}