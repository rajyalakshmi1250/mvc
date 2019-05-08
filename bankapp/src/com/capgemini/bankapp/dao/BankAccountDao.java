package com.capgemini.bankapp.dao;

import java.util.List;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.model.BankAccount;

public interface BankAccountDao {
	public boolean addNewBankAccount(BankAccount account);
	public void updateBalance(long accountId, double newBalance);


	public double getBalance(long accountId);

	
	public boolean deleteBankAccount(long accountId);


	 public List<BankAccount> findAllBankAccountsDetails();

	public BankAccount searchAccountDetails(long accountId) throws AccountNotFoundException;

	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType);

}
