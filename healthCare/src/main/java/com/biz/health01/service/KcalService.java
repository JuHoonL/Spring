package com.biz.health01.service;

import org.springframework.stereotype.Service;

@Service
public class KcalService {
	

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
