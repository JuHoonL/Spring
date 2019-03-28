package com.biz.file.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private long id;
    private String b_userid;
    private String b_date;
    private String b_time;
    private String b_subject;
    private String b_content;
    private String b_image;
    private long b_hit;
}
