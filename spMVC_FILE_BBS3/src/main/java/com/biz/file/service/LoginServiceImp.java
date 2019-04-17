package com.biz.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.file.mapper.LoginDao;
import com.biz.file.model.MemberVO;

@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	LoginDao ldao;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public MemberVO getMemberInfo(MemberVO memberVO) {
		
		MemberVO vo = ldao.getMemberInfo(memberVO.getM_userid());
		
		System.out.println(vo.toString());
		
		if(encoder.matches(memberVO.getM_password(), vo.getM_password())) {
			memberVO = vo;
		} else {
			memberVO = null;
		}
		
		return memberVO;
	}

}
