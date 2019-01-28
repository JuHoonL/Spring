package com.biz.memo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemoController {

	@RequestMapping("memo")
	public String memo() {
		return "memoHome";
	}
}
