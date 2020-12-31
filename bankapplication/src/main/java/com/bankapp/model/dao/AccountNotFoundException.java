package com.bankapp.model.dao;

@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException{
	public AccountNotFoundException(String message) {
		super(message);
	}
}
