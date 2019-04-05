package com.biz.bbs.mapper;

import java.util.List;

import com.biz.bbs.model.MemberVO;

public interface MemberDao {

	public List<MemberVO> selectAll();
	
	public MemberVO findByUserid(String m_userid);
	
	public int insert(MemberVO membervo);
	
	public int update(MemberVO membervo);
	
	public int delete(String m_userid);
}


