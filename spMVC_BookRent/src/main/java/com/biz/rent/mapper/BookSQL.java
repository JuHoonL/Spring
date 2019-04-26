package com.biz.rent.mapper;

import org.apache.ibatis.jdbc.SQL;

public class BookSQL {

	public String book_insert_sql() {
		SQL sql = new SQL().INSERT_INTO("tbl_book")
				.VALUES("book_seq", "SEQ_BOOK.NEXTVAL")
				.VALUES("book_isbn", "#{book_isbn,jdbcType=VARCHAR}")
				.VALUES("book_title", "#{book_title,jdbcType=VARCHAR}")
				.VALUES("book_author", "#{book_author,jdbcType=VARCHAR}")
				.VALUES("book_price", "#{book_price,jdbcType=INTEGER}")
				.VALUES("book_description", "#{book_description,jdbcType=VARCHAR}")
				.VALUES("book_image", "#{book_image,jdbcType=VARCHAR}")
				.VALUES("book_link", "#{book_link,jdbcType=VARCHAR}")
				.VALUES("book_rent_yn", "#{book_rent_yn,jdbcType=VARCHAR}");
		
		return sql.toString();
	}
	
	public String book_update_sql() {
		SQL sql = new SQL().UPDATE("tbl_book")
				.SET("book_isbn=#{book_isbn,jdbcType=VARCHAR}")
				.SET("book_title=#{book_title,jdbcType=VARCHAR}")
				.SET("book_author=#{book_author,jdbcType=VARCHAR}")
				.SET("book_price=#{book_price,jdbcType=INTEGER}")
				.SET("book_description=#{book_description,jdbcType=VARCHAR}")
				.SET("book_image=#{book_image,jdbcType=VARCHAR}")
				.SET("book_link=#{book_link,jdbcType=VARCHAR}")
				.SET("book_rent_yn=#{book_rent_yn,jdbcType=VARCHAR}")
				.WHERE("book_seq=#{book_seq,jdbcType=INTEGER}");
		
		return sql.toString();
	}
}
