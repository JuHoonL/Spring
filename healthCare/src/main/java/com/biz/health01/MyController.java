package com.biz.health01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("calc")
	public String calc(){
		return "calc_form";
	}
	

}
