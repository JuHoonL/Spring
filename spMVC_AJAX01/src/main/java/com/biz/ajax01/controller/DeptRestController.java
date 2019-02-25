package com.biz.ajax01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biz.ajax01.model.DeptVO;
import com.biz.ajax01.service.DeptService;

import lombok.extern.slf4j.Slf4j;


/* restcontroller는 responsebody와 controller가 이미 내장되어있다 */
@Slf4j
@RestController
public class DeptRestController {

	@Autowired
	DeptService ds;
	
	@RequestMapping(value="hello", method=RequestMethod.GET, produces="text/plan;charset=utf8")
	public String testRest() {
		return "반갑습니다";
	}
	
	@RequestMapping(value="dept.array", method=RequestMethod.POST, produces="text/plan;charset=utf8")
	public String dept(@RequestParam String[] deptList) {
		
		for(String s : deptList) {
			log.debug(s);
		}
		
		return "데이터 수신 OK!!";
	}

	@RequestMapping(value="dept.list", method=RequestMethod.POST, produces="text/plan;charset=utf8")
	public String dept(@RequestParam @ModelAttribute List<DeptVO> deptList) {
		
		for(DeptVO vo : deptList) {
			log.debug(vo.getD_code());
		}
		
		return "데이터 수신 OK!!";
	}
	
	/*
	 * form에서 값을 보내고 controller에서 vo로 받을 때 @ModelAttribute로 설정
	  
	 * GET 방식으로 1개의 변수를 보내고 controller에서 개별변수로 받을 때 @RequestParam으로 설정
	  
	 * Ajax를 통해서 JSON형식 배열로 데이터를 보내고 controller에서 List<VO>로 받을 때 @RequestBody로 설정 
	 */
	@RequestMapping(value="dept.json.array", method=RequestMethod.POST, produces="text/plan;charset=utf8")
	public String dept_json(@RequestBody List<DeptVO> deptList) {
		
		for(DeptVO vo : deptList) {
			log.debug(vo.toString());
		}
		
		return "데이터 수신 OK!!";
	}
	
	@RequestMapping(value="dept_save", method=RequestMethod.POST, produces="text/plan;charset=utf8")
	public String dept_save(@ModelAttribute DeptVO deptVO) {
		
		log.debug(deptVO.toString());
		
		int ret = ds.insertOrUpdate(deptVO);
		if(ret > 0) return "데이터 저장 완료!!";
		else return "데이터 저장 실패!!";
		
		
	}
}
