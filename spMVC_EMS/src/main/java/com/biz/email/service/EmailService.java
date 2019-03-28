package com.biz.email.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.mapper.EmailDao;
import com.biz.email.model.EmailVO;

@Service
public class EmailService {

	@Autowired
	EmailDao emailmapper;
	
	@Autowired
	ServletContext context;
	
	public List<EmailVO> sellectAll() {

		return emailmapper.sellectAll();
	}
	
	public EmailVO findByid(String id) {
		
		return emailmapper.findByid(Long.valueOf(id));
	}
	
	public int update(EmailVO emailVO) {
		
		return emailmapper.update(emailVO);
	}

	public int delete(String b_id) {
		
		return emailmapper.delete(Long.valueOf(b_id));
	}

	public int insert(EmailVO emailVO) {
		return emailmapper.insert(emailVO);
	}

	public List<EmailVO> findByUserid(String m_mailaddress) {
		
		return emailmapper.findByUserid(m_mailaddress);
	}
	
	public String upload(MultipartFile file) {

		String realPath = context.getRealPath("/files/");
		
		File dir = new File(realPath);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		if(file.isEmpty() || file == null) return null;
		
		String realFile = file.getOriginalFilename();
		
		String saveFile = UUID.randomUUID().toString();
		
		saveFile += realFile;
		
		File upFile = new File(realPath,saveFile);
		
		try {
			file.transferTo(upFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return saveFile;
		
	}
	
	public List<String> uploads(MultipartHttpServletRequest files) {

		List<MultipartFile> fileList = files.getFiles("files");
		List<String> fileNames = new ArrayList<String>();
		
		for(MultipartFile file : fileList) {
			fileNames.add(this.upload(file));
		}
		
		return fileNames;
		
	}

}
