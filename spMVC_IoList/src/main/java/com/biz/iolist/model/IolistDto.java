package com.biz.iolist.model;

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
public class IolistDto {

	private int io_id;
	private String io_date;
	private String io_time;
	private String io_pcode;
	private String io_dcode;
	private String io_inout;
	private String io_tax;
	private int io_quan;
	private int io_price;
	private int io_total;
	private int io_tax_total;
	
	private String p_code;
	private String p_name;
	private String p_tax ;
	private int p_iprice;
	private int p_oprice;
	
	private String d_code;
	private String d_name;
	private String d_ceo;
	private String d_tel;
	private String d_addr;
}
