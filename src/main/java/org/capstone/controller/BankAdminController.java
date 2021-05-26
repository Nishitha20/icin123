package org.capstone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capstone.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankAdminController 
{
	@Autowired
	private AdminDao admin;
	@RequestMapping(value = "/bankadminlogin", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(@RequestParam("aid") String aid, @RequestParam("psswd") String pass,HttpServletRequest request, HttpServletResponse response,
			ModelAndView mv) 
	{
		int c=admin.validateadmin(aid,pass);
		if(c>0)
		{
			mv.addObject("msg", "Login Successful.");
			mv.setViewName("bankadminhome");
		}
		else
		{
			mv.addObject("msg", " Invalid .Try again.");
			mv.setViewName("bankadminlogin");
		}
		return mv;
	}
}