package com.biz.memo01.model;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface MemoDao {
	
	@Select(MemoSQL.MEMO_SELECTALL)
	public List<MemoVO> selectAll();
	
	@Select(MemoSQL.MEMO_FIND_BY_ID)
	public MemoVO findById(long Id);
	
	@Insert(MemoSQL.MEMO_INSERT)
	public int insert(MemoVO vo);
	
	@Update(MemoSQL.MEMO_UPDATE)
	public int update(MemoVO vo);
	
	@Delete(MemoSQL.MEMO_DELETE)
	public int delete(long Id);
}
