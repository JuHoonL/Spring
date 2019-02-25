package com.biz.ajax01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ajax01.model.DeptVO;
import com.biz.ajax01.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	DeptService ds;
	
	@RequestMapping(value="dept", method=RequestMethod.GET)
	public String dept_list(Model model) {
	
//		List<DeptVO> dList = ds.deptGetAllList();
		
		model.addAttribute("BODY","DEPT");
//		model.addAttribute("LIST",dList);
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="dept", method=RequestMethod.POST, produces="text/plan; charset=utf8")
	public String get_dept(@RequestParam String d_code, Model model) {
		
		DeptVO vo = ds.getDeptfindByCode(d_code);
		
		return vo.toString();
	}
	
	/*
	 *	ajax로 호출된 결과를 return 할 때 문자열로 return을 하려면
	 *	@ResponseBody를 설정 해 주면 된다.
	 *
	 * 	그런데 ajax로 호출된 결과를 다른 용도로 사용하려면 JSON형태로 return을
	 * 	해 주는 것이 좋다.
	 * 
	 * 	하지만 JAVA(spring)에서는 JSON이라는 데이터 형태를 지원하지 않는다.
	 * 
	 * 	다행하스럽게도 spring에는 JSON을 쉽게 사용할 수 있는 통로가 마련되어있고,
	 * 	한가지의 3rd part lib만 설정해주면 된다.
	 */
	@ResponseBody
	@RequestMapping(value="dept.JSON", method=RequestMethod.POST, produces="application/json; charset=utf8")
	public DeptVO get_dept_json(@RequestParam String d_code, Model model) {
		
		DeptVO vo = ds.getDeptfindByCode(d_code);
		
		return vo;
	}
	
	@RequestMapping(value="dsearch", method=RequestMethod.POST)
	public String dsearch(@RequestParam String dsearch, Model model) {
		
		List<DeptVO> dList = ds.getFindByDName(dsearch);
		
		model.addAttribute("LIST",dList);
		
		return "body/dept-list";
	}
}	
