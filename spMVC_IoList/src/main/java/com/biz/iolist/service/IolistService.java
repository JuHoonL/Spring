package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.IoListDao;
import com.biz.iolist.model.IolistDto;
import com.biz.iolist.model.IolistVO;

@Service
public class IolistService {

	@Autowired
	SqlSession session;
	
	public List<IolistVO> selectAll() {
		
		IoListDao dao = session.getMapper(IoListDao.class);
		
		return dao.selectAll();
	}
	
	public List<IolistDto> iolistJoin(){

		IoListDao dao = session.getMapper(IoListDao.class);
		
		return dao.iolistJoin();
	}
	
	public IolistVO findById(long io_id) {
		
		IoListDao dao = session.getMapper(IoListDao.class);
		
		return dao.findById(io_id);
	}
	
	public int insert(IolistVO iolistVO) {

		IoListDao dao = session.getMapper(IoListDao.class);
		
		return dao.insert(iolistVO);
	}
	
	public int update(IolistVO iolistVO) {

		IoListDao dao = session.getMapper(IoListDao.class);
		
		return dao.update(iolistVO);
	}
	
	public int delete(long io_id) {

		IoListDao dao = session.getMapper(IoListDao.class);
		
		return dao.delete(io_id);
	}
}
