package com.biz.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.file.mapper.BoardDao;
import com.biz.file.model.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BBSServiceImp implements BBSService {

	@Autowired
	BoardDao bdao;
	
	@Override
	public List<BoardVO> selectAll() {
		return bdao.selectAll();
	}

	/*
	 	2번 이상의 SQL문이 실행되는 경우 SQL 실행이 모두 완료되기전에 다른사용자(또는 접속)에 의해서 
	 	메서드가 실행되면 데이터 신뢰도에 문제가 발생할 수 있다.
	 	
	 	그러한 문제를 막기 위해서 RDBMS에서는 2번이상의 SQL문을 Transaction이라는 작업그룹으로 묶어 주어야한다.
	 	
	 	스프링과 mybatis프로젝트에서는 mybatis-context.xml 또는 MyBatisConfig에서 DataTransactionManager를
	 	bean으로 설정 해 두고 transaction이 필요한 method에서 @Transactional을 설정해 두면 나머지 
	 	Spring, Mybatis, DataSource들끼리 서로 협력하여 모든 처리를 대신 해준다.
	 */
	@Override
	@Transactional
	public BoardVO findByIdNUser_id(long id, String b_userid) {
		
		BoardVO vo = bdao.findById(id);
		log.debug(vo.toString());
		if(!vo.getB_userid().equalsIgnoreCase(b_userid)) {
			bdao.boardHit(id);
		}
		
		return vo;
	}
	
	@Override
	public BoardVO findById(long id) {
		
		BoardVO vo = bdao.findById(id);
		
		return vo;
	}

	@Override
	public List<BoardVO> findByUserid(String b_userid) {
		return bdao.findByUserid(b_userid);
	}

	@Override
	public int insert(BoardVO boardVO) {
		int ret = bdao.insert(boardVO);
		
		return ret;
	}

	@Override
	public int update(BoardVO boardVO) {
		int ret = bdao.update(boardVO);
		
		return ret;
	}

	@Override
	public int delete(long id) {
		
		int ret = bdao.delete(id);
		
		return ret;
	}


}
