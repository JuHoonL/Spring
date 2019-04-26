package com.biz.rent.mapper;

import org.apache.ibatis.jdbc.SQL;

public class RentSQL {

	public String rent_insert_sql() {
		SQL sql = new SQL().INSERT_INTO("tbl_rent")
				.VALUES("rent_seq", "SEQ_RENT.NEXTVAL")
				.VALUES("rent_date", "#{rent_date,jdbcType=VARCHAR}")
				.VALUES("book_seq", "#{book_seq,jdbcType=VARCHAR}")
				.VALUES("user_seq", "#{user_seq,jdbcType=VARCHAR}")
				.VALUES("rent_return_date", "#{rent_return_date,jdbcType=VARCHAR}")
				.VALUES("rent_return_yn", "#{rent_return_yn,jdbcType=VARCHAR}");
		
		return sql.toString();
	}
	
	public String rent_update_sql() {
		SQL sql = new SQL().UPDATE("tbl_rent")
				.SET("rent_date=#{rent_date,jdbcType=VARCHAR}")
				.SET("rent_return_date=#{rent_return_date,jdbcType=VARCHAR}")
				.SET("book_seq=#{book_seq,jdbcType=VARCHAR}")
				.SET("user_seq=#{user_seq,jdbcType=VARCHAR}")
				.SET("rent_return_yn=#{rent_return_yn,jdbcType=INTEGER}")
				.WHERE("rent_seq=#{rent_seq,jdbcType=INTEGER}");
		
		return sql.toString();
	}
}
