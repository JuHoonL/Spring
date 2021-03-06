package com.biz.simple.vo;

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
public class InoutVO {

	/*
	 * date       time     cname      c p   s
	 * 2018-01-02:00:07:31:그린타임캔:2:700:87
	 * 0           1  2  3  4         5 6   7
 	 */
	
	private String io_date;
	private String io_time;
	private String io_cname;
	private String io_check;
	private int io_price;
	private int io_su;
}
