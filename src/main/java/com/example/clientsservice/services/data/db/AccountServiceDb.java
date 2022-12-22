package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.repositories.AccountRepository;
import com.example.clientsservice.services.data.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDb implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account findById(Long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public List <Account> saveALL( List<Account> account) {
		return accountRepository.saveAll(account);
	}

	@Override
	public List<Account> findAllByAmountEquals(int amount) {
		return accountRepository.findAllByAmountEquals(amount);
	}
}
