package com.bankapp;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountType;
import com.bankapp.model.service.AccountService;
@EnableAspectJAutoProxy
@SpringBootApplication
public class Bankapp2Application implements CommandLineRunner{
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(Bankapp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}