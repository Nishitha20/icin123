package org.capstone.controller;

import org.capstone.dao.BankRegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisplayController 
{
	@Autowired
	private BankRegisterDao b;
	@RequestMapping(value = "/transferblock/transfer1/{cid}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid)
	{
		mv.addObject("cid", cid);
		mv.setViewName("transfer");
		return mv;
	}
}
