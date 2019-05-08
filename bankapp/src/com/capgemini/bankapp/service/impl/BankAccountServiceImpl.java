package com.capgemini.bankapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountDao bankAccount;

	public BankAccountServiceImpl(BankAccountDao bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public double checkBalance(long accountId) throws AccountNotFoundException {
		double balance = bankAccount.getBalance(accountId);
		if (balance >= 0) {
			return balance;
		} else {
			throw new AccountNotFoundException("BankAccount doesn't exist....");
		}
	}

	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException, AccountNotFoundException {
		double balance = bankAccount.getBalance(accountId);
		if (balance < 0) {
			throw new AccountNotFoundException("BankAccount doesn't exist....");
		} else if (balance - amount >= 0) {
			balance = balance - amount;
			bankAccount.updateBalance(accountId, balance);
			//DbUtil.commit();
			return balance;
		} else {
			throw new LowBalanceException("You don't have sufficient fund.");
		}
	}

	@Override
	public double deposit(long accountId, double amount) throws AccountNotFoundException {
		double balance = bankAccount.getBalance(accountId);
		if (balance < 0) {
			throw new AccountNotFoundException("BankAccount doesn't exist....");
		} else {
			balance = balance + amount;
			bankAccount.updateBalance(accountId, balance);
			//DbUtil.commit();
			return balance;
		}
	}

	@Override
	public boolean deleteBankAccount(long accountId) throws AccountNotFoundException {
		boolean result = bankAccount.deleteBankAccount(accountId);

		if (result) {
			//DbUtil.commit();
			return result;
		} else {
			throw new AccountNotFoundException("BankAccount doesn't exist....");
		}

	}

	

	 @Override
	public List<BankAccount> findAllBankAccountsDetails() {
		return bankAccount.findAllBankAccountsDetails();
	}

	@Override
	public BankAccount searchAccountDetails(long accountId) throws AccountNotFoundException {
		return bankAccount.searchAccountDetails(accountId);
	}

	@Override
    @Transactional(rollbackFor=AccountNotFoundException.class)
	public double fundTransfer(long fromAccountId, long toAccountId, double amount)
			throws LowBalanceException, AccountNotFoundException {

		try {
			double newBalance = withdrawForFundTransfer(fromAccountId, amount);
			deposit(toAccountId, amount);
			//DbUtil.commit();
			return newBalance;
		} catch (LowBalanceException | AccountNotFoundException e) {

			e.printStackTrace();
			//DbUtil.rollback();
			throw e;
		}
	}

	private double withdrawForFundTransfer(long accountId, double amount)
			throws AccountNotFoundException, LowBalanceException {
		double balance = bankAccount.getBalance(accountId);
		if (balance < 0) {
			throw new AccountNotFoundException("BankAccount doesn't exist....");
		} else if (balance - amount >= 0) {
			balance = balance - amount;
			bankAccount.updateBalance(accountId, balance);
			return balance;
		} else {
			throw new LowBalanceException("You don't have sufficient fund.");
		}
	}

	@Override
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType) {
		boolean result = bankAccount.updateBankAccountDetails(accountId, accountHolderName, accountType);
		if (result) {
			//DbUtil.commit();
		}

		return result;
	} 


	@Override
	public boolean addNewBankAccount(BankAccount account) {
		boolean result = bankAccount.addNewBankAccount(account);

		if (result) {
			//DbUtil.commit();
		}

		return result;
	}
}
