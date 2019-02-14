package com.biz.health01.vo;

public class UserVO {

	private long id;
	private String userId;
	private String userName;
	private String password;
	private String birth;
	private String height;
	private String weight;
	private String activityindex;
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(long id, String userId, String userName, String password, String birth, String height, String weight,
			String activityindex) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.birth = birth;
		this.height = height;
		this.weight = weight;
		this.activityindex = activityindex;
	}
	
	public UserVO(String userId, String userName, String password, String birth, String height, String weight,
			String activityindex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.birth = birth;
		this.height = height;
		this.weight = weight;
		this.activityindex = activityindex;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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
		return "UserVO [id=" + id + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", birth=" + birth + ", height=" + height + ", weight=" + weight + ", activityindex=" + activityindex
				+ "]";
	}
	
}
	
	