package com.biz.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.file.model.MemberVO;

/*
 	Controller에 RequestMapping을 설정하면 페이지를 호출할 주소를
 	그룹으로 묶어서 관리할 수 있다. 단, Mapping주소 앞에 반드시 /로
 	시작해야 한다.
 */
@Controller
@RequestMapping("/member")
/*
 	SessionAttributes는 @ModelAttribute로 선언된 객체를 Session정보 안에 포함시켜서 서로다른 method에서
 	값을 참조할 수 있도록 도와주는 지시어
 */
@SessionAttributes({"memberVO"})
public class MemberController {
	/*
		초기값이 초기화가 안되어서 null이 되어버리는 것을 막는 메서드
	  	현재 이 Controller class에서 @ModelAttribute("memberVO")가 null이면
	  	이 메서드를 실행하게 됌
	 */
	@ModelAttribute("memberVO")
	public MemberVO newMemberVO() {
		return new MemberVO();
//		MemberVO memberVO = new MemberVO();
//		memberVO.setM_userid("test");
//		
//		return memberVO;
	}
	
	//기본적인 방법
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		
		MemberVO vo = new MemberVO();
		
		model.addAttribute("memberVO",vo);
		return "bodys/join_form";
	}
	
	//다른방법
	@RequestMapping(value="/join1", method=RequestMethod.GET)
	public String join(@ModelAttribute("memberVO") MemberVO memberVO) {
		
		return "bodys/join_form";
	}
	
	//오류남
	@RequestMapping(value="/join2", method=RequestMethod.GET)
	public String join() {
		
		return "bodys/join_form";
	}
	
	@RequestMapping(value="/join1",method=RequestMethod.POST)
	public String join(@ModelAttribute("memberVO") MemberVO memberVO, Model model) {
		
		
		return "bodys/join_form";
//		return "redirect:/";
	}
}