package com.biz.menu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 데이터를 담아서 이동시킬 때 사용할 클래스들
 * 		vo class
 * 		dto class
 * 
 * model class
 * command class
 * vo class
 */

@Builder		// Builder패턴은 7버전 이상부터 사용가능(데이터추가시 편리함추구)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {

	private String menu_id;
	private String menu_title;
	private String menu_href;
}
