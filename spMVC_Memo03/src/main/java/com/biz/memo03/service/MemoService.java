package com.biz.memo03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo03.mapper.MemoDao;
import com.biz.memo03.model.MemoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemoService {

	@Autowired
	MemoDao dao;
	
	public int insert(MemoVO memovo) {

		int ret = dao.insert(memovo);
		
		return ret;
	}

	public List<MemoVO> selectAll() {

		return dao.selectAll();
	}
	
	public List<MemoVO> selectByuserId(String m_userid) {

		return dao.selectByuserId(m_userid);
	}

	public MemoVO findById(long id) {
		
		return dao.findById(id);
	}

	public int save(MemoVO memoVO) {
		
		int ret = 0;
		
		if(memoVO.getId() > 0) {
			ret = dao.update(memoVO);
		} else {
			log.debug("BEFORE INSERT MEMOID : " + memoVO.getId());
			ret = dao.insert(memoVO);
			log.debug("AFTER INSERT MEMOID : " + memoVO.getId());
		}
		
		return ret;
	}

	public int delete(long id) {

		return dao.delete(id);
	}

}
