package org.capstone.controller;

import java.util.List;

import org.capstone.dao.BankRegisterDao;
import org.capstone.model.BankRegister;
import org.capstone.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TransferBlockController 
{
	@Autowired
	private BankRegisterDao b;
	@RequestMapping(value = "/transferblock/{cid}")
	public ModelAndView login(ModelAndView mv,@PathVariable("cid") String cid) {
		String x1="access";
		int c2 = b.validatetransfer(cid,x1);
		if(c2>0)
		{
			List<Transfer> tlist=b.display1(cid);
			if(tlist.isEmpty())
			{
				mv.addObject("msg", " No Recipients,add Recipients to transfer money");
				mv.addObject("cid", cid);
				mv.setViewName("transfer1");
			}
			else
			{
				mv.addObject("tlist",tlist);
				mv.addObject("cid", cid);
				mv.setViewName("displayrecipient");
			}
		}
		else
		{
			mv.addObject("msg", " Your Transfer Transaction is blocked by Admin.");
			mv.setViewName("bankdisplay2");
		}
		return mv;
	}
}
