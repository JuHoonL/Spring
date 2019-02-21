package com.biz.ajax01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ajax01.mapper.DeptMapper;
import com.biz.ajax01.model.DeptVO;

@Service
public class DeptService {
	
	@Autowired
	DeptMapper dmap;
	
	public List<DeptVO> deptGetList() {
		List<DeptVO> dList = new ArrayList<DeptVO>();
		
		dList = dmap.selectAll();
		
		return dList;
	}
}
