package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;
import com.example.clientsservice.services.data.db.UserServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserUpdateController {

	@Autowired
	private UserServiceDb userServiceDb;

	@GetMapping("userUpdate")
	private String load (@RequestParam("userId") Integer id, Model model){
		User user = userServiceDb.findById(id);
		model.addAttribute("user",user);

		Map<String, String> roles = new HashMap<>();
		for (User.Role value : User.Role.values()) {
			roles.put(value.name(), value == user.getRole() ? "selected" : "");
		}
		model.addAttribute("roles", roles.entrySet());

		Map<String, String> statuses = new HashMap<>();
		for (User.Status value : User.Status.values()) {
			statuses.put(value.name(), value == user.getStatus() ? "selected" : "");
		}
		model.addAttribute("statuses", statuses.entrySet());

		return "userUpdate";
	}

	@PostMapping("userUpdateForm")
	public ModelAndView method(@ModelAttribute("user") User user) {
		userServiceDb.save(user);
		return new ModelAndView("redirect:userUpdate", new ModelMap("userId",user.getId()));
	}

}
