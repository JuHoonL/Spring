package com.biz.xml.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileService {

	@Autowired
	ServletContext context;
	
	public String upload(MultipartFile file) {
		
		String realPath = context.getRealPath("/files/");
		String fileName = file.getOriginalFilename();
		
		if(file.isEmpty() || file == null) {
			return null;
		}
		
		//file을 저장할 디렉토리 생성여부 검사
		File dir = new File(realPath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		//old version
		//1. 파일을 담을 byte배열 생성
		try {
			//파일을 담을 byte 배열을 생성
			//byte배열을 생성하면서 파일의 내용을 같이 가져와서 담아 놓는다.
			//DMA(Direct Memory Access) 기능
			byte[] bytes = file.getBytes();
			
			File saveFile = new File(realPath,fileName);
			
			FileOutputStream fo = new FileOutputStream(saveFile);
			
			//(local)disk(storage)에 파일을 기록하기 위한 클래스(그래서 Output)
			BufferedOutputStream bo = new BufferedOutputStream(fo);
			
			//write를 실행하면 bytes에 담긴 내용을 Buff...Stream으로 전달하고
			//Buff...Stream은 File...Stream에게 전달하여 실제 로컬 디스크에 기록을 한다.
			bo.write(bytes);
			//close()를 해줘야 임시보관소에 보관된 write의 파일내용이 물리저장소에 저장된다.
			bo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileName;
	}

	public List<String> uploadFiles(MultipartHttpServletRequest files) {

		List<MultipartFile> fileList = files.getFiles("files");
		
		String realPath = context.getRealPath("/files/");
		
		File dir = new File(realPath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		
		try {
			for(MultipartFile f : fileList) {
				File file = new File(realPath, f.getOriginalFilename());
				f.transferTo(file);
			}
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	
}
