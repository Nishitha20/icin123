package org.capstone.controller;

import java.util.List;

import org.capstone.dao.BankRegisterDao;
import org.capstone.dao.TransactionDao;
import org.capstone.model.BankRegister;
import org.capstone.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestController 
{
	@Autowired
	private BankRegisterDao bankregisterdao;
	@RequestMapping(value = "/request/{cid}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid) {
		List<BankRegister> b= bankregisterdao.get1(cid);
		for(BankRegister b1:b)
		{
			mv.addObject("acname", b1.getFname());
			mv.addObject("acnum", b1.getAcnum());
			mv.addObject("type", b1.getType());
			mv.addObject("address", b1.getAddress());
			mv.addObject("mobile", b1.getMobile());
			mv.addObject("cid", cid);
		}
		mv.setViewName("request");
		return mv;
	}
	
	@Autowired
	private BankRegisterDao  bankregisterdao1;
	@RequestMapping(value = "/request/yes/{cid}")
	public ModelAndView login1(ModelAndView mv,@PathVariable("cid") String cid) {
		List<BankRegister> b= bankregisterdao1.get1(cid);
		String acname="",acnum="", type="",address="",mobile="";
		for(BankRegister b1:b)
		{
			acname=b1.getFname();
			acnum= b1.getAcnum();
			type=b1.getType();
			address= b1.getAddress();
			mobile=b1.getMobile();
		}
		String x="request";
		Request r=new Request();
		r.setCid(cid);
		r.setAcname(acname);
		r.setAcnum(acnum);
		r.setType(type);
		r.setAddress(address);
		r.setMobile(mobile);
		r.setRblock(x);
		int counter=bankregisterdao1.request(r);
		if(counter>0)
		{
			mv.setViewName("requestdisplay");
		}
		return mv;
	}
}
