package com.biz.memo03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo03.mapper.MemberDao;
import com.biz.memo03.model.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDao mdao;
	
	public List<MemberVO> findByUserid(MemberVO membervo) {
		
		return mdao.findByUserid(membervo);
	}
	
	public int insert(MemberVO membervo) {
		
		return mdao.insert(membervo);
	}

	public MemberVO id_check(String m_userid) {
		
		return mdao.checkUserID(m_userid);
	}
}
