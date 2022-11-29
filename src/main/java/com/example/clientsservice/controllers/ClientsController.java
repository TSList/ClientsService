package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientsController {
@Autowired
private ClientService clientService;

	@GetMapping("clients")
	public String load(Model model) {
		List<Client> clients = clientService.findAll();
		model.addAttribute("clients",clients);
		return "clients";
	}
}
