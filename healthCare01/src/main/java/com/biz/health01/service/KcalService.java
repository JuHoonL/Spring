package com.biz.health01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.health01.model.KcalDao;
import com.biz.health01.vo.KcalVO;

@Service
public class KcalService {
	

	@Autowired
	KcalDao kcalMapper;
	
	String[] active= {"3.8","7","8","2.5","10","8","7","7","8","4","11","7"};
	
	public String Kcal(String Kg, String Kal) {
		int length = active.length;
		
		for(int i = 0; i < length ; i ++) {
			float fActiver = Float.valueOf(active[i]);
			float intkg = (float)(Integer.valueOf(Kg)*3.5*fActiver)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			switch(i) {
				case 0 : 
					String walk = "걷기운동 : " + time;
					System.out.println(walk);
					break;
				case 1 :
					String climb = "등산운동 : " + time;
					System.out.println(climb);
					break;
				case 2 :
					String cycle = "싸이클운동 : " + time;
					System.out.println(cycle);
					break;
				case 3 :
					String hulahoop = "훌라후프운동 : " + time;
					System.out.println(hulahoop);
					break;
					
				case 4 :
					String riding = "자전거운동 : " + time;
					System.out.println(riding);
					break;
				case 5 :
					String ropeskipping = "줄넘기운동 : " + time;
					System.out.println(ropeskipping);
					break;
				case 6 :
					String running = "달리기운동 : " + time;
					System.out.println(running);
					break;
				case 7 :
					String situp = "윗몸운동 : " + time;
					System.out.println(situp);
					break;
				case 8 :
					String squat = "스쿼트운동 : " + time;
					System.out.println(squat);
					break;
				case 9 :
					String Treadmill = "런닝머신운동 : " + time;
					System.out.println(Treadmill);
					break;
				case 10 :
					String yoga = "요가운동 : " + time;
					System.out.println(yoga);
					break;
				case 11 :
					String stair = "계단운동 : " + time;
					System.out.println(stair);
					break;
			}
		}
		return null;
	}
	

	//걷기운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
	public int walkKcal(String Kg, String Kal) {
		float intkg = (float)(Integer.valueOf(Kg)*3.5*3.8)/200;
		
		float floatKal = Float.valueOf(Kal);
		
		int time = Math.round(floatKal/intkg);
		
		return time;
	}
	
	//계단운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int stairKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*7)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//등산운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int climbKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*8)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//요가운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int yogaKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*2.5)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//줄넘기운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int ropeskippingKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*10)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//자전거운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int ridingKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*8)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//달리기운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int runningKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*7)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//스쿼트운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int squatKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*7)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//윗몸일으키기운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int situpKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*8)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//훌라후프운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int hulahoopKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*4)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//런닝머신운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int TreadmillKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*11)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
		
		//사이클운동시 소모칼로리 계산 (kg 몸무게, kal 소모할 칼로리)
		public int cycleKcal(String Kg, String Kal) {
			float intkg = (float)(Integer.valueOf(Kg)*3.5*7)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			return time;
		}
}
