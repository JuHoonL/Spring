package com.biz.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.menu.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	MenuService ms;	
	
	@RequestMapping(value="menu1", method=RequestMethod.GET)
	public String menu1(Model model) {
		
		model.addAttribute("MENUS",ms.getMenus());
		
		return "menu1";
	}
	
	@RequestMapping(value="menu2", method=RequestMethod.GET)
	public String menu2(Model model) {
		
		model.addAttribute("MENUS",ms.getDropMenu());
		
		return "menu2";
	}
	
	@RequestMapping(value="menu3", method=RequestMethod.GET)
	public String menu3(Model model) {
		
		model.addAttribute("MENUS",ms.getDBMenu());
		
		return "menu2";
	}
}
