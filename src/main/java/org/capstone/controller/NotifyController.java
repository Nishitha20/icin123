package org.capstone.controller;

import java.util.List;

import org.capstone.dao.BankRegisterDao;
import org.capstone.dao.RequestDao;
import org.capstone.model.BankRegister;
import org.capstone.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class NotifyController 
{
	@Autowired
	private RequestDao rdao;
	@RequestMapping(value = "/notify/{cid}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid) {
		List<Request> b= rdao.display(cid);
		System.out.println(b);
		if(b.isEmpty())
		{
			mv.addObject("msg", "No Notifications");
		}
		else
		{
		String x="";
		for(Request b1:b)
		{
			x=b1.getRblock();
		}
		System.out.println(x);
		if(x.equals("deny"))
		{
			mv.addObject("msg", "Your request for checkbook is denied");
			int c1=rdao.delete(cid);
		}
		else if(x.equals("access"))
		{
			mv.addObject("msg", "Your request for checkbook is accepted.Will be delivered within a week");
			int c1=rdao.delete(cid);
		}
		else
		{
			mv.addObject("msg", "Your request for checkbook is Pending");
		}
		
		}
		mv.setViewName("bankdisplay2");
		return mv;
	}
}
