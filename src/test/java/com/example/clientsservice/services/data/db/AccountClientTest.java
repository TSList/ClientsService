package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.repositories.AccountRepository;
import com.example.clientsservice.repositories.ClientRepository;
import com.example.clientsservice.services.data.AccountService;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.models.Client.Gender.MALE;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountClientTest {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AccountService accountService;

	static Client a = new Client(0, "a", "a", "a", FEMALE, "a@tes.com"
		, null, null, null);

	static Client b = new Client(0, "b", "b", "b", MALE, "b@tes.com"
		, null, null, null);

	static Account account = new Account(0L,250,null);



	@Test
	@Order(1)
	void save() {
		a = clientService.save(a);
		b = clientService.save(b);
		account = accountService.save(account);

		//
		Set<Client> clients = Set.of(a,b);
		Set<Account> accounts = Set.of(account);
		//
		account.setClients(clients);
		a.setAccounts(accounts);
		b.setAccounts(accounts);

		//
		a = clientService.save(a);
		b = clientService.save(b);
		account = accountService.save(account);
	}


	@Test
	@Order(2)
	@Transactional
	void findByClientId(){
		Account actualAccount = accountService.findById(account.getId());
		System.err.println(actualAccount);
		System.err.println(actualAccount.getClients());
	}

}
