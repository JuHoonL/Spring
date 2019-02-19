package com.biz.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.simple.service.InoutService;
import com.biz.simple.vo.InoutVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IoListController {

	@Autowired
	InoutService ios;
	
	@RequestMapping(value="IOList", method=RequestMethod.GET)
	public String iolist(Model model) {
		
		List<InoutVO> iolist = ios.getIoList();
		
		model.addAttribute("IOLIST", iolist);
		
		return "ioList";
	}
}
