package com.biz.health01.vo;

public class KcalVO {
	

	private long id;
	private String cate;
	private String cate_code;
	private String foodName;
	private String oneofsupply;
	private String foodkcal;
	
	public KcalVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KcalVO(String cate, String cate_code, String foodName, String oneofsupply, String foodkcal) {
		super();
		this.cate = cate;
		this.cate_code = cate_code;
		this.foodName = foodName;
		this.oneofsupply = oneofsupply;
		this.foodkcal = foodkcal;
	}
	

	public KcalVO(long id, String cate, String cate_code, String foodName, String oneofsupply, String foodkcal) {
		super();
		this.id = id;
		this.cate = cate;
		this.cate_code = cate_code;
		this.foodName = foodName;
		this.oneofsupply = oneofsupply;
		this.foodkcal = foodkcal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getCate_code() {
		return cate_code;
	}

	public void setCate_code(String cate_code) {
		this.cate_code = cate_code;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getOneofsupply() {
		return oneofsupply;
	}

	public void setOneofsupply(String oneofsupply) {
		this.oneofsupply = oneofsupply;
	}

	public String getfoodkcal() {
		return foodkcal;
	}

	public void setfoodkcal(String foodkcal) {
		this.foodkcal = foodkcal;
	}

	@Override
	public String toString() {
		return "KcalVO [id=" + id + ", cate=" + cate + ", cate_code=" + cate_code + ", foodName=" + foodName
				+ ", oneofsupply=" + oneofsupply + ", foodkcal=" + foodkcal + "]";
	}
	
}
