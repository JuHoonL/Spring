package com.biz.file.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.MemberVO;
import com.biz.file.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
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
	
	@Autowired
	MemberService mService;
	
	/*
		초기값이 초기화가 안되어서 null이 되어버리는 것을 막는 메서드
	  	현재 이 Controller class에서 @ModelAttribute("memberVO")가 null이면
	  	이 메서드를 실행하게 됌
	 */
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
	
	//다른방법
	//form을 열기위한 method
	@RequestMapping(value="/join1", method=RequestMethod.GET)
	public String join(@ModelAttribute("memberVO") MemberVO memberVO, Model model, HttpSession session, SessionStatus Ssession) {
		
//		if((MemberVO)session.getAttribute("LOGIN_INFO") == null) {
			Ssession.setComplete();
//			log.debug("여기에걸립니까걸립니까걸립니까");
//		}
		
		model.addAttribute("memberVO",memberVO);
		
		model.addAttribute("BODY","JOIN_FORM");
		
		return "home";
	}
	
	//오류남
	@RequestMapping(value="/join2", method=RequestMethod.GET)
	public String join() {
		
		return "bodys/join_form";
	}
	
	//form에서 데이터를 받기위한 method
	//BindingResult는 ModelAttribute와 model 사이에 지정해줘야함 위치가 다르면 400오류가 발생
	@RequestMapping(value="/join1",method=RequestMethod.POST)
	public String join( @Valid @ModelAttribute("memberVO") MemberVO memberVO, BindingResult result, Model model,SessionStatus session) {
		
		/*
		 	VO에 설정 된 constraint조건에 위배된 값이 form으로 부터 전송되어 오면 hasErrorS()는 true를 갖고
		 	조건에 맞는 값이 오면 false를 갖게 된다. 
		 */
		if(result.hasErrors()) {
			log.debug("HasError");
			model.addAttribute("BODY","JOIN_FORM");
			return "home";
		} else {
//			mService.insert(memberVO);
			int ret = mService.save(memberVO);
			
			if(ret < 2 ) {
				return "redirect:/member/mypage";
			}
			// 가입이 완료된 후 memberVO를 세션으로부터 제거하라
			session.setComplete();
			log.debug("No Error");
			return "redirect:/member/mypage";
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