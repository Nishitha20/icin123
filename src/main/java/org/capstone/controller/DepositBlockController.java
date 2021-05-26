package org.capstone.controller;

import org.capstone.dao.BankRegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class DepositBlockController {
	@Autowired
	private BankRegisterDao b;
	@RequestMapping(value = "/depositblock/{cid}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid) {
		System.out.println("depo1");
		String x="access";
		int counter = b.validatedeposit(cid,x);
		System.out.println(counter);
		if(counter>0)
		{
			mv.addObject("cid", cid);
			mv.setViewName("deposit");
		}
		else
		{
			mv.addObject("msg", " Your Deposit Transaction is blocked by Admin.");
			mv.setViewName("bankdisplay2");
		}
		return mv;
	}
	
}
