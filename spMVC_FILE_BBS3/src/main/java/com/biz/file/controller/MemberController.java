package com.biz.file.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.MemberVO;
import com.biz.file.service.LoginService;
import com.biz.file.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/member")
@SessionAttributes({"memberVO"})
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@Autowired
	LoginService lService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@ModelAttribute("memberVO")
	public MemberVO newMemberVO() {
		return new MemberVO();
	}
	
	//기본적인 방법
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		
		MemberVO vo = new MemberVO();
		
		model.addAttribute("memberVO",vo);
		return "bodys/join_form";
	}
	
	//form을 열기위한 method
	@RequestMapping(value="/join1", method=RequestMethod.GET)
	public String join(@ModelAttribute("memberVO") MemberVO memberVO, Model model, HttpSession session, SessionStatus Ssession) {
		
//		Ssession.setComplete();
		
		model.addAttribute("memberVO",memberVO);
		
		model.addAttribute("BODY","JOIN_FORM");
		
		return "home";
	}
	
	//form에서 데이터를 받기위한 method
	@RequestMapping(value="/join1",method=RequestMethod.POST)
	public String join( @Valid @ModelAttribute("memberVO") MemberVO memberVO, BindingResult result, Model model,SessionStatus session) {
		
		if(result.hasErrors()) {
			log.debug("HasError");
			model.addAttribute("BODY","JOIN_FORM");
			return "home";
		} else {
			int ret = mService.save(memberVO);
			
			if(ret < 2 ) {
				return "redirect:/member/mypage";
			}
			// 가입이 완료된 후 memberVO를 세션으로부터 제거하라
			session.setComplete();
			log.debug("No Error");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String my_page(@ModelAttribute("memberVO") MemberVO memberVO, Model model, HttpSession session, SessionStatus Ssession) {
		
		MemberVO loginVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		model.addAttribute("memberVO",loginVO);
		model.addAttribute("BODY","JOIN_FORM");
		
		return "home";
	}
	
	
}