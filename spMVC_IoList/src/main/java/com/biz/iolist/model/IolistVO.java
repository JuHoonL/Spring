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
public class IolistVO {

	private int io_id;
	private String io_date;
	private String io_time;
	private String io_pcode;
	private String io_dcode;
	private String io_inout;
	private String io_tax;
	private int io_quan;
	private int io_price;
	// 공급가액 : 상품수량 * 공급단가
	private int io_total;
	//공급대가 : 과세일경우(공급가액 + 공급가액의 10%)
	//			 면세일경우(공급가액)
	private int io_tax_total;

}
