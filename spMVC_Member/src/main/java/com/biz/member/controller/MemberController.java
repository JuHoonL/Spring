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
	
}
