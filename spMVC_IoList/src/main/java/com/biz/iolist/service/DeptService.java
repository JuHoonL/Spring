package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.DeptDao;
import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.DeptVO;
import com.biz.iolist.model.ProductVO;

//@Service Annotation을 사용하지 않으려면 spring폴더에서 빈생성파일을 생성해줘야함
@Service
public class DeptService {
	
	@Autowired
	SqlSession session;
	
	public List<DeptVO> selectAll() {
		
		DeptDao dao = session.getMapper(DeptDao.class);
		
		return dao.selectAll();
	}
	
	public String getDName(String d_code) {

		DeptDao dao = session.getMapper(DeptDao.class);
		
		String getD_name = dao.findById(d_code).getD_name();
		
		return getD_name;
	}
	
	public DeptVO findById(String d_code) {
		
		DeptDao dao = session.getMapper(DeptDao.class);
		
		return dao.findById(d_code);
	}
	
	public String getDCode() {
		
		DeptDao dao = session.getMapper(DeptDao.class);
		
		String d_code = dao.getDCode();
		String new_dcode = "";
		
		if(d_code != null) {
			d_code = d_code.substring(1); // substring(i) : i 번째부터 출력(0번쨰는 빠짐)
			int temp_code = Integer.valueOf(d_code.trim()) + 1; // trim() : 빈칸제거
			new_dcode = String.format("D%04d", temp_code); 
			/* format에서 %d는 숫자 -> 문자변환 
			 * %4d는 4자리 문자열변화(남은뒷자리 0으로 채움)
			 * %04d는 4자리 문자열변화(남은 문자를 앞에 0으로 채움) */
		}
		return new_dcode;
	}
	
	public int insert(DeptVO deptVO) {

		DeptDao dao = session.getMapper(DeptDao.class);
		
		return dao.insert(deptVO);
	}
	
	public int update(DeptVO deptVO) {

		DeptDao dao = session.getMapper(DeptDao.class);
		
		return dao.update(deptVO);
	}
	
	public int delete(String d_code) {

		DeptDao dao = session.getMapper(DeptDao.class);
		
		return dao.delete(d_code);
	}

	public List<DeptVO> findByPName(String d_name) {

		DeptDao dao = session.getMapper(DeptDao.class);
		
		return dao.findByDName(d_name);
	}
}
