package com.example.clientsservice.repositories;

import com.example.clientsservice.models.Client;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.models.Client.Gender.MALE;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;

	static Client a = new Client(0, "a", "a", "a", FEMALE, "a@tes.com"
		, null, null, null);

	static Client b = new Client(0, "b", "b", "b", MALE, "b@tes.com"
		, null, null, null);

	@Test
	@Order(1)
	public void saveAll() {
		Client a_save = clientRepository.save(a);
		Client b_save = clientRepository.save(b);
		a.setId(a_save.getId());
		b.setId(b_save.getId());
		Assertions.assertEquals(a, a_save);
		Assertions.assertEquals(b, b_save);
	}

	@Test
	@Order(2)
	void findALLByCount() {
		Assertions.assertEquals(2,clientRepository.findAll().size());
	}

	@Test
	@Order(3)
	void findALLByCollection() {
		List<Client> original = List.of(a, b);
		List<Client> saved = clientRepository.findAll();
		Assertions.assertIterableEquals(original,saved);
	}

	@Test
	@Order(4)
	void deleteAll() {
		clientRepository.deleteAll();
		Assertions.assertEquals(0,clientRepository.findAll().size());
	}
}
