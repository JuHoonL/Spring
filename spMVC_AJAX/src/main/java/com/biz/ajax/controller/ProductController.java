package com.biz.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ajax.service.ProductService;
import com.biz.ajax.vo.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	@RequestMapping(value="product", method=RequestMethod.GET)
	public String productView(Model model) {
		
		List<ProductVO> pList = ps.readFile();
		
		model.addAttribute("PRODUCT",pList);	
		
		
		return "home";
	}
}
