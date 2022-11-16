package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.data.PhoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceJson implements PhoneService {


	@Override
	public Phone save(Phone phone) {
		return null;
	}

	@Override
	public List<Phone> saveAll(List<Phone> phones) {
		return null;
	}
}
