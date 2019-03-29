package com.biz.email.mapper;

public class EmailSQL {

	public static final String SELECTAll = " SELECT * FROM tbl_email ORDER BY id ";
	
	public static final String FINDBYID = " SELECT * FROM tbl_email WHERE id = #{id} ";
	
	public static final String FINDBYFROMUSERID = " SELECT * FROM tbl_email WHERE from_email = #{from_email} ORDER BY id ";
	
	public static final String FINDBYTOUSERID = " SELECT * FROM tbl_email WHERE to_email = #{to_email} ORDER BY id ";
	
	public static final String INSERT
	= " INSERT INTO tbl_email VALUES (SEQ_EMAIL.NEXTVAL,#{from_email},#{to_email},#{s_date},#{s_time},#{s_subject,jdbcType=VARCHAR},#{s_content,jdbcType=VARCHAR},#{s_file1,jdbcType=VARCHAR},#{s_file2,jdbcType=VARCHAR}) ";
	
	public static final String UPDATE
	= " UPDATE tbl_email SET from_email=#{from_email}, "
						+ " to_email=#{to_email}, "
						+ " s_date=#{s_date}, "
						+ " s_time=#{s_time}, "
						+ " s_subject=#{s_subject,jdbcType=VARCHAR}, "
						+ " s_content=#{s_content,jdbcType=VARCHAR}, "
						+ " s_file1=#{s_file1,jdbcType=VARCHAR}, "
						+ " s_file2=#{s_file2,jdbcType=VARCHAR} "
						+ " WHERE id = #{id} ";
	
	public static final String DELETE = " DELETE FROM tbl_email WHERE id = #{id} ";
}
