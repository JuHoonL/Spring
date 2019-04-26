package com.biz.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rent.model.JUserVO;
import com.biz.rent.service.JUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	JUserService uService;
	
	@RequestMapping(value="/s_list/{s_string}",method=RequestMethod.GET)
	public String search_list(@PathVariable(value="s_string", required=false) String s_string, Model model) {
		
		List<JUserVO> userlist = uService.getSearchList(s_string);
		
		model.addAttribute("LIST",userlist);
		return "rent_body/user_s_list";
	} 
	
}
