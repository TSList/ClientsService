package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {
	User save(User user);

	List<User> findAll();

	User findById(Integer id);
}
