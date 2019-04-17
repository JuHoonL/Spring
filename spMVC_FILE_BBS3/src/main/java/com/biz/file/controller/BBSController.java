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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.file.model.BoardVO;
import com.biz.file.model.MemberVO;
import com.biz.file.service.BBSService;
import com.biz.file.service.FileUpService;
import com.biz.file.service.PageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes({"boardVO"})
@Controller
@RequestMapping("/bbs")
public class BBSController {

	@Autowired
	BBSService bService;
	
	@Autowired
	FileUpService fus;
	
	@Autowired
	PageService pService;
	
	@ModelAttribute("boardVO")
	public BoardVO newboardVO() {
		return new BoardVO();
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String bbs_list(@ModelAttribute("boardVO") BoardVO boardVO, Model model, SessionStatus Ssession) {
		
		List<BoardVO> bbsList = bService.selectAll();
		
		int lengthP1 = bbsList.size() + 1;
		
		log.debug(""+lengthP1);
		
		bbsList = pService.pageList(1, 10);
		
		model.addAttribute("LENGTH_PLUS1", lengthP1);
		
		model.addAttribute("BBS_LIST", bbsList);
		
		model.addAttribute("BODY","BBS_LIST");
		
		if(boardVO.getB_subject() != null) {
			Ssession.setComplete();
		}
		
		return "home";
	}
	
	@RequestMapping(value="/tag",method=RequestMethod.GET)
	public String bbs_tag(@ModelAttribute("boardVO") BoardVO boardVO, Model model, SessionStatus Ssession, HttpSession session) {
		
		Ssession.setComplete();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO != null) {
			boardVO.setB_userid(memberVO.getM_userid());
		} else {
			return "redirect:/";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		
		Date d = new Date();
		
		String today = sdf.format(d);
		
		String time = sdf1.format(d);

		boardVO.setB_date(today);
		boardVO.setB_time(time);
		
		model.addAttribute("BODY","BBS_TAG_WRITE");
		model.addAttribute("bbsVO",boardVO);
		
		return "home";
	}
	
	@RequestMapping(value="/write_tag",method=RequestMethod.POST)
	public String bbs_write_tag(@ModelAttribute("boardVO") BoardVO boardVO, MultipartFile b_file) {
		
		if(!b_file.isEmpty()){
			
			String saveFile = fus.upload(b_file);
			boardVO.setB_image(saveFile);
			
		}
		
		bService.insert(boardVO);
		
		return "redirect:/get_page";
	}
	
	@RequestMapping(value="/drag",method=RequestMethod.GET)
	public String bbs_drag(@ModelAttribute("boardVO") BoardVO boardVO, Model model, SessionStatus Ssession, HttpSession session) {
		
		Ssession.setComplete();
		
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
			if(boardVO.getId() == 0) {
				bService.insert(boardVO);
			} else {
				bService.update(boardVO);
			}
			Ssession.setComplete();
			model.addAttribute("BODY","BBS_LIST");
			return "redirect:/get_page";
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
		
		return "redirect:/get_page";	
	}
	
	@ResponseBody
	@RequestMapping(value="/bbs_files",method=RequestMethod.POST)
	public List<String> files(MultipartHttpServletRequest files) {
		
		List<String> fileNames = fus.uploads(files);
		
		for(String file : fileNames) {
			log.debug("파일이름 : " + file );
		}
		
		return fileNames;
	}
}
