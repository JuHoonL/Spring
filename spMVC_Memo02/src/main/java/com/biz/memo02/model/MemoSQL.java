package com.biz.memo02.model;

public class MemoSQL {

	public static final String MEMO_SELECTALL
	= " SELECT * FROM tbl_memo ORDER BY id ";
	
	public static final String MEMO_FINDBYID
	= " SELECT * FROM tbl_memo WHERE id = #{id} ";
	
	public static final String MEMO_INSERT
	= " INSERT INTO tbl_memo VALUES(SEQ_MEMO.NEXTVAL, #{m_auth}, #{m_date}, #{m_subject}, #{m_text}) ";

	public static final String MEMO_UPDATE
	= " UPDATE tbl_memo SET m_auth = #{m_auth}, m_date = #{m_date}, m_subject = #{m_subject}, m_text = #{m_text} WHERE id = #{id} ";
	
	public static final String MEMO_DELETE
	= " DELETE FROM tbl_memo WHERE id = #{id} ";
}
