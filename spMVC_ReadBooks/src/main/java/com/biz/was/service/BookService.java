package com.biz.was.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.was.mapper.BookDao;
import com.biz.was.model.BookVO;

@Service
public class BookService {

	@Autowired
	BookDao bookmapper;
	
	public List<BookVO> sellectAll() {

		return bookmapper.sellectAll();
	}
	
	public BookVO findByid(String b_id) {
		
		return bookmapper.findByid(Long.valueOf(b_id));
	}
	
	public List<BookVO> findByuserid(String b_userid) {
		return bookmapper.findByUserid(b_userid);
	}

	public int update(BookVO bookVO) {
		
		return bookmapper.update(bookVO);
	}

	public int delete(String b_id) {
		
		return bookmapper.delete(Long.valueOf(b_id));
	}

	public int insert(BookVO bookVO) {
		return bookmapper.insert(bookVO);
	}

}
