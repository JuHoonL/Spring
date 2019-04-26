package com.biz.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.rent.model.BookVO;
import com.biz.rent.model.JUserVO;
import com.biz.rent.service.BookService;
import com.biz.rent.service.JUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	JUserService uService;
	
	@Autowired
	BookService bService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		
		return "admin_home";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user(@RequestParam(value="user_seq", required=false, defaultValue="0") long user_seq, Model model) {
		
		List<JUserVO> userlist = uService.selectAll();
		
		if(user_seq != 0) {
			JUserVO userVO = uService.findById(user_seq);
			
			model.addAttribute("VO",userVO);
		}
		
		model.addAttribute("LIST",userlist);
		
		model.addAttribute("BODY","USER_LIST");
		
		return "admin_home";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String user(@ModelAttribute("userVO") JUserVO userVO, @RequestParam(value="u_file", required=false) MultipartFile u_file , Model model) {
		
		if(userVO.getUser_seq() == 0) {
			userVO = uService.fileUp(userVO, u_file);
			int ret = uService.insert(userVO);
		}else {
			userVO = uService.fileUp(userVO, u_file);
			int ret = uService.update(userVO);
		}
		return "redirect:/admin/user";
	}
	
	@RequestMapping(value="/user_delete", method=RequestMethod.GET)
	public String user_delete(@RequestParam("user_seq") long user_seq) {
		
		
		int ret = uService.delete(user_seq);
		
		return "redirect:/admin/user";
	}
	
	@ResponseBody
	@RequestMapping(value="/file_u_delete", method=RequestMethod.POST)
	public String file_u_delete(@RequestParam("user_seq") long user_seq) {
	
		if(user_seq == 0) {
			return "FAIL";
		}
		
		JUserVO userVO = uService.findById(user_seq);
		
		userVO.setUser_image("");
		
		int ret = uService.update(userVO);
		
		return "OK";
	}
	
	@RequestMapping(value="/book", method=RequestMethod.GET)
	public String book(@RequestParam(value="book_seq", required=false, defaultValue="0") long book_seq, Model model) {
		
		List<BookVO> booklist = bService.selectAll();
		
		if(book_seq != 0) {
			BookVO bookVO = bService.findById(book_seq);
			
			model.addAttribute("VO",bookVO);
		}
		
		model.addAttribute("LIST",booklist);
		
		model.addAttribute("BODY","BOOK_LIST");
		
		return "admin_home";
	}
	
	@RequestMapping(value="/book", method=RequestMethod.POST)
	public String book(@ModelAttribute("bookVO") BookVO bookVO, @RequestParam(value="b_file", required=false) MultipartFile b_file , Model model) {
		
		if(bookVO.getBook_seq() == 0) {
			bookVO = bService.fileUp(bookVO, b_file);
			int ret = bService.insert(bookVO);
		}else {
			bookVO = bService.fileUp(bookVO, b_file);
			int ret = bService.update(bookVO);
		}
		return "redirect:/admin/book";
	}
	
	@RequestMapping(value="/book_delete", method=RequestMethod.GET)
	public String book_delete(@RequestParam("book_seq") long book_seq) {
		
		
		int ret = bService.delete(book_seq);
		
		return "redirect:/admin/book";
	}
	
	@ResponseBody
	@RequestMapping(value="/file_b_delete", method=RequestMethod.POST)
	public String file_b_delete(@RequestParam("book_seq") long book_seq) {
	
		if(book_seq == 0) {
			return "FAIL";
		}
		
		BookVO bookVO = bService.findById(book_seq);
		
		bookVO.setBook_image("");
		
		int ret = bService.update(bookVO);
		
		return "OK";
	}
	
	@RequestMapping(value="/rent", method=RequestMethod.GET)
	public String rent(Model model) {
		
		model.addAttribute("BODY","RENT_LIST");
		
		return "admin_home";
	}
}
