package com.biz.iolist.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.DeptVO;
import com.biz.iolist.model.MemberVO;
import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes("deptVO")
@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	DeptService dService;
	
	@ModelAttribute("deptVO")
	public DeptVO newDeptVO() {
		DeptVO deptVO = new DeptVO();
//		deptVO.setD_code(getNewCode());
		return deptVO;
	}
	
	@ResponseBody
	@RequestMapping(value="get_d_name", method=RequestMethod.GET, produces="text/plan; charset=utf8")
	public String getDName(@RequestParam("d_code") String d_code) {
		String d_name = dService.getDName(d_code);
		
		return d_name;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {

		List<DeptVO> dList = dService.selectAll();
		
		model.addAttribute("LIST",dList);
		model.addAttribute("BODY","D_LIST");
		
		return "home";
	}

	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@RequestParam String d_name, Model model) {
		
		List<DeptVO> dList = dService.findByPName(d_name);
		
		model.addAttribute("LIST",dList);
		
		return "bodys/dept/d_search_list";
	}
	
	@ResponseBody
	@RequestMapping(value="get_new_code", method=RequestMethod.GET)
	public String getNewCode() {
		return dService.getDCode();
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@ModelAttribute("deptVO") DeptVO deptVO, Model model, HttpSession session, SessionStatus sessionS) {
		
		deptVO = new DeptVO();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) {
			model.addAttribute("LOGIN_MSG","LOGIN PLZ");
			return "redirect:/login";
		}
		deptVO.setD_code(getNewCode());
		
		model.addAttribute("deptVO",deptVO);
		model.addAttribute("BODY","D_WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write1(@ModelAttribute("deptVO") DeptVO deptVO, Model model, SessionStatus sessionS) {
		
		int ret = dService.insert(deptVO);
		
		if(ret > 0) {
			sessionS.setComplete();
			model.addAttribute("MSG","데이터 추가 성공!!");
			
			return "redirect:/dept/list";
		}else {
			model.addAttribute("deptVO",deptVO);
			model.addAttribute("BODY","D_WRITE");
			
			model.addAttribute("MSG","데이터 추가 실패!!");
			
			return "home";
		}
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam String d_code, Model model) {

		DeptVO deptVO = dService.findById(d_code);
		
		model.addAttribute("deptVO",deptVO);
		model.addAttribute("BODY","D_UPDATE");
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("deptVO") DeptVO deptVO, Model model, SessionStatus sessionS) {

		int ret = dService.update(deptVO);
		
		sessionS.setComplete();
		model.addAttribute("MSG","데이터 수정 성공!!");
		
		return "redirect:/dept/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam String d_code, Model model) {
		
		log.debug(d_code);
		
		dService.delete(d_code);
		
		return "redirect:/dept/list";
	}
}
