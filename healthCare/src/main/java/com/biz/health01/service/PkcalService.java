package com.biz.health01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.health01.vo.KcalVO;
import com.biz.health01.vo.UserVO;

@Service
public class PkcalService {
	//	List<KcalVO>에는 user가 먹은거 선택한 그 목록 리스트
	public void viewList(List<KcalVO> kList) {
		for(KcalVO vo : kList) {
			System.out.println(vo);
		}
	}

	// user가 고른 음식 총 칼로리
	public int totalKcal(List<KcalVO> kList) {
		int SumKcal = 0;
		for(KcalVO vo : kList) {
			SumKcal += vo.getKcal();
		}
		return SumKcal;
	}
	
	// user의 키를 넣어서 표준 체중 구하는 메서드
	public float standardweight(String stheight) {
		float fweight = (Float.valueOf(stheight) - 100) * 0.9f;
		
		return fweight;
	}
	
	// 위 메서드를 이용한 하루 권장 칼로리 구하는 메서드
	public float calcestandardKcal(UserVO vo) {
		float stweight = standardweight(vo.getHeight());
		
		float standardKcal = stweight * Float.valueOf(vo.getActivityindex());
		
		return standardKcal ;
	}
	
	// (권장칼로리 - 음식칼로리) 계산 메서드
	public int overKcal(UserVO vo, List<KcalVO> kList) {
		int SumKcal = totalKcal(kList);
		int standardKcal = Math.round(calcestandardKcal(vo));
		
		int overKcal = standardKcal - SumKcal;
		
		return overKcal;
	}
	
}
