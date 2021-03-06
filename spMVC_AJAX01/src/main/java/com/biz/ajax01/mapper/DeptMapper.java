package com.biz.ajax01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.biz.ajax01.model.DeptVO;

public interface DeptMapper {

	@Select(" SELECT * FROM tbl_dept ORDER BY d_code ")
	public List<DeptVO> selectAll();
	
	@Select(" SELECT * FROM tbl_dept WHERE d_code = #{d_code,jdbcType=VARCHAR} ")
	public DeptVO findByDCode(String d_code);
	
	@Select(" SELECT * FROM tbl_dept WHERE d_name LIKE '%'||#{d_name,jdbcType=NVARCHAR}||'%' ORDER BY d_name ")
	public List<DeptVO> findBYDName(String d_name);
	
	
	@InsertProvider(type=DeptSQLBuilder.class,method="getInsertSQL")
	public int insert(DeptVO vo);
	
	@UpdateProvider(type=DeptSQLBuilder.class,method="getUpdateSQL")
	public int update(DeptVO vo);
	
	@Delete(" DELETE FROM tbl_dept WHERE d_code = #{d_code,jdbcType=VARCHAR} ")
	public int delete(String d_code);
}
