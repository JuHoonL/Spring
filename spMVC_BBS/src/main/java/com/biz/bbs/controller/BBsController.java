package com.biz.bbs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.bbs.model.BBsVO;
import com.biz.bbs.model.MemberVO;
import com.biz.bbs.service.BBsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BBsController {

	@Autowired
	BBsService bService;
	
	@ModelAttribute("bbsVO")
	public BBsVO newBBsVO() {
		BBsVO bbsVO = new BBsVO();
//		bbsVO.setB_userid("gildong@naver.com");
		
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter fdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter ftime = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		bbsVO.setB_date(fdate.format(lt));
		bbsVO.setB_time(ftime.format(lt));
		
		return bbsVO;
	}
	
	@RequestMapping(value="view", method=RequestMethod.GET)
	public String bbs_write(@RequestParam long id, Model model) {
		
		BBsVO bbsVO = bService.findById(id);
		
		model.addAttribute("BODY","BBS_VIEW");
		model.addAttribute("BBS",bbsVO);
		
		return "home";
	}
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String bbs_write(@ModelAttribute("bbsVO") BBsVO bbsVO, Model model, HttpSession session) {
		
		MemberVO vo = (MemberVO)session.getAttribute("LOGIN_INFO");
		if(vo == null) return "redirect:/login";
		
		bbsVO.setB_userid(vo.getM_userid());
		model.addAttribute("BODY","BBS_WRITE");
		model.addAttribute("bbsVO",bbsVO);
		
		return "home";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String bbs_write(@ModelAttribute("bbsVO") BBsVO bbsVO, SessionStatus sessionS) {
		
		int ret = bService.insert(bbsVO);
		
		sessionS.setComplete();
		
		return "redirect:/";
	}
	
	//VO형태로 id 값 받는 것으로 본문에서 jquery문 필요없음
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String bbs_update(@ModelAttribute("bbsVO") BBsVO bbsVO, SessionStatus sessionS, Model model) {
		
		bbsVO = bService.findById(bbsVO.getId());
		
		model.addAttribute("ACTION","UPDATE");
		model.addAttribute("BODY","BBS_WRITE");
		model.addAttribute("bbsVO",bbsVO);
		
		return "home";
	}
	
	//jquery문으로 id값을 보내서 id값을 받는 것
	@RequestMapping(value="update1", method=RequestMethod.GET)
	public String bbs_update1(@RequestParam long id, Model model) {
		
		BBsVO bbsVO = bService.findById(id);
		
		model.addAttribute("ACTION","UPDATE");
		model.addAttribute("BODY","BBS_WRITE");
		model.addAttribute("bbsVO",bbsVO);
		
		return "home";
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String bbs_save(@ModelAttribute("bbsVO") BBsVO bbsVO, SessionStatus sessionS) {
		
		log.debug(""+bbsVO.getId());
		
		if(bbsVO.getId() == 0) {
			int ret = bService.insert(bbsVO);
		}else {
			int ret = bService.update(bbsVO);
		}
		sessionS.setComplete();
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String bbs_delete(@RequestParam long id) {
		int ret = bService.delete(id);
		
		return "redirect:/";
	}
}
