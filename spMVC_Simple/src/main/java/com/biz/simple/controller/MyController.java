package com.biz.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.simple.service.MyService;
import com.biz.simple.vo.CalceVO;

@Controller
public class MyController {

	@Autowired
	MyService ms;
	
	@ResponseBody
	@RequestMapping(value="addList", method=RequestMethod.GET, produces="text/html; charset=utf8 ")
	public String addList(@RequestParam("intNum1") String strNum1, @RequestParam("intNum2") String strNum2) {
		
		int num1 = 0;
		int num2 = 0;
		
		try {
			num1 = Integer.valueOf(strNum1);
		} catch(Exception e) {
			return "intNum1이 숫자가 아닙니다.";
		}
		
		try {
			num2 = Integer.valueOf(strNum2);
		} catch(Exception e) {
			return "intNum2이 숫자가 아닙니다.";
		}
		
		int Sum = 0;
		
		for(int i = num1 ; i <= num2 ; i ++) {
			Sum += i;
		}
		
		
		String Ret = "<html>";
		Ret += "<body>";
		Ret += "<p>" + "intNum1 : " + num1 + "</p>";
		Ret += "<p>" + "intNum2 : " + num2 + "</p>";
		Ret += "<p><font color= blue>" + num1 + " 부터" + num2 + "까지의 합 : " + Sum + "</font></p>";
		Ret += "</body>";
		Ret += "</html>";
		
		
		Sum = 0;
		
		String strRet = "<html>";
		strRet += "<body>";
		
		for(int i = num1 ; i <= num2 ; i ++) {
			Sum += i;
			strRet += "<p>" + Sum + "</p>";
		}
		
		strRet += "</hr>";
		strRet += "<p> 합계 : " + Sum + "</p>";
		
		
		return strRet;
	}
	
	@RequestMapping(value="addList", method=RequestMethod.POST)
	public String addList1(int intNum1, int intNum2, Model model) {
						
		int Sum = 0;
		
		for(int i = intNum1 ; i <= intNum2 ; i ++) {
			Sum += i;
		}
		
		System.out.println(Sum);
		
		model.addAttribute("intNum1",intNum1);
		model.addAttribute("intNum2",intNum2);
		model.addAttribute("SUM",Sum);
		
		return "home";
	}
	
	@RequestMapping(value="addList1", method=RequestMethod.POST)
	public String addList2(int intNum1, int intNum2, Model model) {
						
		int Sum = 0;
		
		for(int i = intNum1 ; i <= intNum2 ; i ++) {
			if(i % 2 == 0) {
				Sum += i;
			}
		}
		
		System.out.println(Sum);
		
		model.addAttribute("intNum1",intNum1);
		model.addAttribute("intNum2",intNum2);
		model.addAttribute("SUM",Sum);
		
		return "home";
	}
	
	@RequestMapping(value="calce", method=RequestMethod.GET)
	public String calce() {
		return "calce";
	}
	
	@RequestMapping(value="calce", method=RequestMethod.POST)
	public String calce(int intNum1, int intNum2, Model model) {
						
		int sum = ms.add(intNum1, intNum2);
		int minus = ms.minus(intNum1, intNum2);
		int multi = ms.multi(intNum1, intNum2);
		float devide = ms.devide(intNum1, intNum2);
		
		
		
		
		model.addAttribute("intNum1",intNum1);
		model.addAttribute("intNum2",intNum2);
		model.addAttribute("SUM",sum);
		model.addAttribute("MINUS",minus);
		model.addAttribute("MULTI",multi);
		model.addAttribute("DEVIDE",devide);
		
		return "home";
	}
	
	@RequestMapping(value="calce-vo", method=RequestMethod.POST)
	public String calce(@ModelAttribute CalceVO vo, Model model) {
						
		int sum = ms.add(vo.getIntNum1(),vo.getIntNum2());
		int minus = ms.minus(vo.getIntNum1(),vo.getIntNum2());
		int multi = ms.multi(vo.getIntNum1(),vo.getIntNum2());
		float devide = ms.devide(vo.getIntNum1(),vo.getIntNum2());
		
		vo.setIntAdd(sum);
		vo.setIntMinus(minus);
		vo.setIntMulti(multi);
		vo.setIntDevide(devide);
				
		model.addAttribute("CALC",vo);
		
		return "calce";
	}
}
