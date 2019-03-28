package com.biz.email.controller;

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

import com.biz.email.model.MemberVO;
import com.biz.email.service.EmailService;
import com.biz.email.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@Autowired
	EmailService bs;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join() {
		
		return "bodys/join";
	}
	
	@RequestMapping(value="join1",method=RequestMethod.GET)
	public String join1(Model model) {
		
		model.addAttribute("BODY", "JOIN");
		
		return "home";
	}

	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVO memberVO) {
		
		String password = passwordEncoder.encode(memberVO.getM_password());
		
		memberVO.setM_password(password);
		
		mService.insert(memberVO);
		
		return "redirect:/";
	}
	
	
	@ResponseBody
	@RequestMapping(value="id_check",
				method=RequestMethod.POST,
				produces="text/html;charset=utf8")
	public String user_id_check(@RequestParam String m_userid) {
		String ret = "" ;
		
		MemberVO vo = mService.id_check(m_userid);
		if(vo == null) { // id가 없으니 가입 가능
			ret = "사용가능한 아이디 입니다";
		} else {
			ret = " 이미 가입된 아이디 입니다 \n 아이디를 다시 입력해 주세요" ;
		}
		return ret;
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model) {
		
		
		return "bodys/login";
	}
	
	@RequestMapping(value="login1",method=RequestMethod.GET)
	public String login1(Model model) {
		
		model.addAttribute("BODY", "LOGIN");
		
		return "home";
	}

	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO memberVO, 
				HttpSession session,Model model) {
		
		List<MemberVO> retVO = mService.findByUserid(memberVO);
		
		log.debug(retVO.toString());
		if(retVO.size() > 0) { 
			for(MemberVO vo : retVO) {
				if(passwordEncoder.matches(memberVO.getM_password(),vo.getM_password())) {
					memberVO = vo;
					session.setAttribute("LOGIN_INFO", memberVO);
					return null;				
					///return "redirect:/";
				}
			}
			model.addAttribute("LOGIN_FAIL", "PASS");
			return "bodys/login";
			
		} else { 
			model.addAttribute("LOGIN_FAIL", "ID");
			return "bodys/login" ;
		}
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("LOGIN_INFO");

		return "redirect:/";
	}
	
	
	
}