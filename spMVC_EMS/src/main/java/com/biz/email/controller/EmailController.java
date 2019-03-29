package com.biz.email.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.biz.email.model.EmailVO;
import com.biz.email.model.MemberVO;
import com.biz.email.service.EmailService;
import com.biz.email.service.SendMailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmailController {

	@Autowired
	EmailService es;
	
	@Autowired
	SendMailService sms;
	
	@RequestMapping(value="m_request", method=RequestMethod.GET)
	public String email_mList(Model model, HttpSession session, @RequestParam String m_id) {
		
		List<EmailVO> eList = new ArrayList<EmailVO>();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) return "redirect:/";
		
		log.debug(m_id);
		
		if(m_id.equalsIgnoreCase("send-message")) {
			eList = es.findByFROMUserid(memberVO.getM_mailaddress());
			model.addAttribute("SNR","SEND");
		}
		
		if(m_id.equalsIgnoreCase("request-message")){
			eList = es.findByTOUserid(memberVO.getM_mailaddress());
			model.addAttribute("SNR","REQUEST");
		}
		
		if(memberVO.getM_userid().equalsIgnoreCase("juhoon12")) {
			eList = es.sellectAll();
		}
		
		model.addAttribute("EMAILLIST",eList);
		model.addAttribute("BODY","REQUEST");
		
		return "home";
	}
	
	@RequestMapping(value="e_request", method=RequestMethod.GET)
	public String email_List(Model model, HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) return "redirect:/";
		
		List<EmailVO> eList = es.findByTOUserid(memberVO.getM_mailaddress());
		
		if(memberVO.getM_userid().equalsIgnoreCase("juhoon12")) {
			eList = es.sellectAll();
		}
		
		model.addAttribute("EMAILLIST",eList);
		model.addAttribute("BODY","REQUEST");
		
		return "home";
	}
	
	@RequestMapping(value="view", method=RequestMethod.POST)
	public String email_view(@RequestParam String id, Model model, HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) return "redirect:/";
		
		EmailVO emailVO = es.findByid(id);
		
		model.addAttribute("EMAIL",emailVO);
		
		return "bodys/email_view";
	}
	
	@RequestMapping(value="e_send", method=RequestMethod.GET)
	public String email_send(@RequestParam(required=false) String id, Model model, HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) return "redirect:/";
		
		EmailVO emailVO = new EmailVO();
		
		if(id != null) {
			emailVO = es.findByid(id);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		
		Date d = new Date();
		
		String today = sdf.format(d);
		String time = sdf1.format(d);
		
		emailVO.setS_date(today);
		emailVO.setS_time(time);
		
		model.addAttribute("EMAIL",emailVO);
		model.addAttribute("BODY","SAVE");
		model.addAttribute("BUTTON","ESEND");
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="e_send", method=RequestMethod.POST, produces="text/html;charset=utf8")
	public String email_send(@ModelAttribute EmailVO emailVO) {

		sms.sendMail(emailVO);
		
		if(emailVO.getId() == 0) {
			int ret = es.insert(emailVO);
		}else {
			int ret = es.update(emailVO);
		}
		
		return "OK" ; // 메일 전송 완료";
	}
	
	@RequestMapping(value="e_save", method=RequestMethod.GET)
	public String email_save(@RequestParam(required=false) String id, Model model, HttpSession session) {

		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) return "redirect:/";
		
		EmailVO emailVO = new EmailVO();
		
		if(id != null) {
			emailVO = es.findByid(id);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		
		Date d = new Date();
		
		String today = sdf.format(d);
		String time = sdf1.format(d);
		
		emailVO.setS_date(today);
		emailVO.setS_time(time);
		
		model.addAttribute("EMAIL",emailVO);
		model.addAttribute("BODY","SAVE");
		model.addAttribute("BUTTON","INSERT");
		
		return "home";
	}
	
	@RequestMapping(value="e_save", method=RequestMethod.POST)
	public String email_save(@ModelAttribute EmailVO emailVO, 
			@RequestParam("file1") MultipartFile s_file1,
			@RequestParam("file2") MultipartFile s_file2) {
		
		if(!s_file1.isEmpty()) {
			es.folder_file_delete(emailVO.getS_file1());
			String file1 = es.upload(s_file1);
			emailVO.setS_file1(file1);
		}
		if(!s_file2.isEmpty()) {
			es.folder_file_delete(emailVO.getS_file2());
			String file2 = es.upload(s_file2);
			emailVO.setS_file2(file2);
		}
		
		log.debug(""+emailVO.getId());
		
		if(emailVO.getId() == 0) {
			int ret = es.insert(emailVO);
		}else {
			int ret = es.update(emailVO);
		}
		
		return "home";
	}
	
	@RequestMapping(value="file_delete",method=RequestMethod.GET)
	public String file_delete(@RequestParam String id, @RequestParam String oneNtwo, Model model) {
		
		es.file_delete(id,oneNtwo);
		
		EmailVO emailVO = es.findByid(id);
		
		model.addAttribute("EMAIL",emailVO);
		
		return "bodys/mail_form";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String email_delete(@RequestParam String id) {
		
		int ret = es.delete(id);
		
		return "redirect:/e_request";
	}
	
	
	
}
