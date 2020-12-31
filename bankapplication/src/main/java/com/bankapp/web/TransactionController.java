package com.bankapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.beans.DepositeBean;
import com.bankapp.beans.TransferBean;
import com.bankapp.beans.WithdrawBean;
import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;

@RestController
@RequestMapping("admin")
public class TransactionController {

private AccountService accountService;
	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path="transfer" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public String getTransferDeails(@RequestBody TransferBean transferBean) {
		Account accountTransfer=accountService.transfer(transferBean.getFromId(), transferBean.getToId(), transferBean.getAmount());
		if(accountTransfer==null)
		return "Amount not transferred";
		else
			return "Successfully Transferred";
	}
	
	@GetMapping(path="deposit" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Account getDepositDetails(@RequestBody DepositeBean depositBean) {
		Account accountDeposit=accountService.deposit(depositBean.getDepositId(),depositBean.getAmount());
		return accountService.updateAccount(accountDeposit);
	}
	
	@GetMapping(path="withdraw" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Account getWithdrawDetails(@RequestBody WithdrawBean withdrawBean) {
		Account accountWithdraw=accountService.withdraw(withdrawBean.getDepositId(),withdrawBean.getAmount());
		return accountService.updateAccount(accountWithdraw);
	}
}
