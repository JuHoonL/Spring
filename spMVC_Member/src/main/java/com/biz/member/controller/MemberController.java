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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biz.member.model.MemberVO;
import com.biz.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join(Model model) {
		
		model.addAttribute("BODY","JOIN-FORM");
		
		return "member-home";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVO vo, Model model) {
		
		log.debug(vo.toString());
		
		/* 비밀번호 항목 암호화과정 */
		
		// 일반적인 BCrypt클래스 사용해서 암호화하는 과정
		// (생성자에 4부터 31까지 임의의 정수를 포함할 수 있고 생략할 경우 10이 적용된다.(권장숫자 16)
//		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(16);
		
		String bcPassword = passwordEncoder.encode(vo.getM_password());
		
		vo.setM_password(bcPassword);
		
		ms.insert(vo);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="id-check", method=RequestMethod.POST, produces="text/plan; charset=utf8")
	public String id_check(@RequestParam String m_userid, Model model) {
		
		String ret = "";
		
		MemberVO vo = ms.findById(m_userid);
		
		if(vo == null) {
			ret = "사용할 수 있는 ID 입니다.";
		} else {
			ret = "이미 등록된 ID 입니다.";
		}
		
		return ret;
	}
	
	@RequestMapping(value="login-old", method=RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member-home");
		mv.addObject("BODY", "LOGIN");
		
		return mv;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(Model model, String LOGIN) {
		
		model.addAttribute("BODY", "LOGIN-FORM");
		model.addAttribute("LOGIN", LOGIN);
		
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
					break;
				}
			}
		}
		
		String ret = "redirect:/";
		
		if(!login_ok) {
			model.addAttribute("LOGIN","FAIL");
			ret = "redirect:login";
		}
		
		return ret;
	}
	
}
