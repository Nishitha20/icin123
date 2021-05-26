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
public class WithdrawBlockController 
{
	@Autowired
	private BankRegisterDao b;
	@RequestMapping(value = "/withdrawblock/{cid}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid) {
		String x1="access";
		int c2 = b.validatewithdraw(cid,x1);
		if(c2>0)
		{
			mv.addObject("cid", cid);
			mv.setViewName("withdraw");
		}
		else
		{
			mv.addObject("msg", " Your Withdraw Transaction is blocked by Admin.");
			mv.setViewName("bankdisplay2");
		}
		return mv;
	}
}
