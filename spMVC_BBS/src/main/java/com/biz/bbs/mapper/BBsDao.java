package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.bbs.model.BBsVO;

public interface BBsDao {

	public List<BBsVO> selectAll();
	
	public List<BBsVO> pageSelect(@Param("start") long start, @Param("end") long end);
	
	public BBsVO findById(long id);

	public int insert(BBsVO bbsVO);

	public int update(BBsVO bbsVO);
	
	public int delete(long id);
}
