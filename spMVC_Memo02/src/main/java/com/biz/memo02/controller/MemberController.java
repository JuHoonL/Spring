package com.biz.memo02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo02.service.MemberService;
import com.biz.memo02.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@RequestMapping(value="member", method=RequestMethod.GET)
	public String member(Model model) {
		
		model.addAttribute("CITIES",mService.getCities());
		model.addAttribute("HOBBIES",mService.getHobbies());
		model.addAttribute("BODY","MEMBER_JOIN");
		model.addAttribute("memberVO",new MemberVO());
		
		return "home";
	}
	
	/*
	 * @ModelAttribute Annotation은 form으로 부터 전송되어온 데이터들을 VO에 자동으로
	 *  mapping 시키는 command Annotation이다.
	 *  
	 *  이 Annotation은 반드시 VO앞에 위치시켜야한다.
	 *  
	 *  절대 Model앞에 놓으면 안된다.
	 */
	@RequestMapping(value="member", method=RequestMethod.POST)
	public String member(@ModelAttribute MemberVO memberVO, Model model) {
		
		int ret = mService.insert(memberVO);
		
		model.addAttribute("BODY","MEMBER_VIEW");
		model.addAttribute("MEMBER",memberVO);
		
		return "home";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(Model model) {
		
		model.addAttribute("BODY","LOGIN");
		model.addAttribute("memberVO",new MemberVO());
		
		return "home";
		
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO memberVO, Model model, HttpSession session) {
		
		MemberVO vo = mService.userCheck(memberVO);
		
		String retMsg = "";
		
		if(vo == null) {
			retMsg = "아이디나 비밀번호가 일치하지않습니다.";
		} else {
			retMsg = vo.getM_name() + "님 반갑습니다.";
			session.setAttribute("LOGIN", vo);
		}
		System.out.println(retMsg);
		
		
		return "redirect:memo_home";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("LOGIN");
		return "redirect:memo_home";
	}
}
