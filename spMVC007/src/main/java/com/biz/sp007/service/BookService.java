package com.biz.sp007.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.sp007.model.BookVO;

@Service
public class BookService {

	public BookVO changeAuth(BookVO vo) {
		// TODO Auto-generated method stub
		String strAuth = vo.getB_auth();
		
		strAuth += ">> 이몽룡";
		
		return vo;
	}

	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		List<BookVO> bookList = new ArrayList();
		for(int i = 0 ; i < 10 ; i ++) {
			BookVO vo = new BookVO();
			
			vo.setB_title("NO." + i + " 번째 책");
			vo.setB_comp("Korea co.kr");
			vo.setB_auth("홍길동" + i);
			vo.setB_price(15000);
			
			bookList.add(vo);
		}
		return bookList;
	}

}
