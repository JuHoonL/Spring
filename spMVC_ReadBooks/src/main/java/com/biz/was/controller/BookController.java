package com.biz.was.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.was.model.BookVO;
import com.biz.was.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {

	@Autowired
	BookService bs;
	
	@RequestMapping(value="book_view", method=RequestMethod.POST)
	public String book_view(@RequestParam String b_id, Model model) {
		
		BookVO bookVO = bs.findByid(b_id);
		
		model.addAttribute("BOOK",bookVO);
		
		return "bodys/book_form";
	}
	
	@RequestMapping(value="book_update", method=RequestMethod.POST)
	public String book_update(@ModelAttribute BookVO bookVO) {
		
		int ret = bs.update(bookVO);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="book_delete", method=RequestMethod.GET)
	public String book_delete(@RequestParam String b_id) {
		
		int ret = bs.delete(b_id);
		
		return "OK";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String book_insert(Model model) {

		return "bodys/book_pop_form";
	}
	
	@RequestMapping(value="book_insert", method=RequestMethod.POST)
	public String book_insert(@ModelAttribute BookVO bookVO) {
		
		int ret = bs.insert(bookVO);
		
		return "redirect:/";
	}
}
