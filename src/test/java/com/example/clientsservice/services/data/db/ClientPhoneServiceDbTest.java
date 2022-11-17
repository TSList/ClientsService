package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.PhoneService;
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

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientPhoneServiceDbTest {

	@Autowired
	private ClientService clientService;

	@Autowired
	private PhoneService phoneService;

	static Client client = new Client(0, "a", "a", "a", FEMALE, "a@tes.com"
		, null, null, null);
	static Phone p1 = new Phone(0,"111",null);
	static Phone p2 = new Phone(0,"222",null);

	@Test
	@Order(1)
	void save(){
		client = clientService.save(client);
		p1.setClient(client);
		p2.setClient(client);
		p1 =phoneService.save(p1);
		p2 = phoneService.save(p2);
	}

	@Test
	@Order(2)
	@Transactional
	void findByClientId(){
		Client actualClient = clientService.findById(client.getId());
		System.err.println(actualClient);
		System.err.println(actualClient.getPhones());
	}

}
