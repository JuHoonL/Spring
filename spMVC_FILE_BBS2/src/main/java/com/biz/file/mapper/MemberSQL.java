package com.biz.file.mapper;

import org.apache.ibatis.jdbc.SQL;

public class MemberSQL {
	/*
	 * Dynamic SQL
	 */
	public String member_insert_sql() {
		/*
		 * VALUES항목에 jdbcType=nVARCHAR2는 혹시 form에서 데이터를 입력하지 않더라도
		 * insert를 수행할 때 sQL Exception을 내지 말라 (단, PK와 NOTNULL의 경우 X)
		 */
		SQL sql = new SQL()
				.INSERT_INTO("tbl_member")
				.INTO_COLUMNS("m_userid").INTO_VALUES("#{m_userid}")
				.INTO_COLUMNS("m_password").INTO_VALUES("#{m_password}")
				.INTO_COLUMNS("m_name").INTO_VALUES("#{m_name,jdbcType=VARCHAR}")
				.INTO_COLUMNS("m_addr").INTO_VALUES("#{m_addr,jdbcType=VARCHAR}")
				.INTO_COLUMNS("m_tel").INTO_VALUES("#{m_tel,jdbcType=VARCHAR}");
		
		return sql.toString();
	}
	
	public String member_update_sql() {
		SQL sql = new SQL()
				.UPDATE("tbl_member")
				.SET("m_password = #{m_password}")
				.SET("m_name = #{m_name}")
				.SET("m_addr = #{m_addr}")
				.SET("m_tel = #{m_tel}")
				.WHERE("m_userid = #{m_userid}");
		
		return sql.toString();
	}
}
