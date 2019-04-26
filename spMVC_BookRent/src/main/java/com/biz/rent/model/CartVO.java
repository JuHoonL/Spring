package com.biz.rent.model;

public class CartVO {

	private long cart_seq;					// 대여 일련번호
	private String cart_date;				// 도서 대출일
	private String cart_return_date;		// 도서 반납 예정일
	private long book_seq;					// 도서 일련번호(BookVO 참조)
	private String book_title;				// 도서명
	private long book_price;				// 대여금액
	private long user_seq;					// 회원 일련번호(JUserVO 참조)
	private String user_name;				// 회원이름
	private String cart_return_yn;			// 도서반납 여부(Y:반납, N:미반납)
	
	
	public CartVO(long cart_seq, String cart_date, String cart_return_date, long book_seq, String book_title,
			long book_price, long user_seq, String user_name, String cart_return_yn) {
		super();
		this.cart_seq = cart_seq;
		this.cart_date = cart_date;
		this.cart_return_date = cart_return_date;
		this.book_seq = book_seq;
		this.book_title = book_title;
		this.book_price = book_price;
		this.user_seq = user_seq;
		this.user_name = user_name;
		this.cart_return_yn = cart_return_yn;
	}
	
	public CartVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCart_seq() {
		return cart_seq;
	}

	public void setCart_seq(long cart_seq) {
		this.cart_seq = cart_seq;
	}

	public String getCart_date() {
		return cart_date;
	}

	public void setCart_date(String cart_date) {
		this.cart_date = cart_date;
	}

	public String getCart_return_date() {
		return cart_return_date;
	}

	public void setCart_return_date(String cart_return_date) {
		this.cart_return_date = cart_return_date;
	}

	public long getBook_seq() {
		return book_seq;
	}

	public void setBook_seq(long book_seq) {
		this.book_seq = book_seq;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public long getBook_price() {
		return book_price;
	}

	public void setBook_price(long book_price) {
		this.book_price = book_price;
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

	public String getCart_return_yn() {
		return cart_return_yn;
	}

	public void setCart_return_yn(String cart_return_yn) {
		this.cart_return_yn = cart_return_yn;
	}

	@Override
	public String toString() {
		return "CartVO [cart_seq=" + cart_seq + ", cart_date=" + cart_date + ", cart_return_date=" + cart_return_date
				+ ", book_seq=" + book_seq + ", book_title=" + book_title + ", book_price=" + book_price + ", user_seq="
				+ user_seq + ", user_name=" + user_name + ", cart_return_yn=" + cart_return_yn + "]";
	}
	
}
