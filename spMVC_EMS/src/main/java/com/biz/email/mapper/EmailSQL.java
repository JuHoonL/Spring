package com.biz.email.mapper;

public class EmailSQL {

	public static final String SELECTAll = " SELECT * FROM tbl_email ORDER BY id ";
	
	public static final String FINDBYID = " SELECT * FROM tbl_email WHERE id = #{id} ";
	
	public static final String FINDBYUSERID = " SELECT * FROM tbl_email WHERE to_email = #{to_email} ";
	
	public static final String INSERT
	= " INSERT INTO tbl_email VALUES (SEQ_EMAIL.NEXTVAL,#{from_email},#{to_email},#{s_date},#{s_time},#{s_subject},#{s_content},#{s_file1},#{s_file2}) ";
	
	public static final String UPDATE
	= " UPDATE tbl_email SET from_email=#{from_email}, "
						+ " to_email=#{to_email}, "
						+ " s_date=#{s_date}, "
						+ " s_time=#{s_time}, "
						+ " s_subject=#{s_subject}, "
						+ " s_content=#{s_content} "
						+ " s_file1=#{s_file1} "
						+ " s_file2=#{s_file2} "
						+ " WHERE id = #{id} ";
	
	public static final String DELETE = " DELETE FROM tbl_email WHERE id = #{id} ";
}
