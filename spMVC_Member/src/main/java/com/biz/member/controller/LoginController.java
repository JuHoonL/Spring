package com.biz.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biz.member.model.MemberVO;
import com.biz.member.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService ms;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="login-old", method=RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member-home");
		mv.addObject("BODY", "LOGIN");
		
		return mv;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(Model model, String LOGIN_MSG) {
		
		model.addAttribute("BODY", "LOGIN-FORM");
		model.addAttribute("LOGIN_MSG", LOGIN_MSG);
		
		return "member-home";
	}
	
	/*
		로그인, 로그아웃을 처리할 method에는 HttpSession 클래스를 매개변수로 설정해 두어야 한다.
	*/
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO membervo, HttpSession session, Model model) {
		
		String userid = membervo.getM_userid();
		String password = membervo.getM_password();
		
//		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(16);
		
		List<MemberVO> mList = ms.loginCheck(userid);
		
		boolean login_ok = false;
		if(mList != null ) {
			for(MemberVO vo : mList) {
				
				//vo에 담겨있는 password는 Bcrypt 암호문이므로 비교문 불가
	//			if(vo.getM_password() == password) {
	//				login_ok = true;
	//				break;
	//			}
				
				//그래서 BCrypt 클래스에 있는 암호 비교 method를 이용해서 값을 비교해야한다.
				if(passwordEncoder.matches(password,vo.getM_password())) {
					login_ok = true;
					membervo = vo;
					if(vo.getM_name().equals("홍길동")) {
						membervo.setM_role("ADMIN");
					} else {
						membervo.setM_role("USER");
					}
					break;
				}
			}
		}
		
		String ret = "redirect:/";
		
//		if(!login_ok) {
//			model.addAttribute("LOGIN","FAIL");
//			ret = "redirect:login";
//		}
		
		if(login_ok) {
			session.setAttribute("LOGIN_INFO", membervo);
			
		}else {
			model.addAttribute("LOGIN_MSG","FAIL");
			ret = "redirect:login";
		}
		
		return ret;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		// 혹시 모를 시스템에서 사용하는 세션 정보가 있을 경우에 login정보만 삭제된 것처럼 null로 설정
//		session.setAttribute("LOGIN", null);
		
		// 아예 세션값을 삭제
		session.removeAttribute("LOGIN_INFO");
		
		// 모든 session정보를 삭제
//		session.invalidate();
		
		return "redirect:/";
	}
}
