package com.biz.bbs.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BBSCommentDto {

	private long id;
	private String b_auth;
	private String b_date;
	private String b_time;
	private String b_subject;
	private String b_text;
	
	private List<CommentVO> commentList;
}
