package com.biz.addr01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.addr01.model.SelectVO;

@Service
public class SelectService {

	public List<String> getCities2() {
		
		List<String> cities = new ArrayList<String>();
		
		cities.add("서울");
		cities.add("인천");
		cities.add("대전");
		cities.add("광주");
		cities.add("부산");
		
		return cities;
	}
	
	public List<SelectVO> getCities() {
		
		List<SelectVO> cities = new ArrayList<SelectVO>();
		
		SelectVO sVO = SelectVO.builder().label("서울").value("SEOUL").build();
		
		cities.add(sVO);
		
		sVO = SelectVO.builder().label("인천").value("INCHEON").build();
		
		cities.add(sVO);
		
		sVO = SelectVO.builder().label("대전").value("DAEJEON").build();
		
		cities.add(sVO);
		
		sVO = SelectVO.builder().label("광주").value("GWANGJU").build();
		
		cities.add(sVO);
		
		sVO = SelectVO.builder().label("부산").value("BUSAN").build();
		
		cities.add(sVO);
		
		return cities;
	}
}
