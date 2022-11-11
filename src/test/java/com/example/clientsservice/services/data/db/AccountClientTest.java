package com.example.clientsservice.services.data.db;

import com.example.clientsservice.repositories.AccountRepository;
import com.example.clientsservice.repositories.ClientRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountClientTest {

	@Autowired
	private AccountRepository accountRepository;
}
