package com.biz.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.simple.service.InoutService;
import com.biz.simple.vo.InoutVO;

@Controller
public class InoutController {

	@Autowired
	InoutService is;
	
	@RequestMapping(value="inout", method=RequestMethod.GET)
	public String inout(Model model) {
		
		String ret = "";
		
		List<InoutVO> ioList = is.getInout();
		
		if(ioList == null) {
			ret = "해당 데이터가 없습니다";
		} else {
			model.addAttribute("LIST",ioList);
			ret = "inout";
		}
		
		return ret;
	}
}
