package com.biz.health01.vo;

public class KcalVO {
	
	private long id;
	private String foodName;
	private int oneofsupply;
	private int Kcal;
	
	public KcalVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KcalVO(String foodName, int oneofsupply, int kcal) {
		super();
		this.foodName = foodName;
		this.oneofsupply = oneofsupply;
		Kcal = kcal;
	}
	

	public KcalVO(long id, String foodName, int oneofsupply, int kcal) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.oneofsupply = oneofsupply;
		Kcal = kcal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getOneofsupply() {
		return oneofsupply;
	}
	public void setOneofsupply(int oneofsupply) {
		this.oneofsupply = oneofsupply;
	}
	public int getKcal() {
		return Kcal;
	}
	public void setKcal(int kcal) {
		Kcal = kcal;
	}
	@Override
	public String toString() {
		return "KcalVO [foodName=" + foodName + ", oneofsupply=" + oneofsupply + ", Kcal=" + Kcal + "]";
	}
	
}
