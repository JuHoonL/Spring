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

import com.biz.iolist.model.MemberVO;
import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.ProductService;

@SessionAttributes("productVO")
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService pService;
	
	@ModelAttribute("productVO")
	public ProductVO newproductVO() {
		ProductVO productVO = new ProductVO();
		return productVO;
	}
	
	@ResponseBody
	@RequestMapping(value="get_p_name", method=RequestMethod.GET, produces="text/plan; charset=utf8")
	public String getPName(@RequestParam("p_code") String p_code) {
		String p_name = pService.getPName(p_code);
		
		return p_name;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<ProductVO> pList = pService.selectAll();
		
		model.addAttribute("LIST",pList);
		model.addAttribute("BODY","P_LIST");
		
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@RequestParam String p_name, Model model) {
		
		List<ProductVO> pList = pService.findByPName(p_name);
		
		model.addAttribute("LIST",pList);
		
		return "bodys/product/p_search_list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@ModelAttribute("productVO") ProductVO productVO, Model model, HttpSession session, SessionStatus sessionS) {
		
		productVO = new ProductVO();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) {
			model.addAttribute("LOGIN_MSG","LOGIN PLZ");
			return "redirect:/login";
		}
		
		model.addAttribute("productVO",productVO);
		model.addAttribute("BODY","P_WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write1(@ModelAttribute("productVO") ProductVO productVO, Model model, SessionStatus sessionS) {
		
		int ret = pService.insert(productVO);
		sessionS.setComplete();
		if(ret > 0) {
			model.addAttribute("MSG","데이터 추가 성공!!");
			return "redirect:/product/list";
		}else {
			model.addAttribute("BODY","P_WRITE");
			model.addAttribute("MSG","데이터 추가 실패!!");
			return "home";
		}
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam String p_code, Model model) {

		ProductVO productVO = pService.findById(p_code);
		
		model.addAttribute("productVO",productVO);
		model.addAttribute("BODY","P_UPDATE");
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("productVO") ProductVO productVO, Model model, SessionStatus sessionS) {

		int ret = pService.update(productVO);
		
		sessionS.setComplete();
		model.addAttribute("MSG","데이터 수정 성공!!");
		
		return "redirect:/product/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam String p_code, Model model) {

		pService.delete(p_code);
		
		return "redirect:/product/list";
	}
}
