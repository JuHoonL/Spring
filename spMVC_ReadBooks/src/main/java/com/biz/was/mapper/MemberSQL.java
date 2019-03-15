package com.biz.was.mapper;

import org.apache.ibatis.jdbc.SQL;

public class MemberSQL {
	/*
	 * Dynamic SQL
	 */
	public String member_insert_sql() {
		SQL sql = new SQL()
				.INSERT_INTO("tbl_b_user")
				.INTO_COLUMNS("m_id").INTO_VALUES("SEQ_B_USER.NEXTVAL")
				.INTO_COLUMNS("m_userid").INTO_VALUES("#{m_userid}")
				.INTO_COLUMNS("m_password").INTO_VALUES("#{m_password}")
				.VALUES("m_username","#{m_username}")
				.VALUES("m_tel","#{m_tel}")
				.VALUES("m_addr","#{m_addr}");
		
		return sql.toString();
	}
}
