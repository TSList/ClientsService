package com.example.clientsservice;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@SpringBootTest
public class DataCalcTest {

	@Autowired
	private ClientService clientService;

	@Test
	void test() {
		LocalDate birth = LocalDate.of(1990, 11, 23);
		LocalDate now = LocalDate.now();
		LocalDate years = now.minus(birth.getYear(), ChronoUnit.YEARS);
		System.out.println(years.getYear());
		Period period = Period.between(birth, now);
		System.out.println(period.getYears());
	}

	@Test
	void clientDataSave(){
		Client client = new Client(0,"a","a","a", Client.Gender.MALE,"aaa@mail",LocalDate.now(),null,null,null);
		 client = clientService.save(client);
		System.err.println(client);

	}

	@Test
	void ClientDateJson(){
//		Client client = new Client(0,"a","a","a", Client.Gender.MALE,"aaa@mail",LocalDate.now(),null,null,null);
//		Gson gson = new Gson();
//		String json = gson.toJson(client);
//		System.err.println(json);
//		client = gson.fromJson(json,Client.class);
//		System.err.println(client);

	}
}
