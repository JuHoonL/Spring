package com.biz.file.mapper;

import org.apache.ibatis.jdbc.SQL;

public class BoardSQL {
	
	public String board_insert_sql() {
		SQL sql = new SQL().INSERT_INTO("tbl_board")
				.VALUES("id","#{id}")
				.VALUES("b_userid","#{b_userid}")
				.VALUES("b_date","#{b_date}")
				.VALUES("b_time","#{b_time}")
				.VALUES("b_subject","#{b_subject}")
				.VALUES("b_content","#{b_content}")
				.VALUES("b_hit","#{b_hit}")
				.VALUES("b_image","#{b_image}");
		
		return sql.toString();
				
	}
	
	public String board_update_sql() {
		SQL sql = new SQL().UPDATE("tbl_board")
				.SET("b_userid=#{b_userid}")
				.SET("b_date=#{b_date}")
				.SET("b_time=#{b_time}")
				.SET("b_subject=#{b_subject}")
				.SET("b_content=#{b_content}")
				.SET("b_hit=#{b_hit}")
				.SET("b_image=#{b_image}")
				.WHERE("id=#{id}");
		
		return sql.toString();
	}
}
