package com.biz.rent.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.RentDao;
import com.biz.rent.model.RentVO;

@Service
public class RentService {

	@Autowired
	RentDao dao;
	
	// java7 버전이전
	public void old_dateTime() {
		//오늘 날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		
		
		//7일 후 날짜
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);
		String today_7 = sdf.format(cal.getTime());
	}
	
	// java8 이후 버전
	public void new_dateTime() {
		LocalDate ld = LocalDate.now(); 	// 오늘 날짜
		LocalDate ld_p7 = ld.plusDays(7);	// 7일 후 날짜
		LocalDate ld_m7 = ld.minusDays(7);	// 7일 전 날짜
	}
	
	public int insert(RentVO rentVO) {
		return dao.insert(rentVO);
	}
}
