package com.biz.health01.model;

public class health_Sql {

	public static final String USER_SELECTALL 
	= " SELECT * FROM tbl_user ";
	
	public static final String USER_FINDBYID
	= " SELECT * FROM tbl_user WHERE id = #{id} ";
	
	public static final String USER_FINDBYNAME
	= " SELECT * FROM tbl_user WHERE userName = #{userName} ";
	
	public static final String USER_INSERT
	= " INSERT INTO tbl_user(id, userName, password, birth, height, weight, activityindex) "
			+ " VALUES(#{id}, #{userName}, #{password}, #{birth}, #{height}, #{weight}, #{activityindex}) ";
	
	public static final String USER_UPDATE
	= " UPDATE tbl_user SET userName=#{userName}, password=#{password}, "
			+ " birth=#{birth}, height=#{height}, weight=#{weight}, activityindex=#{activityindex} "
			+ " WHERE id = #{id} ";
	
	public static final String USER_DELETE
	= " DELETE FROM tbl_user WHERE id = #{id} ";
}
