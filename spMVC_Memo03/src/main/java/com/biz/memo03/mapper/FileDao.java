package com.biz.memo03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.biz.memo03.model.FileVO;

public interface FileDao {

	@Select(" SELECT * FROM tbl_files WHERE parent_id = #{parent_id} ")
	public List<FileVO> selectById(long parent_id);
	
	@Select(" SELECT * FROM tbl_files WHERE id = #{id} ")
	public FileVO findById(long id);
	
	@InsertProvider(type=FileSQL.class, method="file_insert_sql")
	public int insert(FileVO fileVO);
	
	@Delete(" DELETE FROM tbl_files WHERE id = #{id} ")
	public int delete(long id);
}
