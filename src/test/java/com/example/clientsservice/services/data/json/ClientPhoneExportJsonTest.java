package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.models.User;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.PhoneService;
import com.example.clientsservice.services.data.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.clientsservice.models.Client.Gender.FEMALE;

@Order(101)
@SpringBootTest
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientPhoneExportJsonTest {

	@Qualifier("clientServiceDb")
	@Autowired
	private ClientService clientService;

	@Qualifier("phoneServiceDb")
	@Autowired
	private PhoneService phoneService;

	@Qualifier("clientServiceJson")
	@Autowired
	private ClientService clientServiceJson;

	static Client client = new Client(0, "a", "a", "a", FEMALE, "a@tes.com"
		, null, null, null);
	static Phone p1 = new Phone(0, "111", null);
	static Phone p2 = new Phone(0, "222", null);


	@Test
	void export() {

		client = clientService.save(client);
		p1.setClient(client);
		p2.setClient(client);
		List<Phone> phones = phoneService.saveAll(List.of(p1, p2));
		client.setPhones(new HashSet<>(phones));
		client = clientService.save(client);

		Client actual = clientServiceJson.save(client);
		Assertions.assertEquals(client,actual);

		System.err.println(clientServiceJson.findAll());
	}

}
