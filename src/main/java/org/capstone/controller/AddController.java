package org.capstone.controller;

import java.util.List;

import org.capstone.dao.BankRegisterDao;
import org.capstone.model.BankRegister;
import org.capstone.model.Request;
import org.capstone.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AddController 
{
	@Autowired
	private BankRegisterDao  bankregisterdao1;
	@RequestMapping(value = "/transferblock/transfer1/add/{cid}")
	public ModelAndView login1(ModelAndView mv,@PathVariable("cid") String cid,
			@RequestParam("mobile") String mobile,
			@RequestParam("accn2") String accn2,
			@RequestParam("name") String name,@RequestParam("type") String type) {
		int c=bankregisterdao1.validaterecipient(accn2,name,mobile);
		if(c>0)
		{
		Transfer t=new Transfer();
		t.setCid(cid);
		t.setAcname(name);
		t.setAcnum(accn2);
		t.setActype(type);
		t.setMobile(mobile);
		int counter=bankregisterdao1.enterrecipient(t);
		if(counter>0)
		{
			mv.addObject("msg", "Recipient Added Succesfully.Click On transfer tab to send amount");
			mv.setViewName("bankdisplay2");
		}
		}
		else
		{
			mv.addObject("msg", "No Recipient found with entered details.Enter valid recipient Details");
			mv.setViewName("bankdisplay2");
		}
		return mv;
	}

}
