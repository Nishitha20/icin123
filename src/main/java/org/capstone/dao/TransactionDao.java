package org.capstone.dao;

import java.util.List;

import org.capstone.model.Transaction;

public interface TransactionDao {


	List<Transaction> view(String cid);

	int transfer(String accn, int amt);

}
