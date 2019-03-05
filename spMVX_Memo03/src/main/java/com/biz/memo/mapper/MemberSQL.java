package com.biz.memo.mapper;

import org.apache.ibatis.jdbc.SQL;

public class MemberSQL {
	/*
	 * Dynamic SQL
	 */
	public String memo_insert_sql() {
		SQL sql = new SQL()
				.INSERT_INTO("tbl_member")
				.INTO_COLUMNS("m_userid").INTO_VALUES("#{m_user_id}")
				.INTO_COLUMNS("m_password").INTO_VALUES("#{m_password}")
				.INTO_COLUMNS("m_name,m_tel").INTO_VALUES("#{m_name},#{m_tel}");
		
		return sql.toString();
	}
}
