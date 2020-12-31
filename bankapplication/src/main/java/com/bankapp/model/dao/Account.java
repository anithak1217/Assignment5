package com.bankapp.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name",nullable=false)
	private String name;
	@Column(name="address",nullable=false)
	private String address;
	@Column(name="balance",nullable=false)
	private double balance;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	public Account() {
	}
	
	
	public Account(int id, String name, String address, double balance, AccountType accountType) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.balance = balance;
		this.accountType = accountType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
}
