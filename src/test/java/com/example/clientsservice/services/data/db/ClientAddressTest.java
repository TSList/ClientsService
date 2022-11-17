package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.services.data.db.ClientPhoneDzTest.p1;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientAddressTest {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AddressService addressService;

	static Client client = new Client(0, "a", "a", "a", FEMALE, "a@tes.com"
		, null, null, null);
	static Address address = new Address(0L,"b","c","d","e","f","g",null);

	@Test
	@Order(1)
	void save() {
		client = clientService.save(client);
		address.setClient(client);
		address = addressService.save(address);
	}

	@Test
	@Order(2)
	@Transactional
	void findByClientId(){
		Client actualClient = clientService.findById(client.getId());
		System.err.println(actualClient);
		System.err.println(actualClient.getAddress());
	}
}
