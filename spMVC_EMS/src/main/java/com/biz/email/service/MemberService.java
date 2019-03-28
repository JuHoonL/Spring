package com.biz.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.email.mapper.MemberDao;
import com.biz.email.model.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDao membermapper;
	
	public MemberVO findByid(long m_id) {
		
		return membermapper.findByid(m_id);
	}
	
	public List<MemberVO> findByUserid(MemberVO membervo) {
		
		return membermapper.findByUserid(membervo);
	}
	
	public int insert(MemberVO membervo) {
		
		return membermapper.insert(membervo);
	}

	public MemberVO id_check(String m_userid) {
		
		return membermapper.checkUserID(m_userid);
	}
}
