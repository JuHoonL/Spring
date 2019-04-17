package com.biz.file.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.file.mapper.MemberDao;
import com.biz.file.model.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDao mdao;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByUserId(String m_userid) {
		// TODO Auto-generated method stub
		return mdao.findByUserid(m_userid);
	}

	@Override
	public int insert(MemberVO memberVO) {
		
		String plainPassword = encoder.encode(memberVO.getM_password());
		
		log.debug("원래 비번 : " + memberVO.getM_password());
		log.debug("암호화된 비번 : " + plainPassword);
		
		memberVO.setM_password(plainPassword);
		
		int ret = mdao.insert(memberVO);
		
		return ret;
	}

	@Override
	public int update(MemberVO memberVO) {
		
		memberVO.setM_password(encoder.encode(memberVO.getM_password()));
		
		int ret = mdao.update(memberVO);
		
		return ret;
	}

	@Override
	public int delete(String m_userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(@Valid MemberVO memberVO) {

		int ret = 0;
		
		MemberVO vo = mdao.findByUserid(memberVO.getM_userid());
		
		if(vo == null) {
			this.insert(memberVO);
			ret = 1;
		} else {
			if(encoder.matches(memberVO.getM_password(), vo.getM_password())) {
				this.update(memberVO);
				ret = 2;
			} else {
				ret = -1;
			}
		}
		return ret;
	}

}
