package org.capstone.controller;

import java.util.List;


import org.capstone.dao.BankRegisterDao;
import org.capstone.model.BankRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BalanceController 
{
	@Autowired
	private BankRegisterDao bankregisterdao;
	@RequestMapping(value = "/balance/{cid}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid) {
		List<BankRegister> b= bankregisterdao.display(cid);
		for(BankRegister b1:b)
		{
			mv.addObject("bal",b1.getBalance());
		}
		mv.setViewName("balance");
	

		return mv;
	}
}
