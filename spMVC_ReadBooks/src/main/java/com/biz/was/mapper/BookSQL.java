package com.biz.was.mapper;

public class BookSQL {

	public static final String SELECTAll = " SELECT * FROM tbl_book ORDER BY b_id ";
	
	public static final String FINDBYID = " SELECT * FROM tbl_book WHERE b_id = #{b_id} ";
	
	public static final String FINDBYUSERID = " SELECT * FROM tbl_book WHERE b_userid = #{b_userid} ";
	
	public static final String INSERT
	= " INSERT INTO tbl_book VALUES (SEQ_BOOK.NEXTVAL,#{b_userid},#{b_isbn},#{b_title},#{b_date},#{b_star},#{b_text}) ";
	
	public static final String UPDATE
	= " UPDATE tbl_book SET b_userid=#{b_userid}, "
						+ " b_isbn=#{b_isbn}, "
						+ " b_title=#{b_title}, "
						+ " b_date=#{b_date}, "
						+ " b_star=#{b_star}, "
						+ " b_text=#{b_text} "
						+ " WHERE b_id = #{b_id} ";
	
	public static final String DELETE = " DELETE FROM tbl_book WHERE b_id = #{b_id} ";
}
