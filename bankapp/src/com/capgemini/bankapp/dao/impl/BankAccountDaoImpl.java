package com.capgemini.bankapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.model.BankAccount;


@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//private DataSource dataSource;



	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
		//jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	
	public boolean addNewBankAccount(BankAccount account) {

		int result= jdbcTemplate.update("INSERT INTO bankaccounts(customer_name,account_type,account_balance) VALUES(?,?,?)",new Object[]{account.getAccountHolderName(),account.getAccountType(),account.getAccountBalance()});
		if(result==1)		
			return true;
		return false;
	}

	
	public void updateBalance(long accountId, double newBalance) {

		int result= jdbcTemplate.update("UPDATE bankaccounts SET account_balance=? WHERE account_id=?",new Object[]{newBalance,accountId});
		String query = "UPDATE bankaccounts1 SET account_balance=? WHERE account_id=?";
		
		}
	
	public double getBalance(long accountId) {
		String query = "SELECT account_balance FROM bankaccounts WHERE account_id=" + accountId;
		double balance = -1;
		balance=jdbcTemplate.queryForObject(query,Double.class);

		
		return balance;
	}

	
	

	
	public boolean deleteBankAccount(long accountId) {

		
		String query = "DELETE FROM bankaccounts WHERE account_id=" + accountId;
		int result= jdbcTemplate.update(query);

		if (result == 1) {
			return true;
		}
		return false;
	}


	
	public List<BankAccount> findAllBankAccountsDetails() {
		String query = "SELECT * FROM bankaccounts";
	
		List<BankAccount> accounts = jdbcTemplate.query(query,(resultSet,rowNum)->{
			BankAccount account=new BankAccount(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));


		
		return account;
	});
		return accounts;
	}

	
	public BankAccount searchAccountDetails(long accountId) throws AccountNotFoundException {
		String query = "SELECT * FROM bankaccounts WHERE account_id=" + accountId;
		BankAccount account = jdbcTemplate.queryForObject(query,(resultSet,rowNum)->{
		BankAccount account1=new BankAccount(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));
		return account1;
		});;

		
		return account;
	}

	
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType) {

		String query = "UPDATE bankaccounts SET customer_name=?,account_type=? WHERE account_id=?";
		Object[] params={accountHolderName,accountType,accountId};
		int result= jdbcTemplate.update(query,params);
		if (result == 1) {
			return true;
		}
		
		return false;
	}
}
