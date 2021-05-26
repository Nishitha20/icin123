package org.capstone.dao;

import java.util.List;

import org.capstone.model.Request;

public interface RequestDao {

	List<Request> read();

	int updaterblock1(String cid, String x);

	int updaterblock2(String cid, String x);

	List<Request> display(String cid);

	int delete(String cid);

}
