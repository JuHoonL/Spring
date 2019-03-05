package com.biz.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.memo.model.MemberVO;

public interface MemberDao {

	public List<MemberVO> selectAll();
	
	@Select(" SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ")
	public List<MemberVO> findByUserid(String m_userid);
	
	@InsertProvider(type=MemberSQL.class, method="member_insert_sql")
	public int insert(MemberVO membervo);
	public int update(MemberVO membervo);
	public int delete(String m_userid);
}
