package org.capstone.controller;

import java.util.List;

import org.capstone.dao.BankRegisterDao;
import org.capstone.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipientController 
{
	@Autowired
	private BankRegisterDao b;
	@RequestMapping(value = "/transferblock/transfer2/{cid}/{acnum}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid,
			@PathVariable("acnum") String acnum) 
	{
		List<Transfer> tlist=b.display1(cid,acnum);
		System.out.println("demo1");
		mv.addObject("tlist", tlist);
		mv.setViewName("displayrecipi");
		
		return mv;
		
	}

}
