package com.biz.member.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalceRestController {

	@ResponseBody
	@RequestMapping(value="add1", method=RequestMethod.GET, produces="text/plan; charset=utf8")
	public String getParam(@RequestParam(value="num1", required=false) String num1, @RequestParam(value="num2", required=false) String num2) {
		// required를 false로 설정하는 명령을 추가하면 매개변수값이 없어도 메서드 호출이 정상적으로 작동한다.
		int intNum1 ;
		int intNum2 ;
		int sum = 0;
		
		try {
			intNum1 = Integer.valueOf(num1);
			intNum2 = Integer.valueOf(num2);
			sum = intNum1 + intNum2;
		} catch(Exception e) {
			return "숫자 매개변수가 잘못되어 계산을 수행할 수 없습니다.";
		}
		
		return ""+sum;
	}
	
	// localhost/add/num1/num2
	@RequestMapping(value="add/{num1}/{num2}", method=RequestMethod.GET, produces="text/plan; charset=utf8")
	public String getPath(@PathVariable int num1, @PathVariable int num2) {
		
		return "두수의 합은 " + (num1 + num2) + "입니다";
	}
	
	// localhost/add/num1/num2(안됌) => @PathVariable을 사용해줘야 실행됌
		@RequestMapping(value="add1/{num1}/{num2}", method=RequestMethod.GET, produces="text/plan; charset=utf8")
		public String getPath(@RequestParam(value="num1",required=false) String num1, @RequestParam(value="num2",required=false) String num2) {
			
			int intNum1 ;
			int intNum2 ;
			int sum = 0;
			
			try {
				intNum1 = Integer.valueOf(num1);
				intNum2 = Integer.valueOf(num2);
				sum = intNum1 + intNum2;
			} catch(Exception e) {
				return "숫자 매개변수가 잘못되어 계산을 수행할 수 없습니다.";
			}
			
			return "두수의 합은 " + sum + "입니다";
		}
	
	// localhost/add/num1/num2
	@RequestMapping(value="add", method=RequestMethod.GET, produces="text/plan; charset=utf8")
	public String getPath() {
			
		return "덧셈을 하려면 숫자를 보내야 합니다.";
	}
		
	// localhost/add/num1/num2
	@RequestMapping(value="add/{num1}", method=RequestMethod.GET, produces="text/plan; charset=utf8")
	public String getPath(@PathVariable int num1) {
			
		return "덧셈을 하려면 숫자를 2개 입력해야 합니다.";
	}
}
