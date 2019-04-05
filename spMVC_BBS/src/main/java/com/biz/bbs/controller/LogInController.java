package com.biz.bbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.bbs.model.MemberVO;
import com.biz.bbs.service.LoginService;
import com.biz.bbs.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * JAVA DOCS : 개발이 완료되고 문서화를 시킬때
 * 문서화 Tools을 활용할 수 있도록 작성하는 주석
 * 
 * @author : callor@callor.com
 * @since : 2019-03-01
 * @see : 이 컨트롤러는 사용자 로그인, 로그아웃을 처리하기 위한 파일
 */
@SessionAttributes({"memberVO"})
@Slf4j
@Controller
public class LogInController {
	
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
	/**
	 * 
	 * @param memberVO
	 * @param model
	 * @param session
	 * @param s
	 * @return
	 * @see
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(@RequestParam(required=false) String LOGIN_MSG,@ModelAttribute MemberVO memberVO, Model model, HttpSession session) {
		
		model.addAttribute("LOGIN_MSG",LOGIN_MSG);
		model.addAttribute("BODY","LOGIN_FORM");
		
		return "home";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String loginPOST(@ModelAttribute MemberVO memberVO, Model model, HttpSession session) {
		
		MemberVO vo = lService.getMemberInfo(memberVO);
		
		if(vo != null) {
//			memberVO = vo;
			/*
			 * memberVO의 다른이름인 LOGIN_INFO에 vo를 셋팅해줘야 jsp에서 사용가능
			 */
			session.setAttribute("LOGIN_INFO",vo);
			
		} else {
			
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="login1",method=RequestMethod.POST)
	public String login1(@ModelAttribute MemberVO memberVO, Model model, HttpSession session) {
		
		MemberVO VO = mService.findByUserId(memberVO.getM_userid());
		
		if(VO == null ) {
			return "home";
		} else {
			if(encoder.matches(memberVO.getM_password(), VO.getM_password())) {
				session.setAttribute("LOGIN_INFO",VO);
				return "home";
			} else {
				return "home";
			}
		}
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(@ModelAttribute MemberVO memberVO, HttpSession session, SessionStatus Ssession) {
		
		//session제거(완료, 만료되었다고 표현)
		session.removeAttribute("LOGIN_INFO");
		Ssession.setComplete();
		
		return "redirect:/";
	}
}
