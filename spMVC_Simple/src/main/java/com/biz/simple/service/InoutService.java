package com.biz.simple.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.biz.simple.vo.InoutVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InoutService {

	String fileName = "inout.txt";
	
	
	
	/*
	 * inout.txt파일을 읽어서 각 라인을 split으로 분해 한 후 항목별로
	 * vo에 담고 List<InoutVO>에 추가해서 상품매입매출 List를 생성 
	 */
	
	public List<InoutVO> getInout() {
		
		List<InoutVO> ioList = new ArrayList<InoutVO>();
		
//		InputStream is = getClass().getClassLoader().getResourceAsStream("inout.txt");
		
		// src/main/resources 폴더에 있는 fileName 정보를 가져와라
		ClassPathResource rs = new ClassPathResource(fileName);
		
		// FileReader의 새로운 버전 => 1.8(1.7)이상에서 파일이나 네트워크를 통해서 정보(내용)을
		// 읽을때 사용하는 class
		InputStreamReader isr ;
		
		BufferedReader br;
		
		try {
			isr = new InputStreamReader(rs.getInputStream());
			
			br = new BufferedReader(isr);
			
//			br = new BufferedReader(new InputStreamReader(is));
			
			while(true) {
				String strfile = br.readLine();
				if(strfile == null) break ;
				
				String[] spfile = strfile.split(":");
				InoutVO vo = new InoutVO();
				vo.setIo_date(spfile[0]);
				vo.setIo_time(spfile[1] + ":" + spfile[2] + ":" + spfile[3]);
				vo.setIo_cname(spfile[4]);
				vo.setIo_check(spfile[5]);
				vo.setIo_price(Integer.valueOf(spfile[6]));
				vo.setIo_su(Integer.valueOf(spfile[7]));
				
				ioList.add(vo);
			}
			br.close();
//			is.close();
			isr.close();
			return ioList;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	
	//1.8버전이상에서만 사용가능
	public List<InoutVO> getIoList() {
		
		List<InoutVO> ioList = new ArrayList<InoutVO>();
		
		ClassPathResource rs = new ClassPathResource(fileName);
		
		// Resource 정보에서 인터넷 주소개념의 file정보를 추출
		Path path ;		
		
		try {
			path = Paths.get(rs.getURI());
			
			List<String> AllLineList = Files.readAllLines(path);
			
			for(String line : AllLineList) {
			
				String[] spfile = line.split(":");
				InoutVO vo = new InoutVO();
				vo.setIo_date(spfile[0]);
				vo.setIo_time(spfile[1] + ":" + spfile[2] + ":" + spfile[3]);
				vo.setIo_cname(spfile[4]);
				vo.setIo_check(spfile[5]);
				vo.setIo_price(Integer.valueOf(spfile[6]));
				vo.setIo_su(Integer.valueOf(spfile[7]));
				
				ioList.add(vo);
			}
			
			for(InoutVO vo : ioList) {
				log.debug(vo.toString());
			}
			
			//1.8버전용 for
			AllLineList.forEach(log::debug);
			for(String line : AllLineList) {log.debug(line);};
			
			return ioList;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	// 인터넷에서 찾아온 방법
	public List<InoutVO> getIoList01() {
		
		List<InoutVO> ioList = new ArrayList<InoutVO>();
		
		InputStream is = getClass().getClassLoader().getResourceAsStream("inout.txt");
		
		BufferedReader br;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(is));
			
			while(true) {
				String strfile = br.readLine();
				if(strfile == null) break ;
				
				String[] spfile = strfile.split(":");
				InoutVO vo = new InoutVO();
				vo.setIo_date(spfile[0]);
				vo.setIo_time(spfile[1] + ":" + spfile[2] + ":" + spfile[3]);
				vo.setIo_cname(spfile[4]);
				if(spfile[5].equals("1")) vo.setIo_check("매입");
				else vo.setIo_check("매출");
//				vo.setIo_check(spfile[5]);
				vo.setIo_price(Integer.valueOf(spfile[6]));
				vo.setIo_su(Integer.valueOf(spfile[7]));
				
				ioList.add(vo);
			}
			br.close();
			is.close();
			return ioList;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
}
