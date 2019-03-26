package com.biz.file.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.BoardVO;
import com.biz.file.model.MemberVO;
import com.biz.file.service.BBSService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes({"boardVO"})
@Controller
@RequestMapping("/bbs")
public class BBSController {

	@Autowired
	BBSService bService;
	
	@ModelAttribute("boardVO")
	public BoardVO newboardVO() {
		return new BoardVO();
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String bbs_list(@ModelAttribute("boardVO") BoardVO boardVO, Model model, SessionStatus Ssession) {
		
		List<BoardVO> bbsList = bService.selectAll();
		
		int lengthP1 = bbsList.size() + 1;
		
		log.debug(""+lengthP1);
		
		model.addAttribute("LENGTH_PLUS1", lengthP1);
		
		model.addAttribute("BBS_LIST", bbsList);
		
		model.addAttribute("BODY","BBS_LIST");
		
		if(boardVO.getB_subject() != null) {
			Ssession.setComplete();
		}
		
		return "home";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String bbs_write(@ModelAttribute("boardVO") BoardVO boardVO, Model model, SessionStatus Ssession, HttpSession session) {
		
		if(boardVO.getB_subject() != null) {
			Ssession.setComplete();
		}
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) {
			model.addAttribute("LOGIN_MSG","LOGIN PLZ");
			return "redirect:/login";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		
		Date d = new Date();
		
		String today = sdf.format(d);
		
		String time = sdf1.format(d);

		boardVO.setB_date(today);
		boardVO.setB_time(time);
		boardVO.setB_userid(memberVO.getM_userid());
		
		model.addAttribute("BODY","BBS_WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String bbs_write(@ModelAttribute("boardVO") @Valid BoardVO boardVO, BindingResult result, Model model, SessionStatus Ssession) {
		
		if(result.hasErrors()) {
			model.addAttribute("BODY","BBS_WRITE");
			return "home";
		} else {
			log.debug(boardVO.toString());
			if(boardVO.getId() == 0) {
				bService.insert(boardVO);
			} else {
				bService.update(boardVO);
			}
//			Ssession.setComplete();
			model.addAttribute("BODY","BBS_LIST");
			return "redirect:/bbs/";
		}
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String bbs_view(@ModelAttribute("boardVO") BoardVO boardVO, Model model, HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) {
			model.addAttribute("LOGIN_MSG","LOGIN PLZ");
			return "redirect:/login";
		} else {
			long id = boardVO.getId();
			
			boardVO = bService.findByIdNUser_id(id, memberVO.getM_userid());
			
			model.addAttribute("BBS",boardVO);
			model.addAttribute("BODY","BBS_VIEW");
			
			return "home";
			
//			if(!bVO.getB_userid().equalsIgnoreCase(memberVO.getM_userid())) {
//				long hit = bVO.getB_hit() + 1;
//				bVO.setB_hit(hit);
//			} else {
//				
//			}
		}
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String bbs_update(@ModelAttribute("boardVO") BoardVO boardVO, Model model) {
	
		boardVO = bService.findById(boardVO.getId());
		
		model.addAttribute("boardVO",boardVO);
		model.addAttribute("BODY","BBS_WRITE");
		model.addAttribute("ACTION","UPDATE");
		
		return "home";	
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String bbs_delete(@RequestParam long id) {
	
		bService.delete(id);
		
		return "redirect:/bbs/";	
	}
}
