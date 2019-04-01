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
public class PageService2 {

	@Autowired
	PageDao pdao;
	
	public long getCount() {
		
		return pdao.getCount();
	}
	
	public List<BoardVO> pageList(long sROW, long eROW) {
		
		long c = pdao.getCount();
//		long sROW = pageVO.getCurrentPageNo();
//		long eROW = pageVO.getCurrentPageNo()+pageVO.getListPerPage();
		
		log.debug("COUNT NO : " + c);
		log.debug("sROW NO : " + sROW);
		log.debug("eROW NO : " + eROW);
		
		List<BoardVO> bbsList = pdao.pageList(sROW, eROW);
		
		return bbsList;
	}
	
	public List<BoardVO> pageList(PageVO pageVO) {
	
		long c = pdao.getCount();
		
		long sROW = pageVO.getStartUpPageNo();
		if(pageVO.getCurrentPageNo() == 1) {
			sROW = 1;
		}
		
		long eROW = pageVO.getEndPageNo();
		
		log.debug("COUNT NO : " + c);
		log.debug("sROW NO : " + sROW);
		log.debug("eROW NO : " + eROW);
		
		List<BoardVO> bbsList = pdao.pageList(sROW, eROW);
		
		return bbsList;
	}
	
	public PageVO page_select(long page_no) {
		
		//리스트의 총 데이터 개수
		long totalCount = pdao.getCount();
		if(totalCount == 0) return null;
		
		if(page_no == 0) page_no = 1;
		
		//한페이지 안에 보여 질 개수
		long ListPerPage = 10;
		
		//총 페이지수 계산 ( +1 한 이유 : 데이터 개수가 정확히 떨어지지 않을 경우 끝에 한페이지(for 남은데이터)를 추가하기 위해)
		long totalPage = (long)(totalCount / ListPerPage) + 1;
		long currPage = page_no;
		
		PageVO pageVO = new PageVO();
		pageVO.setTotalCount(totalCount);
		pageVO.setListPerPage(ListPerPage);
		pageVO.setCurrentPageNo(currPage);
		pageVO.setFinalPageNo(totalPage);
		
		long finalPage = (totalCount + (ListPerPage - 1)) / ListPerPage;
		
		finalPage = pageVO.getFinalPageNo();
		
		boolean isNowFirst = (currPage == 1) ? true:false;
		
		boolean isNowFinal = (currPage == finalPage) ? true:false;
		
		long startPage = ((currPage - 1) / ListPerPage) * ListPerPage * ListPerPage +1;
		
		long endPage = startPage + ListPerPage -1;
		
		if(endPage > finalPage) {
			endPage = finalPage;
		}
		
		pageVO.setFirstPageNo(1);
		if(isNowFirst) pageVO.setPrePageNo(1);
		else pageVO.setPrePageNo((currPage - 1) < 1 ? 1:(currPage-1));
		
		pageVO.setStartUpPageNo(startPage);
		pageVO.setEndPageNo(endPage);
		
		if(isNowFinal) pageVO.setNextPageNo(finalPage);
		else pageVO.setNextPageNo((currPage + 1) > finalPage ? finalPage:(currPage+1));
		
		pageVO.setFinalPageNo(finalPage);
		
		return pageVO;
	}
}
