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
	
	public List<DeptVO> deptGetAllList() {
		List<DeptVO> dList = new ArrayList<DeptVO>();
		
		dList = dmap.selectAll();
		
		return dList;
	}

	public DeptVO getDeptfindByCode(String d_code) {
		// TODO Auto-generated method stub
		
		DeptVO vo = dmap.findByDCode(d_code);
		
		return vo;
	}

	public List<DeptVO> getFindByDName(String d_name) {

		List<DeptVO> dList = new ArrayList<DeptVO>();
		
		dList = dmap.findBYDName(d_name.trim());
		
		return dList;
	}

	public int insertOrUpdate(DeptVO deptVO) {
		// 새로 등록이냐 아니면 수정이냐
		
		int ret = 0;
		
		String d_code = deptVO.getD_code();
		DeptVO tvo = dmap.findByDCode(d_code);
		
		if(tvo == null) {
			ret = dmap.insert(deptVO);
		} else {
			ret = dmap.update(deptVO);
		}
		
		return ret;
	}
}
