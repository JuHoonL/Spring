package com.biz.memo03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.memo03.model.MemberVO;

public interface MemberDao {

	public List<MemberVO> selectAll();
	
	@Select(" SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ")
	public MemberVO checkUserID(String m_userid);
	
	@Select(" SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ")
	public List<MemberVO> findByUserid(MemberVO vo);
	
	@InsertProvider(type=MemberSQL.class, method="member_insert_sql")
	public int insert(MemberVO membervo);
	public int update(MemberVO membervo);
	public int delete(String m_userid);
}
