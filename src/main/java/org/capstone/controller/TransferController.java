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
public class TransferController
{
	@Autowired 
	private BankRegisterDao b;

	@RequestMapping(value = "/transferblock/transfer2/{cid}/add1/{acnum}/{acname}/{actype}/{mobile}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid,@PathVariable("acnum") String acnum,
			@PathVariable("acname") String acname,@PathVariable("actype") String actype,@PathVariable("mobile") String mobile,
			@RequestParam("amount") int amount,@RequestParam("psswd") String psswd)
	{
		System.out.println("x");
		Random r1 = new Random();
		int n1 = r1.nextInt(999999);
		String a1=Integer.toString(n1);
		LocalDate today=LocalDate.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		String x=dtf.format(now);
		String acnum1="",cid1="";
		int bal1=0,bal2=0,amt=0,amt2=0;
		List<BankRegister> b1=b.get1(cid);
		for(BankRegister b2:b1)
		{
			acnum1=b2.getAcnum();
			bal1=b2.getBalance();
		}
		List<BankRegister> b2=b.get(acnum);
		for(BankRegister b3:b2)
		{
			cid1=b3.getCid();
			bal2=b3.getBalance();
		}
		amt=bal1-amount;
		Transaction t=new Transaction();
		System.out.println(cid);
		t.setCid(cid);
		t.setTid(a1);
		t.setDate(today.toString());
		t.setTime(x);
		t.setTo(acnum1);
		t.setFrom("-");
		t.setPbal(bal1);
		t.setAmt(amount);
		t.setTypetid("transfer");
		t.setCbal(amt);
		amt2=bal2+amount;
		Transaction t1=new Transaction();
		System.out.println(cid1);
		t1.setCid(cid1);
		t1.setTid(a1);
		t1.setDate(today.toString());
		t1.setTime(x);
		t1.setTo("-");
		t1.setFrom(acnum);
		t1.setPbal(bal2);
		t1.setAmt(amount);
		t1.setTypetid("deposit");
		t1.setCbal(amt2);
		if(bal1>=amount)
		{
			int c=b.withdraw(acnum1, amt, psswd);
			if(c>0)
			{
			 int c1=b.transfer(acnum, amt2);
				if(c1>0)
				{
					int c3=b.transaction(t);
					int c4=b.transaction(t1);
					mv.addObject("msg", "Transfered Succesffuly");
					mv.setViewName("bankdisplay2");
				}
				else
				{
					mv.addObject("msg", "Recipient Account Number not Found");
					mv.setViewName("bankdisplay2");
				}
			}
			else
			{
				mv.addObject("msg", "Invalid Password.Please Try again");
				mv.setViewName("bankdisplay2");
			}
		}
		else
		{
			mv.addObject("msg", "Insufficient Balance, Account Balance:");
			mv.addObject("bal", bal1);
			mv.setViewName("bankdisplay2");
		}
		return mv;
	}
}