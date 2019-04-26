package com.biz.rent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rent.model.JUserVO;

public interface JUserDao {

	@Select(" SELECT * FROM tbl_juser ")
	public List<JUserVO> selectAll();
	
	@Select(" SELECT * FROM tbl_juser WHERE user_seq = #{user_seq} ")
	public JUserVO findByUserSeq(long user_seq);
	
	@Select(" SELECT * FROM tbl_juser WHERE user_name LIKE '%' || #{user_name} || '%' ")
	public List<JUserVO> findByUserName(String user_name);
	
	@Select(" SELECT * FROM tbl_juser WHERE user_phone LIKE '%' || #{user_phone} || '%' ")
	public List<JUserVO> findByPhone(String user_phone);
	
	@Select(" SELECT * FROM tbl_juser WHERE user_name = #{user_name} and user_phone = #{user_phone} ")
	public JUserVO findByNandP(String user_name, String user_phone);
	
	@InsertProvider(type=UserSQL.class, method="user_insert_sql")
	public int insert(JUserVO userVO);
	
	@UpdateProvider(type=UserSQL.class, method="user_update_sql")
	public int update(JUserVO userVO);
	
	@Delete(" DELETE FROM tbl_juser WHERE user_seq=#{user_seq} ")
	public int delete(long user_seq);
}
