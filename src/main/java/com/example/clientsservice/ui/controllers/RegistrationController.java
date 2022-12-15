package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.services.data.db.UserServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

	@Autowired
	private UserServiceDb userService;

	@PostMapping("registrationForm")
	public String regUser (@ModelAttribute User user) {
		user.setRole(User.Role.USER);
		user.setStatus(User.Status.CREATED);
		userService.save(user);
		return "redirect:/authorization";
	}
}
