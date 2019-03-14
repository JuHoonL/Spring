package com.biz.memo03.mapper;

import org.apache.ibatis.jdbc.SQL;

public class MemberSQL {
	/*
	 * Dynamic SQL
	 */
	public String member_insert_sql() {
		SQL sql = new SQL()
				.INSERT_INTO("tbl_member")
				.INTO_COLUMNS("m_userid").INTO_VALUES("#{m_userid}")
				.INTO_COLUMNS("m_password").INTO_VALUES("#{m_password}")
				.VALUES("m_name","#{m_name}")
				.VALUES("m_tel","#{m_tel}")
				.VALUES("m_addr","#{m_addr}");
		
		return sql.toString();
	}
}
