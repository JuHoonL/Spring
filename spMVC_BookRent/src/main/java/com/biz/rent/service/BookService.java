package com.biz.rent.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.biz.rent.mapper.BookDao;
import com.biz.rent.model.BookVO;

@Service
public class BookService {

	@Autowired
	ServletContext context;
	
	@Autowired
	BookDao dao;
	
	public List<BookVO> selectAll() {
		
		return dao.selectAll();
	}
	
	public BookVO findById(long book_seq) {
		
		return dao.findByBookSeq(book_seq);
	}
	
	public BookVO findByBookIsbn(String book_isbn) {
		
		return dao.findByBookIsbn(book_isbn);
	}
	
	public int insert(BookVO bookVO) {
		int ret = dao.insert(bookVO);
		
		return ret;
	}
	
	public int update(BookVO bookVO) {
		int ret = dao.update(bookVO);
		
		return ret;
	}
	
	public int delete(long book_seq) {
		int ret = dao.delete(book_seq);
		
		return ret;
	}
	
	@Transactional
	public BookVO fileUp(BookVO bookVO, MultipartFile u_file) {
		String fileName = u_file.getOriginalFilename();
		String saveFileName = "";
		
		String realPath = context.getRealPath("/");
		String upLoadPath = realPath + "files/";
		
		if(u_file != null) {
			if(u_file.getSize() > 10485760) {
				return null;
			}
			if(fileName != null && !fileName.equals("")) {
				saveFileName = UUID.randomUUID().toString() + fileName;
				
				File dir = new File(upLoadPath);
				if(!dir.exists()) { 	
					dir.mkdir();		
				}
				
				File upLoadFile = new File(upLoadPath, saveFileName);
				
				try {
					u_file.transferTo(upLoadFile);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			} 
			bookVO.setBook_image(saveFileName);
		}
		return bookVO;
	}
	
	public List<BookVO> getSearchList(String s_string) {
		
		return dao.getSearchList(s_string);
	}
	
	public BookVO getSearchList1(String isbn) {
		
		long rent_isbn = Long.valueOf(isbn);
		
		return dao.getSearchIsbn(rent_isbn);
	}
	
	public List<BookVO> getSearchList2(String s_string) {
		
	try {	
		long rent_isbn = Long.valueOf(s_string);
		
		return dao.getSearchByIsbn(s_string);
		
	} catch (Exception e) {
		
	}
		return dao.getSearchList(s_string);
	}
}
