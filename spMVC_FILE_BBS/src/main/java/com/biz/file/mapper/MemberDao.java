package com.biz.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.annotations.*;

import com.biz.file.model.MemberVO;

public interface MemberDao {

	@Select(" SELECT * FROM tbl_member ")
	public List<MemberVO> selectAll();
	
	@Select(" SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ")
	public MemberVO findByUserid(String m_userid);
	
	@InsertProvider(type=MemberSQL.class, method="member_insert_sql")
	public int insert(MemberVO membervo);
	
	@UpdateProvider(type=MemberSQL.class, method="member_update_sql")
	public int update(MemberVO membervo);
	
	@Delete(" DELETE FROM tbl_member WHERE m_userid = #{m_userid} ")
	public int delete(String m_userid);
}

class MemberSQL01 {
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
				.INTO_COLUMNS("m_name").INTO_VALUES("#{m_name,jdbcType=nVARCHAR2}")
				.INTO_COLUMNS("m_addr").INTO_VALUES("#{m_addr,jdbcType=nVARCHAR2}")
				.INTO_COLUMNS("m_tel").INTO_VALUES("#{m_tel,jdbcType=nVARCHAR2}");
		
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
