package com.biz.memo03.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.biz.memo03.mapper.FileDao;
import com.biz.memo03.mapper.MemoDao;
import com.biz.memo03.model.FileVO;
import com.biz.memo03.model.MemoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileService {

	/*
	 * ServletContext 는 tomcat이 실행되는 환경에서 다양한 정보를 가지고 있는 매우 중요한 클래스
	 * context로 부터 서버에 대한 정보를 추출해 볼수 있다.
	 */
	@Autowired
	ServletContext context;
	
	@Autowired
	MemoDao mdao;
	
	@Autowired
	FileDao fdao;
	
	/*
	 * @Transactional Annotation을 사용하여 tbl_memo와 tbl_file table에 isert update를 보장하자
	 * 이 Annotation을 사용하기 위해서 mybatis-context.xml에 transaction 설정을 해두어야한다.
	 */
	@Transactional
	public String fileUpload(MemoVO memoVO, MultipartFile m_file) {
		
		String fileName = m_file.getOriginalFilename();
		String saveFileName = "";
		
		//tomcat server가 실행해서 보여주는 context root의 위치
		String realPath = context.getRealPath("/");
		String upLoadPath = realPath + "files/";
		
		if(m_file != null) {
			if(m_file.getSize() > 1048576) {
				return null;
			}
			if(fileName != null && !fileName.equals("")) {
				/*
				 * UUID : universally Unique Identified(범용유일식별자)
				 * 유일한 키값으로 16진수 32자리의 임의의 키값(16의 32승만큼의 값)
				 * 
				 * 오리지널 파일 이름으로 업로드를 하면 악의적인 사용자에 의해 파일이 변조 될 수 있으므로
				 * 업로드할 때에는 임의 키값을 생성해서 업로드를 수행한다.
				 * 
				 * UUID는 자바5(1.5)부터 사용가능하고 그전에는 timestamp를 사용했다.
				 */
				saveFileName = UUID.randomUUID().toString() + fileName;
				
				File dir = new File(upLoadPath);
				if(!dir.exists()) { 	// 폴더가 자동생성되지 않았으면
					dir.mkdir();		//폴더를 생성해라
				}
				
				//운영체제에 독립적인 구조의 파일 이름 체계를 생성
				File upLoadFile = new File(upLoadPath, saveFileName);
				
				try {
					//nio패키지의 file(1.7이상)클래스의 도움을 받아 사용자컴퓨터에서 tomcat서버의 디렉토리로
					//파일을 한번에 전송할 수 있게 됌
					m_file.transferTo(upLoadFile); //파일경로를 매개변수로 주어서 업로드한 파일을 전송 저장
				} catch (Exception e) {
					e.printStackTrace();
				} 
			} 
			//tbl_files 테이블에 파일 정보를 저장할 예정
			
			if(memoVO.getId() > 0) {
				mdao.update(memoVO);
			}else {
				mdao.insert(memoVO);
			}
			//Builder Pattern : fileVO 객체를 생성하면서 각 속성의 값을 세팅하고자 할 때 사용하는 방법
			FileVO fileVO = FileVO.builder().parent_id(memoVO.getId()).file_name(fileName).save_file_name(saveFileName).build();
			
			fdao.insert(fileVO);
			
			return saveFileName;
		}
		return null;
	}

	/*
	  	첨부파일 삭제
	  1. tbl_files 테이블의 id값으로 tbl_files의 레코드를 가져오기
	  2. fileVO에 담기
	  3. fileVO의 save_file_name 값을 가지고
	  4. 실제 서버에 저장된 파일을 삭제
	  5. tbl_files 테이블에 해당되는 정보를 삭제
	*/
	public int delete(long id) {
		
		FileVO fVO = fdao.findById(id);
		
		String realFile = fVO.getSave_file_name();
		
		//실제 파일이 저장된 폴더
		String realPath = context.getRealPath("/files/");
		
		//파일이 저장된 폴더와 파일 이름을 연결하여 파일 정보 생성
		File file = new File(realPath,realFile);
		
		boolean fileDelOk = false;
		if(file.exists()) { //파일이 실제로 존재하는지여부에 따라 존재하면 삭제
			fileDelOk = file.delete(); // 삭제가 성공하면 true, 실패하면 false
		}
		
		//일반적인 if문 코드
		String fileDelMsg = "";
		if(fileDelOk) fileDelMsg = "삭제성공";
		else fileDelMsg = "삭제실패";
		
		log.debug("파일삭제 OK> : " + fileDelMsg);
		
		
//		//3항 연산자 코드
//		String fileDelMsg2 = fileDelOk ? "삭제성공" : "삭제실패";
//		fileDelMsg2 = fileDelOk == true ? "삭제성공" : "삭제실패";
//		
//		log.debug("파일삭제 OK> : " + (fileDelOk ? "삭제성공" : "삭제실패"));
//		
//		int r = (int)(Math.random() * 180) + 1;
//		if(r %2 ==0) log.debug("짝수 : " + r);
//		else log.debug("짝수아님");
//		
//		log.debug((r%2==0 ? "짝수" + r : "짝수아님"));
		
		if(fileDelOk) return fdao.delete(id);
		else return 0;
		
//		return fdao.delete(id);
	}

	public void fileDelete(long id) {
		
		List<FileVO> fileList = fdao.selectById(id);
		
		String realPath = context.getRealPath("/files/");
		
		for(FileVO v : fileList) {
			String realFile = v.getSave_file_name();
			File file = new File(realPath, realFile);
			if(file.exists()) {
				file.delete();
			}
		}
	}
}
