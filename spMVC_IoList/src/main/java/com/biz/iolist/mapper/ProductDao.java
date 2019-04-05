package com.biz.iolist.mapper;

import java.util.List;

import com.biz.iolist.model.IolistVO;
import com.biz.iolist.model.ProductVO;

public interface ProductDao {

	public List<ProductVO> selectAll();
	
	public ProductVO findById(String p_code);
	
	public List<ProductVO> findByPName(String p_name);
	
	public int insert(ProductVO productVO);

	public int update(ProductVO productVO);
	
	public int delete(String p_code);

}
