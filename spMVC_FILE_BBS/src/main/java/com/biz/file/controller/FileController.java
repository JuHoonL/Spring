package com.biz.file.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.file.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/file")
@MultipartConfig(maxFileSize=100000000)
public class FileController {

	@Autowired
	FileUpService fus;
	
	@RequestMapping(value="/file_up",method=RequestMethod.GET)
	public String file(Model model) {
		
		model.addAttribute("BODY","FILE_UP");
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/file",method=RequestMethod.POST,produces="text/html;charset=utf8")
	public String file(@RequestParam MultipartFile file) {
		
		String ret = fus.upload(file);
		
		return "저장 OK";
	}
	
	@RequestMapping(value="/files_up",method=RequestMethod.GET)
	public String files(Model model) {
		
		model.addAttribute("BODY","FILES_UP");
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/files",method=RequestMethod.POST)
	public List<String> files(MultipartHttpServletRequest files) {
		
		List<String> fileNames = fus.uploads(files);
		
		for(String file : fileNames) {
			log.debug("파일이름 : " + file );
		}
		
		return fileNames;
		/*
		  	@Controller에서 @ResponseBody가 설정된 method가 String(문자열)을 return하면 문자열 자체가
		  	전송되어 web browser에게 문자열이 출력된다.
		  	
		  	@RestController가 설정된 경우 모든 method에 @ResponseBody가 설정된다.
		  	
		  	@ReponseBody를 설정해주고 Jackson-debind를 dependency에 추가해 주면 List형태의 데이터를
		  	JSON형태로 변환하여 return 할 수 있게 된다.
		  
		 */
	}
}
