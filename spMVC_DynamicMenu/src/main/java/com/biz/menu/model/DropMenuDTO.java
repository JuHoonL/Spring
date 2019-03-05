package com.biz.menu.model;

import java.util.List;

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
public class DropMenuDTO {

	private String menu_id;
	private String menu_p_id; //parents ID
	private String menu_title;
	private String menu_href;
	
	List<DropMenuDTO> sub_menus;
}
