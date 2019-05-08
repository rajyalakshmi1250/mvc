package com.capgemini.bankapp.client;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;

@Controller
@RequestMapping("/bank")
public class BankAccountClient {

	@Autowired
	private BankAccountService service;

	@RequestMapping("/")

	public String homePage() {

		return "index";
	}

	@RequestMapping("/new account")

	public String addNew() {

		return "new account";
	}

	@RequestMapping("/add")
	public String addNewBankAccount(@RequestParam("Customer name") String accountHolderName,
			@RequestParam("Account Type") String accountType, @RequestParam("Account Balance") double amount) {

		service.addNewBankAccount(new BankAccount(accountHolderName, accountType, amount));
		return "success";

	}
	@RequestMapping("/deleteAccount")

	public String check() {

		return "deleteAccount";
	}

	@RequestMapping("/delete")
	public String deleteBankAccount(@RequestParam("Customer name") String accountHolderName,
			@RequestParam("Account Type") String accountType, @RequestParam("Account Balance") double amount) {

		service.addNewBankAccount(new BankAccount(accountHolderName, accountType, amount));
		return "success";

	}

	
	@RequestMapping("/all accounts")
	public String findAllBankAccountsDetails() {

		service.findAllBankAccountsDetails();
		
		return "all accounts";

	}

}
