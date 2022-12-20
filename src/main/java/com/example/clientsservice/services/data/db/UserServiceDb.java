package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.User;
import com.example.clientsservice.repositories.UserRepository;
import com.example.clientsservice.services.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDb implements UserService {

	@Autowired
	private UserRepository userRepository;


	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
