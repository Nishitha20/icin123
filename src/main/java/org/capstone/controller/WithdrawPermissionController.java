package org.capstone.controller;

import java.io.IOException;
import java.util.List;

import org.capstone.dao.BankRegisterDao;
import org.capstone.model.BankRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class WithdrawPermissionController {
	@Autowired
	private BankRegisterDao b;
	@RequestMapping(value = "/wblock")
	public ModelAndView readCasual(ModelAndView model) throws IOException {
		List<BankRegister> blist = b.read();
		model.addObject("msg", "Withdraw Permissions for Registered Users");
		model.addObject("blist", blist);
		model.setViewName("displaywithdraw");
		return model;
	}
	
	@Autowired
	private BankRegisterDao b1;
	@RequestMapping(value = "/wblock1/{cid}")
	public ModelAndView readCasual1(ModelAndView model,@PathVariable("cid") String cid) throws IOException {
		String x="deny";
		int c=b1.updatewblock1(cid,x);
		if(c>0)
		{
			model.addObject("msg", "Blocked Successfully");
			model.setViewName("bankdisplay2");
		}
		return model;
	}
	
	@Autowired
	private BankRegisterDao b2;
	@RequestMapping(value = "/wblock2/{cid}")
	public ModelAndView readCasual2(ModelAndView model,@PathVariable("cid") String cid) throws IOException {
		String x="access";
		int c=b1.updatewblock2(cid,x);
		if(c>0)
		{
			model.addObject("msg", "Unblocked Successfully");
			model.setViewName("bankdisplay2");
		}
		return model;
	}
	
}
