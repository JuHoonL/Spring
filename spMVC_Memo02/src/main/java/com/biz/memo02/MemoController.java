package com.biz.memo02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo02.vo.MemoVO;

@Controller
public class MemoController {
	
	@RequestMapping(value="memo_write", method=RequestMethod.GET)
	public String memo_write() {
		
		return "memo_write";
	}
	
	@RequestMapping(value="memo_write", method=RequestMethod.POST)
	public String memo_write(Model model, @ModelAttribute MemoVO vo) {
		
		return "memo_write";
	}
	
}
