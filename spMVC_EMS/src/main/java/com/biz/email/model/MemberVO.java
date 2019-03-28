package com.biz.email.model;

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
	
	private long m_id;
	private String m_userid;
	private String m_password;
	private String m_mailaddress;
	private String m_username;
	private String m_addr;
	private String m_tel;
}
