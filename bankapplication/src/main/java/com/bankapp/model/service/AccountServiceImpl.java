package com.bankapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.service.aspect.Loggable;

@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	
	private static final Logger logger=LoggerFactory.getLogger(AccountServiceImpl.class);
	private AccountDao accountDao;
	private static int MIN_BALANCE=1000;
	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao=accountDao;
	}
	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	@Loggable
	@Override
	public Account transfer(int fromAccId, int toAccountId, double amount) {
		
		Account fromAcc=accountDao.findAccountById(fromAccId);
		Account toAcc=accountDao.findAccountById(toAccountId);
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		
		accountDao.updateAccount(fromAcc);
		 accountDao.updateAccount(toAcc);
		 return fromAcc;
		
		
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.addAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	@Override
	public Account deleteAccount(int accountId) {
		return accountDao.deleteAccount(accountId);
	}

	@Override
	public Account findAccountById(int accountId) {
		return accountDao.findAccountById(accountId);
	}
	@Override
	public Account deposit(int depositId, double amount) {
		Account accDeposit=accountDao.findAccountById(depositId);
		accDeposit.setBalance(accDeposit.getBalance()+amount);
		return accountDao.updateAccount(accDeposit);
	}
	@Override
	public Account withdraw(int withdrawId, double amount) {
		Account accWithdraw=accountDao.findAccountById(withdrawId);
		if(MIN_BALANCE>=1000)
		{
		accWithdraw.setBalance(accWithdraw.getBalance()-amount);
		}
		return accountDao.updateAccount(accWithdraw);
	}

}
