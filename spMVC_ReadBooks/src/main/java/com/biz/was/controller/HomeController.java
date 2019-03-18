package com.biz.was.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.was.model.BookVO;
import com.biz.was.model.MemberVO;
import com.biz.was.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	BookService bs;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		
		return "home";
	}
	
	
	@RequestMapping(value = "main_list", method = RequestMethod.GET)
	public String main_list(Model model, HttpSession session) {
		
		List<BookVO> bookList = new ArrayList<BookVO>();
		
		bookList = bs.sellectAll();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		session.setAttribute("LOGIN_INFO", memberVO);
		
		if(memberVO != null) {
			bookList = bs.findByuserid(memberVO.getM_userid());
			if(memberVO.getM_userid().equalsIgnoreCase("juhoon12")) {
				bookList = bs.sellectAll();
			}
		}
		
		model.addAttribute("BOOKLIST",bookList);
		
		return "bodys/book_list";
	}
}
