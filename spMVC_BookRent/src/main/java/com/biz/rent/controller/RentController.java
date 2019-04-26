package com.biz.rent.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.rent.model.CartVO;
import com.biz.rent.model.JUserVO;
import com.biz.rent.model.RentVO;
import com.biz.rent.service.JUserService;
import com.biz.rent.service.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RentController {

	@Autowired
	JUserService uService;
	
	@Autowired
	RentService rService;
	
	@ResponseBody
	@RequestMapping(value="check_out",method=RequestMethod.GET,produces="text/html;charset=utf8")
	public String check_out(HttpSession httpsession) {
		List<CartVO> cartList = (List)httpsession.getAttribute("CART");
		
		if(cartList == null) {
			return "선택 도서가 없습니다.";
		}
		
		int Sum = 0;
		for(CartVO vo : cartList) {
			RentVO rentVO = new RentVO();
			rentVO.setRent_date(vo.getCart_date());
			rentVO.setRent_return_date(vo.getCart_return_date());
			rentVO.setBook_seq(vo.getBook_seq());
			rentVO.setUser_seq(vo.getUser_seq());
			rentVO.setRent_return_yn("N");
			
			rService.insert(rentVO);
			
			Sum += vo.getBook_price();
		}
		
		int today_rent_count = cartList.size();
		int today_rent_total = Sum;
		
		JUserVO userVO = uService.findById(cartList.get(0).getUser_seq());
		
		userVO.setUser_rent_count(userVO.getUser_rent_count()+today_rent_count);
		userVO.setUser_rent_total(userVO.getUser_rent_total()+today_rent_total);
		
		int ret = uService.update(userVO);
		
		httpsession.setAttribute("CART",null);
		
		return "CHECK_OK";
	}
}
