package org.capstone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capstone.dao.BankRegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankLoginController 
{
	@Autowired
	private BankRegisterDao bankregisterDao;
	@RequestMapping(value = "/banklogin", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(@RequestParam("cid") String cid, @RequestParam("psswd") String pass,HttpServletRequest request, HttpServletResponse response,
			ModelAndView mv) {
		String x="access";
		int counter = bankregisterDao.validate1(cid,pass,x);
		System.out.println(counter);
		if (counter > 0) 
		{
			int c=bankregisterDao.validate(cid,pass);
			if(c>0)
			{
			mv.addObject("msg", "Login Successful.");
			mv.addObject("cid", cid);
			mv.setViewName("customerhome");
			}
			else
			{
				mv.addObject("msg", " Invalid .Try again.");
				mv.setViewName("banklogin");
			}
			
		} 
		else 
		{
			mv.addObject("msg", " Your account is blocked by Admin.");
			mv.setViewName("banklogin");
		}

		return mv;
	}
}