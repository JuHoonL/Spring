package com.biz.file.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	
	private String m_userid;
	private String m_password;
	private String m_re_password;
	private String m_name;
	private String m_addr;
	private String m_tel;
}
