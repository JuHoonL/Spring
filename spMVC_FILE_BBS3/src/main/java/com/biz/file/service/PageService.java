package com.biz.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.file.mapper.PageDao;
import com.biz.file.model.BoardVO;
import com.biz.file.model.PageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PageService {

	@Autowired
	PageDao pdao;
	
	public long getCount() {
		
		return pdao.getCount();
	}
	
	public List<BoardVO> pageList(long sROW, long eROW) {
		
		long c = pdao.getCount();
		
		log.debug("COUNT NO : " + c);
		log.debug("sROW NO : " + sROW);
		log.debug("eROW NO : " + eROW);
		
		List<BoardVO> bbsList = pdao.pageList(sROW, eROW);
		
		return bbsList;
	}
	
	public List<BoardVO> pageList(PageVO pageVO){

		long c = pdao.getCount();
		long sRow 
			= pageVO.getCurrentPageNo() 
				* pageVO.getListPerPage();
		
		long eRow = sRow + pageVO.getListPerPage() - 1;
		
		log.debug("COUNT" + c);
		
		log.debug("sRow" + sRow);
		log.debug("eRow" + eRow);
		
		List<BoardVO> bbsList = pdao.pageList(sRow, eRow);
		return bbsList;
		
	}
	
	public PageVO page_select(long page_no) {
		
		long totalCount = pdao.getCount();	// 전체 데이터의 개수
		
		if(totalCount == 0) return null;
		if(page_no == 0) page_no = 1 ;
		
		long listPerPage = 10;		// 한페이지에 보여질 리스트 개수
		long totalPage = (long)(totalCount / listPerPage);
		long currPage = page_no ; 	// listPerPage * page_no;
		
		PageVO pageVO = new PageVO();
		pageVO.setTotalCount(totalCount);
		pageVO.setListPerPage(listPerPage);
		pageVO.setCurrentPageNo(currPage);
		pageVO.setEndPageNo(totalPage);
		
		long finalPage 
		= (totalCount + (listPerPage -1)) / listPerPage; 
		
		boolean isNowFirst 
			= currPage == 1 ? true: false;
		
		boolean isNowFinal 
			= currPage == finalPage ? true : false;
		
		long startPage 
			= ((currPage - 1) / listPerPage) * listPerPage + 1;
		
		long endPage = startPage + listPerPage - 1;
		
		if(endPage > finalPage) endPage = finalPage;
		
		pageVO.setFirstPageNo(1);
		if(isNowFirst) pageVO.setPrePageNo(1);
		else pageVO.setPrePageNo((currPage -1) < 1 ? 1 : currPage - 1);
		
		pageVO.setStartUpPageNo(startPage);
		pageVO.setEndPageNo(endPage);
		
		if(isNowFinal) pageVO.setNextPageNo(finalPage);
		else pageVO.setNextPageNo(((currPage + 1) > finalPage ? finalPage : (currPage + 1)));

		pageVO.setFinalPageNo(finalPage);
		
		return pageVO;
	}
}
