package com.biz.bbs.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.MemberDao;
import com.biz.bbs.model.MemberVO;

@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public MemberVO getMemberInfo(MemberVO memberVO) {
		
		MemberDao ldao = sqlSession.getMapper(MemberDao.class);
		
		MemberVO vo = ldao.findByUserid(memberVO.getM_userid());
		
		System.out.println(vo.toString());
		
		if(encoder.matches(memberVO.getM_password(), vo.getM_password())) {
			memberVO = vo;
		} else {
			memberVO = null;
		}
		
		return memberVO;
	}

}
