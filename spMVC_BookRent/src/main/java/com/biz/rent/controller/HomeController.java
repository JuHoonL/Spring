package com.biz.rent.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rent.model.BookVO;
import com.biz.rent.model.JUserVO;
import com.biz.rent.model.RentVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"bookVO","rentVO","userVO"})
public class HomeController {

	@ModelAttribute("bookVO")
	public BookVO newBook() {
		return new BookVO();
	}
	
	@ModelAttribute("rentVO")
	public RentVO newRent() {
		
		RentVO rentVO = new RentVO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		
		rentVO.setRent_date(today);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);
		String today_7 = sdf.format(cal.getTime());
		
		rentVO.setRent_return_date(today_7);
		
		return rentVO;
	}
	
	@ModelAttribute("userVO")
	public JUserVO newJUserVO() {
		return new JUserVO();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("rentVO") RentVO rentVO, Model model) {
		/*
		rentVO = new RentVO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		
		rentVO.setRent_date(today);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);
		String today_7 = sdf.format(cal.getTime());
		
		rentVO.setRent_return_date(today_7);
		*/
		model.addAttribute("rentVO",rentVO);
		return "home2";
	}
	
}
