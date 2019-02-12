package com.biz.memo02.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo02.model.MemberDao;
import com.biz.memo02.vo.CodeVO;
import com.biz.memo02.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDao memberMapper;
	
	public List<CodeVO> getCities() {
		List<CodeVO> cities = new ArrayList<CodeVO>();
		
		cities.add(new CodeVO("서울특별시","SEOUL"));
		cities.add(new CodeVO("부산광역시","BUSAN"));
		cities.add(new CodeVO("인천광역시","INCHON"));
		cities.add(new CodeVO("대전광역시","DAEJON"));
		cities.add(new CodeVO("광주광역시","GWANGJU"));
		cities.add(new CodeVO("제주특별자치도","JEJU"));
		
		return cities;
	}
	
	/*
	 * Map<Key,Value>
	 * 키와 값의 쌍으로 구성된 자료 구조
	 * 값을 추가할 때 : map.put(key,value);
	 * 값을 읽을 때 : map.key;
	 * 의 형태로 사용한다.
	 */
	public Map<String,String> getCitiesMap(){
		
		/*
		 * HashMap은 put한 순서대로 나열
		 * TreeMap은 key를 기준으로 정렬
		 * 
		 * Map은 key값의 중복을 허용하지 않는다.
		 */
		Map<String,String> cities = new HashMap<String,String>();
		cities = new TreeMap<String,String>();
		
		cities.put("서울특별시","SEOUL");
		cities.put("부산광역시","BUSAN");
		cities.put("인천광역시","INCHON");
		cities.put("대전광역시","DAEJON");
		cities.put("광주광역시","GWANGJU");
		cities.put("제주특별자치도","JEJU");
		
		return cities;
	}
	
	public List<String> getCitiesList(){
		
		List<String> cities = new ArrayList<String>();
		cities.add("서울특별시");
		cities.add("부산광역시");
		cities.add("인천광역시");
		cities.add("대전광역시");
		cities.add("광주광역시");
		cities.add("제주특별자치도");
		
		return cities;
	}
	
	public List<CodeVO> getHobbies() {
		List<CodeVO> hobbies = new ArrayList<CodeVO>();
		
		hobbies.add(new CodeVO("독서","BOOK"));
		hobbies.add(new CodeVO("영화감상","MOVIE"));
		hobbies.add(new CodeVO("음악감상","MUSIC"));
		hobbies.add(new CodeVO("게임","GAME"));
		hobbies.add(new CodeVO("등산","CLIMB"));
		
		return hobbies;
	}	
	public Map<String,String> getHobbiesMap() {
		
		Map<String,String> hobbies = new HashMap<String,String>();
		
		hobbies.put("BOOK", "독서");
		hobbies.put("MOVIE", "영화감상");
		hobbies.put("MUSIC", "음악감상");
		hobbies.put("GAME", "게임");
		hobbies.put("CLIMB", "등산");
		
		return hobbies;
	}
	
	public List<String> getHobbiesList() {
		
		List<String> hobbies = new ArrayList<String>();
		
		hobbies.add("독서");
		hobbies.add("영화감상");
		hobbies.add("음악감상");
		hobbies.add("게임");
		hobbies.add("등산");
		
		return hobbies;
	}

	public int insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int ret = memberMapper.insert(memberVO);
		
		return ret;
	}

	public MemberVO userCheck(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
		MemberVO vo = memberMapper.findByUserId(memberVO.getM_userid());
		
		if(memberVO.getM_password().equals(vo.getM_password())) {
			return vo;
		} else {
			return null;
		}
		
	}
}
