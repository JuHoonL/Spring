package com.biz.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.MemberVO;

@Controller
@SessionAttributes({"LOGIN_INFO"})
public class LogInController {
	/*
	 	@ModelAttribute로 LOGIN_INFO를 선언하고
	 */
	@ModelAttribute("LOGIN_INFO")
	public MemberVO login_info() {
		return new MemberVO();
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(@ModelAttribute("LOGIN_INFO") MemberVO memberVO) {
		return "bodys/login_form";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute("LOGIN_INFO") MemberVO memberVO, Model model) {
		
		memberVO.setM_name("장보고");
		memberVO.setM_addr("청해진");
		memberVO.setM_tel("574-8965");
		
		return "bodys/login_ok";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(@ModelAttribute("LOGIN_INFO") MemberVO memberVO, SessionStatus sessionStatus) {
		
		//session제거(완료, 만료되었다고 표현)
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
}
