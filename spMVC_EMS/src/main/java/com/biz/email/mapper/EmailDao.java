package com.biz.email.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.email.model.EmailVO;

public interface EmailDao {

	@Select(EmailSQL.SELECTAll)
	public List<EmailVO> sellectAll();
	
	@Select(EmailSQL.FINDBYID)
	public EmailVO findByid(long id);
	
	@Select(EmailSQL.FINDBYFROMUSERID)
	public List<EmailVO> findByFROMUserid(String from_email);
	
	@Select(EmailSQL.FINDBYTOUSERID)
	public List<EmailVO> findByTOUserid(String to_email);
	
	@Insert(EmailSQL.INSERT)
	public int insert(EmailVO emailVO);
	
	@Update(EmailSQL.UPDATE)
	public int update(EmailVO emailVO);
	
	@Delete(EmailSQL.DELETE)
	public int delete(long id);
}
