package com.bankapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoImpl implements AccountDao {

	private Map<Integer, Account> accounts = new HashMap<Integer, Account>();
	private int counter=0;
	{
		accounts.put(1, new Account(++counter, "ram", "Ap", 8000.00, AccountType.SAVING));
		accounts.put(2, new Account(++counter, "baby", "bnglr", 2000.00, AccountType.SAVING));
	}

	@Override
	public List<Account> getAllAccounts() {
		return new ArrayList<>(accounts.values());
	}

	@Override
	public Account addAccount(Account account) {
		account.setId(++counter);
		accounts.put(counter, account);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		accounts.put(account.getId(), account);
		return account;
	}

	@Override
	public Account deleteAccount(int accountId) {
		accounts.remove(accountId);
		return null;
	}

	@Override
	public Account findAccountById(int accountId) {
		Account account=accounts.get(accountId);
		return account;
	}

}
