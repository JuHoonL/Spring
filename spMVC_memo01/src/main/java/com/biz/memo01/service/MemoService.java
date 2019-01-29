package com.biz.memo01.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo01.model.MemoDao;
import com.biz.memo01.model.MemoVO;

@Service
public class MemoService {

//	@Autowired
//	SqlSession sqlSession;
	@Autowired
	MemoDao memoMapper;
	
	// MemoDao의 selectAll() 메서드를 호출해서 select SQL을
	//실행한 다음 결과를 memoList에 받고 아무런 가공 없이
	//Controller로 return
	public List<MemoVO> selectAll(){
		List<MemoVO> memoList = memoMapper.selectAll();
		return memoList;
	}
	
	public int insert(MemoVO vo) {
//		MemoDao dao = sqlSession.getMapper(MemoDao.class);
//		int ret = dao.insert(vo);
//		sqlSession.commit();
		
		int ret  = memoMapper.insert(vo);
		return ret;
	}

	public MemoVO findById(long id) {
		
		MemoVO vo = memoMapper.findById(id);
		return vo;
	}

	public int delete(Long Id) {
		// TODO Auto-generated method stub
		
		return memoMapper.delete(Id);
	}

	public void memo_write(MemoVO vo) {
		/*
		 vo에는 form에서 보내온 데이터가 담겨있다
		 vo member변수 중에서 없는 값이 있다. (id값)
		 
		 새로 메모를 작성하기를 했을 경우 id값이 아마도 0일 것이다.
		 메모를 수정하기로 했을 경우는 id값이 0 이외의 값일 것이다.
		 */
		if(vo.getId()>0) {
			memoMapper.update(vo);
		} else {
			memoMapper.insert(vo);
		}
		
	}
}
