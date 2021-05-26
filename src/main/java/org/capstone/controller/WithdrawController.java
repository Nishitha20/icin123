package org.capstone.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.capstone.dao.BankRegisterDao;
import org.capstone.model.BankRegister;
import org.capstone.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WithdrawController 
{
	@Autowired
	private BankRegisterDao bankregisterdao;
	@RequestMapping(value = "/withdrawblock/withdraw/{cid}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid,
			@RequestParam("amount") int amount,@RequestParam("psswd") String psswd) {
		List<BankRegister> b= bankregisterdao.get1(cid);
		int bal=0,amt=0;
		String type="",accn="";
		for(BankRegister b1:b)
		{
			bal=b1.getBalance();
			type=b1.getType();
			accn=b1.getAcnum();
		}
		if(bal>=amount)
		{
			Transaction t=new Transaction();
			
			Random r3 = new Random();
			int n3 = r3.nextInt(999999);
			String a3=Integer.toString(n3);
	
			LocalDate today = LocalDate.now();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String x=dtf.format(now);  
			t.setCid(cid);
			t.setTid(a3);
			t.setDate(today.toString());
			t.setTime(x);
			t.setTo("self");
			t.setFrom("-");
			t.setPbal(bal);
			
			amt=bal-amount;
			t.setAmt(amount);
			t.setTypetid("withdraw");
			t.setCbal(amt);
			
			int counter = bankregisterdao.withdraw(accn, amt,psswd);
			if(counter>0)
			{
				int c=bankregisterdao.transaction(t);
				mv.addObject("msg", "Withdraw Transaction Succesfull");
				mv.addObject("bal", amt);
				mv.setViewName("bankdisplay");
			}
			else
			{
				mv.addObject("msg","Invalid Credentials, Please Try again ");
				mv.setViewName("withdraw");
			}
		}
		else
		{
			mv.addObject("bal", bal);
			mv.addObject("msg","Insufficient Balance, Account Balance : ");
			mv.setViewName("withdraw");
		}
		
		return mv;
	}
}
