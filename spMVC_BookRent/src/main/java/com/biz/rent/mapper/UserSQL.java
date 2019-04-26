package com.biz.rent.mapper;

import org.apache.ibatis.jdbc.SQL;

public class UserSQL {

	public String user_insert_sql() {
		SQL sql = new SQL().INSERT_INTO("tbl_juser")
				.VALUES("user_seq", "SEQ_JUSER.NEXTVAL")
				.VALUES("user_name", "#{user_name,jdbcType=VARCHAR}")
				.VALUES("user_birth", "#{user_birth,jdbcType=VARCHAR}")
				.VALUES("user_sex", "#{user_sex,jdbcType=VARCHAR}")
				.VALUES("user_phone", "#{user_phone,jdbcType=VARCHAR}")
				.VALUES("user_mail", "#{user_mail,jdbcType=VARCHAR}")
				.VALUES("user_image", "#{user_image,jdbcType=VARCHAR}")
				.VALUES("user_reg_date", "#{user_reg_date,jdbcType=VARCHAR}")
				.VALUES("user_out_date", "#{user_out_date,jdbcType=VARCHAR}")
				.VALUES("user_out_yn", "#{user_out_yn,jdbcType=VARCHAR}")
				.VALUES("user_rent_count", "#{user_rent_count,jdbcType=INTEGER}")
				.VALUES("user_rent_total", "#{user_rent_total,jdbcType=INTEGER}");
		
		return sql.toString();
	}
	
	public String user_update_sql() {
		SQL sql = new SQL().UPDATE("tbl_juser")
				.SET("user_name=#{user_name,jdbcType=VARCHAR}")
				.SET("user_birth=#{user_birth,jdbcType=VARCHAR}")
				.SET("user_sex=#{user_sex,jdbcType=VARCHAR}")
				.SET("user_phone=#{user_phone,jdbcType=VARCHAR}")
				.SET("user_mail=#{user_mail,jdbcType=VARCHAR}")
				.SET("user_image=#{user_image,jdbcType=VARCHAR}")
				.SET("user_reg_date=#{user_reg_date,jdbcType=VARCHAR}")
				.SET("user_out_date=#{user_out_date,jdbcType=VARCHAR}")
				.SET("user_out_yn=#{user_out_yn,jdbcType=VARCHAR}")
				.SET("user_rent_count=#{user_rent_count,jdbcType=INTEGER}")
				.SET("user_rent_total=#{user_rent_total,jdbcType=INTEGER}")
				.WHERE("user_seq=#{user_seq,jdbcType=INTEGER}");
		
		return sql.toString();
	}
}
