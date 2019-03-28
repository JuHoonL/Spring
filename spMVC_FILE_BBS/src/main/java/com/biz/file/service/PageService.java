package com.biz.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.file.mapper.PageDao;
import com.biz.file.model.BoardVO;

@Service
public class PageService {

	@Autowired
	PageDao pdao;
	
	public long getCount() {
		
		return pdao.getCount();
	}
	
	public List<BoardVO> pageList(long start, long end) {
	
		List<BoardVO> bbsList = pdao.pageList(start, end);
		
		return bbsList;
	}
}
