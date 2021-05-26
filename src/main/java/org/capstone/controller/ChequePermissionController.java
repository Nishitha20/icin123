package org.capstone.controller;

import java.io.IOException;
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
public class ChequePermissionController 
{
	@Autowired
	private RequestDao r;
	@RequestMapping(value = "/cheque")
	public ModelAndView readCasual(ModelAndView model) throws IOException {
		List<Request> rlist = r.read();
		model.addObject("msg", "Cheque Book Permissions for Registered Users");
		model.addObject("rlist", rlist);
		model.setViewName("displaycheque");
		return model;
	}
	@Autowired
	private RequestDao r1;
	@RequestMapping(value = "/rblock1/{cid}")
	public ModelAndView readCasual1(ModelAndView model,@PathVariable("cid") String cid) throws IOException {
		String x="access";
		int c=r1.updaterblock1(cid,x);
		
		if(c>0)
		{
			model.addObject("msg", "Granted Cheque Book");
			model.setViewName("bankdisplay2");
		}
		return model;
	}
	
	@Autowired
	private RequestDao r2;
	@RequestMapping(value = "/rblock2/{cid}")
	public ModelAndView readCasual2(ModelAndView model,@PathVariable("cid") String cid) throws IOException {
		String x="deny";
		int c=r2.updaterblock2(cid,x);
		if(c>0)
		{
			model.addObject("msg", "Denied Cheque book request");
			model.setViewName("bankdisplay2");
		}
		return model;
	}
}