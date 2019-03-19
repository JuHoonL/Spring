package com.biz.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.*;

import com.biz.file.model.MemberVO;

public interface MemberDao {

	@Select(" SELECT * FROM tbl_member ")
	public List<MemberVO> selectAll();
	
	@Select(" SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ")
	public List<MemberVO> findByUserid(MemberVO vo);
	
	@InsertProvider(type=MemberSQL.class, method="member_insert_sql")
	public int insert(MemberVO membervo);
	
	@UpdateProvider(type=MemberSQL.class, method="member_update_sql")
	public int update(MemberVO membervo);
	
	@Delete(" DELETE FROM tbl_member WHERE m_userid = #{m_userid} ")
	public int delete(String m_userid);
}
