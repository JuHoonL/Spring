package com.biz.rent.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rent.model.CartVO;
import com.biz.rent.model.RentVO;
import com.biz.rent.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rent")
@SessionAttributes("rentVO")
public class CartController {

	@Autowired
	CartService cService;
	
	
	@ModelAttribute("rentVO")
	public RentVO newRent() {
		return new RentVO();
	}
	
	@RequestMapping(value="/cart",method=RequestMethod.POST)
	public String cart(@ModelAttribute("rentVO") RentVO rentVO, Model model, HttpSession httpSession) {
		
		log.debug("book_isbn : " + rentVO.getBook_isbn());
		
		try {
			List<CartVO> cart =(List)httpSession.getAttribute("CART");
			
			List<CartVO> addCart = cService.addCart(cart, rentVO);
			
			if(addCart != null) {
				httpSession.setAttribute("CART",addCart);
				
				for(CartVO vo : addCart) {
					log.debug("CartVO : " + vo.toString());
				}
			}
			
			return "rent_body/rent_cart";
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("rentVO",rentVO);
		
		return "home2";
	}
	
	@RequestMapping(value="/cart_clear", method=RequestMethod.GET)
	public String cart_clear(HttpSession httpsession) {
		
//		httpsession.invalidate(); // 모든세션 제거
		
		httpsession.setAttribute("CART",null);	// 해당 세션만 제거시
		
		httpsession.removeAttribute("CART");	// 
		
		return "rent_body/rent_cart";
	}
	
	@RequestMapping(value="/item_del/{index}", method=RequestMethod.GET)
	public String cart_item_del(@PathVariable("index") int index, HttpSession httpsession) {
		
		if(index > -1) {
			List<CartVO> cartList = (List)httpsession.getAttribute("CART");
			if(cartList != null) {
				cartList.remove(index);
				
				httpsession.setAttribute("CART",cartList);
			}
		}
		
		return "rent_body/rent_cart";
	}

	@RequestMapping(value="/cart_item_del/{book_seq}", method=RequestMethod.GET)
	public String cart_item_del(@PathVariable("book_seq") long book_seq, HttpSession httpsession) {
		
		List<CartVO> cartList = (List)httpsession.getAttribute("CART");
			
		if(cartList != null && book_seq != 0) {
		
			int count = cartList.size();
			for(int i = 0; i < count ; i++) {
				if(cartList.get(i).getBook_seq() == (book_seq)) {
					cartList.remove(i);
					break;
				}
			}
			httpsession.setAttribute("CART",cartList);
		}
		
		return "rent_body/rent_cart";
	}
}
