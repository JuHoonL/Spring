package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.bbs.model.BBsVO;
import com.biz.bbs.service.BBsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	BBsService bService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces="text/html; charset=utf8")
	public String home(Model model) {
		
		List<BBsVO> bbsList = bService.selectAll();
		
		bbsList = bService.pageList(1);
		
		model.addAttribute("BBS_LIST",bbsList);
		model.addAttribute("BODY","BBS_LIST");
		
		return "home";
	}
	
	
	
}
