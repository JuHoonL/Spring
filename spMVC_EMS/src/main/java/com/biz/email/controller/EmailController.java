package com.biz.email.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.model.EmailVO;
import com.biz.email.model.MemberVO;
import com.biz.email.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmailController {

	@Autowired
	EmailService es;
	
	@RequestMapping(value="m_request", method=RequestMethod.GET)
	public String email_List(Model model, HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		List<EmailVO> eList = es.findByUserid(memberVO.getM_mailaddress());
		
		model.addAttribute("EMAILLIST",eList);
		model.addAttribute("BODY","REQUEST");
		
		return "home";
	}
	
	@RequestMapping(value="view", method=RequestMethod.POST)
	public String email_view(@RequestParam String id, Model model) {
		
		EmailVO emailVO = es.findByid(id);
		
		model.addAttribute("BOOK",emailVO);
		
		return "bodys/mail_form";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String email_update(@ModelAttribute EmailVO emailVO) {
		
		int ret = es.update(emailVO);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String email_delete(@RequestParam String id) {
		
		int ret = es.delete(id);
		
		return "OK";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String email_insert(@ModelAttribute EmailVO emailVO, Model model) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
		
		Date d = new Date();
		
		String today = sdf.format(d);
		String time = sdf.format(d);
		
		emailVO.setS_date(today);
		emailVO.setS_time(time);
		
		model.addAttribute("EMAIL",emailVO);
		model.addAttribute("BODY","INSERT");
		
		return "home";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String email_insert(@ModelAttribute EmailVO emailVO, 
					@RequestParam("file1") MultipartFile s_file1,
					@RequestParam("file2") MultipartFile s_file2) {
		
		if(s_file1  != null) {
			String file1 = es.upload(s_file1);
			emailVO.setS_file1(file1);
		}
		if(s_file2  != null) {
			String file2 = es.upload(s_file2);
			emailVO.setS_file2(file2);
		}
		
		int ret = es.insert(emailVO);
		
		return "redirect:/m_request";
	}
}
