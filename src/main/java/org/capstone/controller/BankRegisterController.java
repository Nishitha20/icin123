package org.capstone.controller;

import java.util.Random;

import org.capstone.dao.BankRegisterDao;
import org.capstone.model.BankRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankRegisterController 
{
	@Autowired
	private BankRegisterDao bankregisterDao;
	
	@RequestMapping(value = "/bankregister", method = RequestMethod.POST)
	public ModelAndView createFormal(@RequestParam("fname") String fname,
			@RequestParam("lname") String lname,@RequestParam("uname") String uname,
			@RequestParam("psswd") String psswd,@RequestParam("dob") String dob,
			@RequestParam("gender") String gender,@RequestParam("email") String email,
			@RequestParam("mobile") String mobile,@RequestParam("address") String address,
			@RequestParam("type") String type,ModelAndView mv) 
	{
		Random r1 = new Random();
		int n1 = r1.nextInt(999999);
		String a1=Integer.toString(n1);
		
		Random r2 = new Random();
		int n2 = r2.nextInt(999999);
		String a2=Integer.toString(n2);
		String acnum=a1+a2;
		
		Random r3 = new Random();
		int n3 = r3.nextInt(999999);
		String a3=Integer.toString(n3);
		
		int bal=0;
		String x="access";
		BankRegister b=new BankRegister();
		b.setFname(fname);
		b.setLname(lname);
		b.setUname(uname);
		b.setPsswd(psswd);
		b.setDob(dob);
		b.setGender(gender);
		b.setEmail(email);
		b.setMobile(mobile);
		b.setAddress(address);
		b.setType(type);
		b.setAcnum(acnum);
		b.setCid(a3);
		b.setBalance(bal);
		b.setBlock(x);
		b.setWblock(x);
		b.setDblock(x);
		b.setTblock(x);
		int counter = bankregisterDao.register(b);

		if (counter > 0) 
		{
			mv.addObject("msg", "User Registered successfully.");
			mv.addObject("acnum", acnum);
			mv.addObject("cid", a3);
			mv.setViewName("viewmsg");
		} else {
			mv.addObject("msg", "Error- check the console log.");
			mv.setViewName("bankregister");
		}

		return mv;
	}
}

