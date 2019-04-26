package com.biz.rent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.BookDao;
import com.biz.rent.mapper.JUserDao;
import com.biz.rent.model.BookVO;
import com.biz.rent.model.CartVO;
import com.biz.rent.model.JUserVO;
import com.biz.rent.model.RentVO;

@Service
public class CartService {

	@Autowired
	BookDao bdao;
	
	@Autowired
	JUserDao udao;
	
	public List<CartVO> addCart(List<CartVO> cartList, RentVO rentVO) {
		
		if(cartList == null) {
			cartList = new ArrayList<CartVO>(); 
		}
		
		String book_isbn = rentVO.getBook_isbn();
		long user_seq = rentVO.getUser_seq();
		
		BookVO bookVO = bdao.findByBookIsbn(book_isbn);
		JUserVO userVO = udao.findByUserSeq(user_seq);
		
		if(bookVO != null && userVO != null) {
			CartVO cartVO = new CartVO();
			
			cartVO.setBook_seq(bookVO.getBook_seq());
			cartVO.setBook_title(bookVO.getBook_title());
			cartVO.setBook_price(bookVO.getBook_price());
			cartVO.setUser_seq(userVO.getUser_seq());
			cartVO.setUser_name(userVO.getUser_name());
			cartVO.setCart_date(rentVO.getRent_date());
			cartVO.setCart_return_date(rentVO.getRent_return_date());
			cartVO.setCart_return_yn(rentVO.getRent_return_yn());
			
			cartList.add(cartVO);
			
			return cartList;
		}
		
		return null;
	}
}
