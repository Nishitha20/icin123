package org.capstone.dao;

import java.util.List;

import org.capstone.model.BankRegister;
import org.capstone.model.Request;
import org.capstone.model.Transaction;
import org.capstone.model.Transfer;

public interface BankRegisterDao 
{
	int register(BankRegister b);


	List<BankRegister> display(String cid);



	List<BankRegister> get(String accn);

	int transaction(Transaction t);

	int transfer(String accn2, int amt1);

	int withdraw(String accn, int amt, String psswd);

	int deposit(String accn, int amt, String psswd);



	List<BankRegister> get1(String cid);


	int request(Request r);


	int validate(String cid, String pass);


	int validate1(String cid, String pass, String x);


	int validateadmin(String cid, String pass);


	List<BankRegister> read();




	int update(String cid, String x);


	int update1(String cid, String x);



	int updatewblock1(String cid, String x);


	int updatewblock2(String cid, String x);


	int validate3(String cid, String psswd, String x1);


	int updatedblock1(String cid, String x);


	int updatedblock2(String cid, String x);


	int validate4(String cid, String psswd, String x1);


	int updatetblock1(String cid, String x);


	int updatetblock2(String cid, String x);


	


	int validatewithdraw(String cid, String x);


	int validatedeposit(String cid, String x);


	int validatetransfer(String cid, String x1);


	List<Transfer> display1(String cid);


	int enterrecipient(Transfer t);


	List<Transfer> display1(String cid, String acnum);


	int validaterecipient(String accn2, String name, String mobile);
}
