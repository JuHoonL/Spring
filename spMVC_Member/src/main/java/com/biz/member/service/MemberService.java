package com.biz.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.member.mapper.MemberDao;
import com.biz.member.model.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDao dao;

	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		int ret = dao.insert(vo);
		
		return ret;
	}

	public MemberVO findById(String m_userid) {
		// TODO Auto-generated method stub
		
		MemberVO vo = dao.findById(m_userid);
		
		return vo;
	}

	public List<MemberVO> loginCheck(String m_userid) {
		// TODO Auto-generated method stub
		
		List<MemberVO> mList =  dao.loginCheck(m_userid);
		
		
		return mList;
	}
	
	
}
