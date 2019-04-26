package com.biz.rent.model;

public class RentVO {

	private long rent_seq;					// 대여 일련번호
	private String rent_date;				// 도서 대출일
	private String rent_return_date;		// 도서 반납 예정일
	private long book_seq;
	private String book_isbn;					// 도서 일련번호(BookVO 참조)
	private long user_seq;					// 회원 일련번호(JUserVO 참조)
	private String rent_return_yn;			// 도서반납 여부(Y:반납, N:미반납)
	
	public RentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RentVO(long rent_seq, String rent_date, String rent_return_date, long book_seq, String book_isbn,
			long user_seq, String rent_return_yn) {
		super();
		this.rent_seq = rent_seq;
		this.rent_date = rent_date;
		this.rent_return_date = rent_return_date;
		this.book_seq = book_seq;
		this.book_isbn = book_isbn;
		this.user_seq = user_seq;
		this.rent_return_yn = rent_return_yn;
	}

	public long getRent_seq() {
		return rent_seq;
	}

	public void setRent_seq(long rent_seq) {
		this.rent_seq = rent_seq;
	}

	public String getRent_date() {
		return rent_date;
	}

	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}

	public String getRent_return_date() {
		return rent_return_date;
	}

	public void setRent_return_date(String rent_return_date) {
		this.rent_return_date = rent_return_date;
	}

	public long getBook_seq() {
		return book_seq;
	}

	public void setBook_seq(long book_seq) {
		this.book_seq = book_seq;
	}

	public String getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}

	public long getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(long user_seq) {
		this.user_seq = user_seq;
	}

	public String getRent_return_yn() {
		return rent_return_yn;
	}

	public void setRent_return_yn(String rent_return_yn) {
		this.rent_return_yn = rent_return_yn;
	}

	@Override
	public String toString() {
		return "RentVO [rent_seq=" + rent_seq + ", rent_date=" + rent_date + ", rent_return_date=" + rent_return_date
				+ ", book_seq=" + book_seq + ", book_isbn=" + book_isbn + ", user_seq=" + user_seq + ", rent_return_yn="
				+ rent_return_yn + "]";
	}
	
}
