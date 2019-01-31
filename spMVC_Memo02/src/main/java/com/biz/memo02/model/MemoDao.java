package com.biz.memo02.model;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.biz.memo02.vo.MemoVO;

public interface MemoDao {
	
	@Select(MemoSQL.MEMO_SELECTALL)
	public List<MemoVO> selectAll();
	
	@Select(MemoSQL.MEMO_FINDBYID)
	public MemoVO findById(long id);
	
	@Insert(MemoSQL.MEMO_INSERT)
	public int insert(MemoVO vo);
	
	@Update(MemoSQL.MEMO_UPDATE)
	public int update(MemoVO vo);
	
	@Delete(MemoSQL.MEMO_DELETE)
	public int delete(long id);
}
