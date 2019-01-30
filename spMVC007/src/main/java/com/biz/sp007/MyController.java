package com.biz.sp007;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value="calc", method=RequestMethod.GET)
	public String calc() {
		
		return "calc_form";
	}

	/*
		jsp파일의 form에 input box들을 나열하고 각 input box들에 name속성을
		설정해주고 브라우저에서 box에 문자열을 입력한 후 전송을 하면
		
		그 값들이 서버로 모두 같이 전송이 되고 Controller의 method에 매개변수들을
		같은 이름으로 설정해주면 form에 전송한 데이터를 받을 수 있다.
	*/
	@RequestMapping(value="calc", method=RequestMethod.POST)
	public String calc1(Model model, String txt_num1, String txt_num2, String txt_num3) {
		System.out.println("txt_num1 : " + txt_num1);
		System.out.println("txt_num2 : " + txt_num2);
		System.out.println("txt_num3 : " + txt_num3);
		
		int num1 = Integer.valueOf(txt_num1);
		int num2 = Integer.valueOf(txt_num2);
		int num3 = Integer.valueOf(txt_num3);
		
		int sum = num1 + num2;
		
		System.out.printf("%d + %d = %d\n",num1,num2,sum);
		
		model.addAttribute("Num1",num1);
		model.addAttribute("Num2",num2);
		model.addAttribute("SUM",sum);
		
		LocalDate ld = LocalDate.now();
		model.addAttribute("TODAY",ld.toString());
		
		return "calc_result";
	}
	
	
}
