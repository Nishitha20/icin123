package org.capstone.controller;

import java.io.IOException;
import java.util.List;

import org.capstone.dao.BankRegisterDao;
import org.capstone.dao.TransactionDao;
import org.capstone.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TransactionController 
{
	@Autowired
	private TransactionDao transactiondao;

	@RequestMapping(value = "/view/{cid}")
	public ModelAndView read(ModelAndView model,@PathVariable("cid") String cid) throws IOException {
		List<Transaction> t=transactiondao.view(cid);
		model.addObject("tlist", t);
		model.setViewName("viewtransactions");

		return model;
	}
}
