package com.bankapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.bankapp.config.*;
import com.bankapp.model.service.AccountService;

public class MainClass {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AccountConfiguration.class);
		AccountService accounts=(AccountService) ctx.getBean("accountService");
		accounts.transfer(1, 2, 600);
		
	}
}
