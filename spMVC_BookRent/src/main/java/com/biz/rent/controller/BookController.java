package com.biz.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rent.model.BookVO;
import com.biz.rent.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bService;
	
	@RequestMapping(value="/s_list/{s_string}", method=RequestMethod.GET)
	public String search_list(@PathVariable(value="s_string", required=false) String s_string, Model model) {
		
		List<BookVO> bookList = bService.getSearchList2(s_string);
		
		model.addAttribute("BOOKS",bookList);
		return "rent_body/book_s_list";
	}
}
