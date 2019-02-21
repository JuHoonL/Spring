package com.biz.ajax01.mapper;

// 2015년 이후 mybatis에서 사용가능한 클래스(실무사용은 아직..)
import org.apache.ibatis.jdbc.SQL;

public class DeptSQLBuilder {

	public String getSelectSQL() {
		
		SQL sql = new SQL().SELECT("*").FROM("tbl_dept");
		
		return sql.toString();
	}
	
	public String getInsertSQL() {
		
		//SQLBuilder(Mybatis 3.대 버전에서 새로 도입된 SQL문 작성기 초기버전)
		//1.7버전이하에서 컴파일 오류가능성 잇음
		SQL sql = new SQL();
			
			sql.INSERT_INTO("tbl_dept");
			sql.INTO_COLUMNS("d_code");
			sql.INTO_VALUES("#{d_code}");
			sql.VALUES("d_name", "#{d_name}");
			sql.VALUES("d_ceo", "#{d_ceo}");
		
		return sql.toString();
	}
	
	public String getUpdateSQL() {
		
		//SQLBuilder(Mybatis 3.대 버전에서 새로 도입된 SQL문 작성기 초기버전)
		//1.7버전이하에서 컴파일 오류가능성 잇음
		SQL sql = new SQL().UPDATE("tbl_dept").SET("d_code = #{d_code}").SET("d_name = #{d_name}")
				.SET("d_ceo = #{d_ceo}").WHERE("d_code = #{d_code}");
		
		return sql.toString();
	}
	
	public String getDelete() {
		
		SQL sql = new SQL()
				.DELETE_FROM("tbl_dept").WHERE("d_code = #{d_code}");
		
		return sql.toString();
	}

	
}
