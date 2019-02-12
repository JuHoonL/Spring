package com.biz.memo02.model;

public class MemberSQL {

	public static final String MEMBER_USERCHECK
	= " SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ";
	
	public static final String MEMBER_INSERT
	= " INSERT INTO tbl_member(id,m_userid,m_password,m_name,m_tel,m_city,m_addr) "
	+ " VALUES(MEMBER_SEQUENCE.NEXTVAL, #{m_userid},  #{m_password}, #{m_name}, #{m_tel}, #{m_city}, #{m_addr}) ";
	
	public static final String MEMBER_UPDATE
	= " UPDATE tbl_member SET "
			+ " m_userid=#{m_userid}, "
			+ " m_password=#{m_password}, "
			+ " m_name=#{m_name}, "
			+ " m_tel=#{m_tel}, "
			+ " m_city=#{m_city}, "
			+ " m_addr=#{m_addr} "
			+ " WHERE id=#{id} ";
	
	public static final String MEMBER_DELETE
	= " DELETE FROM tbl_member WHERE id= #{id} ";
}
