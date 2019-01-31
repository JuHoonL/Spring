package com.biz.memo02.model;

public class MemoSQL {

	public static final String MEMO_SELECTALL
	= " SELECT * FROM tbl_memo ";
	
	public static final String MEMO_FINDBYID
	= " SELECT * FROM tbl_memo WHERE id = #{id} ";
	
	public static final String MEMO_INSERT
	= " INSERT INTO tbl_memo VALUES(#{id}, #{auth}, #{date}, #{subject}, #{text}) ";

	public static final String MEMO_UPDATE
	= " UPDATE tbl_memo SET auth = #{auth}, date = #{date}, subject = #{subject}, text = #{text} WHERE id = #{id} ";
	
	public static final String MEMO_DELETE
	= " DELETE FROM tbl_memo WHERE id = #{id} ";
}
