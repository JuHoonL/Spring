package com.biz.rent.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.biz.rent.mapper.JUserDao;
import com.biz.rent.model.JUserVO;

@Service
public class JUserService {

	@Autowired
	ServletContext context;
	
	@Autowired
	JUserDao dao;
	
	public List<JUserVO> selectAll() {
		
		return dao.selectAll();
	}
	
	public JUserVO findById(long user_seq) {
		
		return dao.findByUserSeq(user_seq);
	}
	
	public int insert(JUserVO userVO) {
		int ret = dao.insert(userVO);
		
		return ret;
	}
	
	public int update(JUserVO userVO) {
		int ret = dao.update(userVO);
		
		return ret;
	}
	
	public int delete(long user_seq) {
		int ret = dao.delete(user_seq);
		
		return ret;
	}
	
	@Transactional
	public JUserVO fileUp(JUserVO userVO, MultipartFile u_file) {
		String fileName = u_file.getOriginalFilename();
		String saveFileName = "";
		
		String realPath = context.getRealPath("/");
		String upLoadPath = realPath + "files/";
		
		if(u_file != null) {
			if(u_file.getSize() > 10485760) {
				return null;
			}
			if(fileName != null && !fileName.equals("")) {
				saveFileName = UUID.randomUUID().toString() + fileName;
				
				File dir = new File(upLoadPath);
				if(!dir.exists()) { 	
					dir.mkdir();		
				}
				
				File upLoadFile = new File(upLoadPath, saveFileName);
				
				try {
					u_file.transferTo(upLoadFile);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			} 
			userVO.setUser_image(saveFileName);
		}
		return userVO;
	}

	public List<JUserVO> getSearchList(String s_string) {

		try {
			Long phone = Long.valueOf(s_string);
			
			return dao.findByPhone(s_string);
			
		} catch (Exception e) {
			
		}
		
		return dao.findByUserName(s_string);
	}
}
