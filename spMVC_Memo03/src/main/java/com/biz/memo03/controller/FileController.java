package com.biz.memo03.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.memo03.model.MemoVO;
import com.biz.memo03.service.FileService;
import com.biz.memo03.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {

	// tomcat서버에 대한 정보를 담고있는 클래스
	@Autowired
	ServletContext context;
	
	@Autowired
	FileService fService;
	
	@Autowired
	MemoService mService;
	
	@ResponseBody
	@RequestMapping(value="memo_file", method=RequestMethod.POST, produces="text/html;charset=utf8")
	public String fileUp(@ModelAttribute MemoVO memoVO, @RequestParam MultipartFile m_file) {
		
//		mService.save(memoVO);
		
		String saveFileName = fService.fileUpload(memoVO, m_file);
		
		return "<img src='" + context.getContextPath() + "/files/" + saveFileName + "' />" ;
	}
	
	@RequestMapping(value="file_del")
	public String file_del(@RequestParam long id) {
		
		return null;
	}
}
