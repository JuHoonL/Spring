package com.biz.file.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileUpService {

	/*
	 	파일 업로드를 하기 위해 서버의 실제 디렉토리 경로를 추출 하는데
	 	사용 할 ServletContext를 선언
	 */
	
	@Autowired
	ServletContext context;
	
	public String upload(MultipartFile file) {

		/*
		 	서버의 실제 디렉토리 경로를 추출
		 */
		String realPath = context.getRealPath("/files/");
		
		/*
		 	서버의 실제 디렉토리 경로를 추출하고 파일을 저장할 폴더(/files/)가
		 	만들어 졌는지 확인하고 없으면 폴더를 생성
		 */
		// 운영체제에게 /files/의 정보를 달라고 요청
		File dir = new File(realPath);
		
		// !dir.exists()는 dir의 정보가 없으면
		if(!dir.exists()) {
			dir.mkdir();
//			dir.mkdirs(); : 다중경로 디렉토리 생성(예>/files/img/)
		}
		
		// 업로드한 파일에 여러가지 문제가 발생하면 더이상 진행하지 말라
		if(file.isEmpty() || file == null) return null;
		
		/*
			업로드 할 파일의 실제이름을 추출
		 */
		String realFile = file.getOriginalFilename();
		
		/*
			32자리의 16진수 문자열로 된 임의의 값을 생성
		 */
		String saveFile = UUID.randomUUID().toString();
		
		saveFile += realFile;
		
		/*
		 	업로드 한 파일을 서버디렉토리에 저장하기 위해서 파일 객체러를 생성
		 */
//		File upFile = new File(realPath,realFile);
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
		
		/*
		  	fileNames에는 이름을 변경하여 서버에 업로드한 파일들의 이름리스트가 만들어진다.
		 */
		for(MultipartFile file : fileList) {
			fileNames.add(this.upload(file));
		}
		
		return fileNames;
		
	}

	
}
