package com.biz.health01.vo;

public class UserVO {

	private String id;
	private String userName;
	private String password;
	private String height;
	private String weight;
	private String activityindex;
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(String userName, String password, String height, String weight, String activityindex) {
		super();
		this.userName = userName;
		this.password = password;
		this.height = height;
		this.weight = weight;
		this.activityindex = activityindex;
	}
	
	public UserVO(String id, String userName, String password, String height, String weight, String activityindex) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.height = height;
		this.weight = weight;
		this.activityindex = activityindex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getActivityindex() {
		return activityindex;
	}

	public void setActivityindex(String activityindex) {
		this.activityindex = activityindex;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userName=" + userName + ", password=" + password + ", height=" + height
				+ ", weight=" + weight + ", activityindex=" + activityindex + "]";
	}
}
