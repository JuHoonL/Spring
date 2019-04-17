package com.biz.file.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.service.BBSService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	BBSService bservice;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces="text/html; charset=utf8")
	public String home(Model model, HttpSession session, SessionStatus Ssession) {
		
		
		log.debug("HOME CONTROLLER START!!");
		
//		model.addAttribute("BBS_LIST",bservice.selectAll());
//		model.addAttribute("BODY","BBS_LIST");
		
		return "redirect:/get_page";
	}
	
}
