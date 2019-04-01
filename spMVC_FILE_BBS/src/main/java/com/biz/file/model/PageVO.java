package com.biz.file.model;

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
public class PageVO {

	long listPerPage; // 페이지당 리스트 개수	
	
	long firstPageNo; // 첫번째 페이지번호
	
	long prePageNo; // 이전페이지번호
	
	long startUpPageNo; // 시작페이지번호
	
	long currentPageNo;
	
	long endPageNo;	//끝페이지번호
	
	long nextPageNo; // 다음페이지번호
	
	long finalPageNo; 
	
	long totalCount; // 전체리스트 개수
	
	long pageCount; // 페이지의 총 개수
	
	public PageVO(long currentPage, long listPerPage) {
		this.currentPageNo = currentPage;
		this.pageCount = 10;
		this.listPerPage = (listPerPage !=0) ? listPerPage : this.pageCount;
	}
}
