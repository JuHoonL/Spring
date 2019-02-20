package com.biz.ajax.vo;

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
public class ProductVO {
	
	private String p_ccode;
	private String p_cname;
	private String p_vat;
	private String p_iprice;
	private String p_oprice;
	
}
