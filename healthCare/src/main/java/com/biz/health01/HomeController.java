package com.biz.health01;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.health01.service.KcalService;
import com.biz.health01.service.PkcalService;
import com.biz.health01.service.UserService;
import com.biz.health01.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	PkcalService pkS;
	KcalService kS;
	UserService uS;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
				
		return "home";
	}
	
	@RequestMapping(value = "user_join", method = RequestMethod.GET)
	public String user_join(Model model) {
		
		return "user_join";
	}
	
	@RequestMapping(value="user_join", method = RequestMethod.POST)
	public String user_join(@ModelAttribute UserVO vo, Model model) {
		
		uS.user_Insert(vo);
		
		return "user_DB";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String food_select(@ModelAttribute UserVO vo, Model model) {
		
		return "";
	}
	
}
