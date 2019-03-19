package com.biz.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@RequestMapping(value="file_up_01",method=RequestMethod.GET)
	public String file() {
		return "bodys/fileUp_form";
	}
	
	@ResponseBody
	@RequestMapping(value="file",method=RequestMethod.POST)
	public String file(@RequestParam MultipartFile file) {
		return "저장 OK";
	}
}
