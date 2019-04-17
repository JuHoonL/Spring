package com.biz.memo06.model;

public class MemoVO {

	private long id;
	private String subject;
	private String date;
	private String memo;
	
	public MemoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemoVO(long id, String subject, String date, String memo) {
		super();
		this.id = id;
		this.subject = subject;
		this.date = date;
		this.memo = memo;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSubject() {
		return subject;
	}
	public String getDate() {
		return date;
	}
	public String getMemo() {
		return memo;
	}
	
	@Override
	public String toString() {
		return "MemoVO [id=" + id + ", subject=" + subject + ", date=" + date + ", memo=" + memo + "]";
	}
	
}
