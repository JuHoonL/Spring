package com.biz.sp007;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.sp007.model.BookVO;
import com.biz.sp007.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bs;
	
	@RequestMapping(value="book", method=RequestMethod.GET)
	public String book() {
						
		return "book_form";
	}
	
	@RequestMapping(value="book1", method=RequestMethod.POST)
	public String book(Model model, String b_title, String b_comp, String b_auth, String b_price) {
		
		model.addAttribute("b_title",b_title);
		model.addAttribute("b_comp",b_comp);
		model.addAttribute("b_auth",b_auth);
		model.addAttribute("b_price",b_price);
		
		return "book_result";
	}
	
	@RequestMapping(value="book", method=RequestMethod.POST)
	public String book(@ModelAttribute BookVO vo, Model model) {
		
		vo = bs.changeAuth(vo);
		List<BookVO> bookList = bs.selectAll();
		model.addAttribute("BOOK",vo);
		model.addAttribute("BOOKS",bookList);
		
		return "book_result";
	}
}
