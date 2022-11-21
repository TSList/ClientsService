package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;
import com.example.clientsservice.services.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String load(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "/users";

	}

//	@GetMapping("/users")
//	public String loadUser(Model model) {
//		List<User> users = userService.findAll();
//		model.addAttribute("users", users);
//		return "/users";
//	}

	@PostMapping("usersAddForm")
	public String clientAddForm(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		@RequestParam("role") User.Role role,
		@RequestParam("status") User.Status status) {

		User user = new User(0, username, password, role, status);
		userService.save(user);
		return "redirect:/users";
	}
}
