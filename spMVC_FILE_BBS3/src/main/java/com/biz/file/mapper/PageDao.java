package com.biz.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.file.model.BoardVO;

public interface PageDao {

	@Select(" SELECT COUNT(*) FROM tbl_board ")
	public long getCount();
	
	@Select(" SELECT * FROM (SELECT ROWNUM R, B.*  FROM tbl_board B WHERE B.b_date > '0000-00-00' ORDER BY B.b_date DESC, B.b_time DESC) M WHERE R BETWEEN #{start} AND #{end} ")
	public List<BoardVO> pageList(@Param("start") long start, @Param("end") long end);
	
	@Select(" SELECT M.* FROM\r\n " 
			+" (SELECT ROW_NUMBER() OVER (ORDER BY B_DATE DESC, B_TIME DESC) R, "
			+ " B_DATE, B_TIME, B_SUBJECT, B_CONTENT FROM tbl_board) M\r\n " 
			+ " WHERE M.R BETWEEN #{start} AND #{end} ")
	public List<BoardVO> selectPage(@Param("start") long start, @Param("end") long end);
}
