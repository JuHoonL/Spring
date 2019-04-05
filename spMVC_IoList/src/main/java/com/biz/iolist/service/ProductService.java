package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.IolistVO;
import com.biz.iolist.model.ProductVO;

@Service
public class ProductService {

	@Autowired
	SqlSession session;
	
	public List<ProductVO> selectAll() {
		
		ProductDao dao = session.getMapper(ProductDao.class);
		
		return dao.selectAll();
	}
	
	public String getPName(String p_code) {

		ProductDao dao = session.getMapper(ProductDao.class);
		
		String getP_name = dao.findById(p_code).getP_name();
		
		return getP_name;
	}
	
	public ProductVO findById(String p_code) {
		
		ProductDao dao = session.getMapper(ProductDao.class);
		
		return dao.findById(p_code);
	}

	public List<ProductVO> findByPName(String p_name) {

		ProductDao dao = session.getMapper(ProductDao.class);
		
		return dao.findByPName(p_name);
	}
	
	public int insert(ProductVO productVO) {

		ProductDao dao = session.getMapper(ProductDao.class);
		
		return dao.insert(productVO);
	}
	
	public int update(ProductVO productVO) {

		ProductDao dao = session.getMapper(ProductDao.class);
		
		return dao.update(productVO);
	}
	
	public int delete(String p_code) {

		ProductDao dao = session.getMapper(ProductDao.class);
		
		return dao.delete(p_code);
	}

}
