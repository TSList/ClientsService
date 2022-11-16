package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Phone;

import java.util.List;
import java.util.Set;

public interface PhoneService {

	Phone save(Phone phone);

	List<Phone> saveAll(List<Phone> phones);
}
