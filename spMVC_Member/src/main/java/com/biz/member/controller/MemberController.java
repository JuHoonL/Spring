package com.biz.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.member.model.MemberVO;
import com.biz.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join(Model model) {
		
		model.addAttribute("BODY","JOIN-FORM");
		
		return "member-home";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVO vo, Model model) {
		
		log.debug(vo.toString());
		
		ms.insert(vo);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="id-check", method=RequestMethod.POST, produces="text/plan; charset=utf8")
	public String id_check(String m_userid, Model model) {
		
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
