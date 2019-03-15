package com.biz.was.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.biz.was.model.BookVO;

public interface BookDao {

	@Select(BookSQL.SELECTAll)
	public List<BookVO> sellectAll();
	
	@Select(BookSQL.FINDBYID)
	public BookVO findByid(long b_id);
	
	@Select(BookSQL.FINDBYUSERID)
	public List<BookVO> findByUserid(String b_userid);
	
	@Insert(BookSQL.INSERT)
	public int insert(BookVO bookVO);
	
	@Update(BookSQL.UPDATE)
	public int update(BookVO bookVO);
	
	@Delete(BookSQL.DELETE)
	public int delete(long b_id);
}
