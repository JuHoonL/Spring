package com.biz.ajax01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ajax01.model.DeptVO;
import com.biz.ajax01.service.DeptService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	DeptService ds;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		List<DeptVO> dList = ds.deptGetList();
		
		model.addAttribute("LIST",dList);
		
		return "home";
	}
	
	@RequestMapping(value = "home2", method = RequestMethod.GET)
	public String home2(Model model) {
		
		List<DeptVO> dList = ds.deptGetList();
		
		model.addAttribute("LIST",dList);
		
		return "home2";
	}
}
