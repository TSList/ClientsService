package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.repositories.ClientRepository;
import com.example.clientsservice.services.data.AccountService;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.models.Client.Gender.MALE;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientAccountTest {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AccountService accountService;

	static Client a = new Client(0, "a", "a", "a", FEMALE, "a@tes.com"
		, null, null, null);

	static Account account = new Account(0L,250,null);
	static Account account1 = new Account(0L,300,null);


	@Test
	@Order(1)
	@Transactional
	void save() {
		a = clientService.save(a);
		a.setAccounts(Set.of(account,account1));
//		account = accountService.save(account);
//		a.setAccounts(Set.of(account));
//		a.setAccounts(Set.of(account));
//		account = accountService.save(account);
//		account.setClients(Set.of(a,b));
//		a.setAccounts(Set.of(account));
//		b.setAccounts(Set.of(account));
	}


	@Test
	@Order(2)
	@Transactional
	void findByClientId(){
//		Client actualClient = clientService.findById(a.getId());
//		System.err.println(actualClient);
//		System.err.println(actualClient.getAccounts());
//		Client actualClientb = clientService.findById(b.getId());
//		System.err.println(actualClientb);
//		System.err.println(actualClientb.getAccounts());
	}

}
