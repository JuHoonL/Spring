package com.biz.rent.model;

public class JUserVO {

	private long user_seq;				// 일련번호
	private String user_name;			// 이름
	private String user_birth;			// 생년월이
	private String user_sex;			// 성별(M, F)
	private String user_phone;			// 연락처
	private String user_mail;			// 메일주소
	private String user_image;			// 사진링크
	private String user_reg_date;		// 등록일
	private String user_out_date;		// 탈퇴일
	private String user_out_yn;				// 탈퇴여부(Y, N)
	private long user_rent_count;		// 대여 도서권수
	private long user_rent_total;		// 총 대여금액 합계
	
	public JUserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JUserVO(long user_seq, String user_name, String user_birth, String user_sex, String user_phone,
			String user_mail, String user_image, String user_reg_date, String user_out_date, String user_out_yn,
			long user_rent_count, long user_rent_total) {
		super();
		this.user_seq = user_seq;
		this.user_name = user_name;
		this.user_birth = user_birth;
		this.user_sex = user_sex;
		this.user_phone = user_phone;
		this.user_mail = user_mail;
		this.user_image = user_image;
		this.user_reg_date = user_reg_date;
		this.user_out_date = user_out_date;
		this.user_out_yn = user_out_yn;
		this.user_rent_count = user_rent_count;
		this.user_rent_total = user_rent_total;
	}

	public long getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(long user_seq) {
		this.user_seq = user_seq;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public String getUser_reg_date() {
		return user_reg_date;
	}

	public void setUser_reg_date(String user_reg_date) {
		this.user_reg_date = user_reg_date;
	}

	public String getUser_out_date() {
		return user_out_date;
	}

	public void setUser_out_date(String user_out_date) {
		this.user_out_date = user_out_date;
	}

	public String getUser_out_yn() {
		return user_out_yn;
	}

	public void setUser_out_yn(String user_out_yn) {
		this.user_out_yn = user_out_yn;
	}

	public long getUser_rent_count() {
		return user_rent_count;
	}

	public void setUser_rent_count(long user_rent_count) {
		this.user_rent_count = user_rent_count;
	}

	public long getUser_rent_total() {
		return user_rent_total;
	}

	public void setUser_rent_total(long user_rent_total) {
		this.user_rent_total = user_rent_total;
	}

	@Override
	public String toString() {
		return "JUserVO [user_seq=" + user_seq + ", user_name=" + user_name + ", user_birth=" + user_birth
				+ ", user_sex=" + user_sex + ", user_phone=" + user_phone + ", user_mail=" + user_mail + ", user_image="
				+ user_image + ", user_reg_date=" + user_reg_date + ", user_out_date=" + user_out_date + ", user_out_yn="
				+ user_out_yn + ", user_rent_count=" + user_rent_count + ", user_rent_total=" + user_rent_total + "]";
	}
}
