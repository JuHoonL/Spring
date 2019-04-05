package com.biz.bbs.service;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.MemberDao;
import com.biz.bbs.model.MemberVO;

import lombok.extern.slf4j.Slf4j;

/*
 	Service interface를 implement 하여 구현한 실체 Class
 	(method에 구체적인 기능들을 넣어 코딩한 Class)
 	
 	인터페이스와 구현체의 사용
 	일반적으로 클래스를 사용하기 위해서 아래와 같이 생성
 		클래스 객체 = new 클래스()
 		
 	인터페이스와 구현체일 경우는
 		인터페이스 객페 = new 구현체()
 		예> List<MemberVO> memberList = new ArrayList<MemberVO>();
 		예> MemberService ms = new MemberServiceImp();
 	JAVA에서는 어떤 Class에 interface가 있는 경우는 가능하면 interface로 선언을 하고
 	Class로 생성하는 것을 권장한다.
 		예> ArrayList<MemberVO> memberList = new ArrayList<MemberVO>(); 일반적인 방식
 				=> List<MemberVO> memberList = new ArrayList<MemberVO>(); 권장하는 방식
 */

@Slf4j
@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByUserId(String m_userid) {

		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		
		return mdao.findByUserid(m_userid);
	}

	@Override
	public int insert(MemberVO memberVO) {
		
		String plainPassword = encoder.encode(memberVO.getM_password());
		
		log.debug("원래 비번 : " + memberVO.getM_password());
		log.debug("암호화된 비번 : " + plainPassword);
		
		memberVO.setM_password(plainPassword);
		
		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		
		int ret = mdao.insert(memberVO);
		
		return ret;
	}

	@Override
	public int update(MemberVO memberVO) {
		
		memberVO.setM_password(encoder.encode(memberVO.getM_password()));
		
		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		
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
		
		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		
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
