package com.example.clientsservice.services;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.db.AccountServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class AccountEmptyService {

	@Autowired
	private AccountServiceDb accountService;

	@Autowired
	private MailingService mailingService;

	@Async
	public Future<List<Account>> checkAccounts() {
		List<Account> accounts = accountService.findAllByAmountEquals(0);
		return new AsyncResult<>(accounts);
	}

	@Scheduled(cron = "*/2 * * * *")
	@Async
	public void start() {
		try  {
			Future<List<Account>> future = checkAccounts();
			while (!future.isDone())
				Thread.sleep(10);

			List<Account> accountList = future.get();
			for (Account account : accountList) {
				for (Client client : account.getClients()) {
					mailingService.sendEmail(client.getEmail(), client.getSurname());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
