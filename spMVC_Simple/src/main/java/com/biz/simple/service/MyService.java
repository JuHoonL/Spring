package com.biz.simple.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	public int add(int intNum1, int intNum2) {
		
		int sum = intNum1 + intNum2;
		
		return sum;
	}
	
	public int minus(int intNum1, int intNum2) {

		int minus = intNum2 - intNum1;
		
		return minus;
	}
	
	public int multi(int intNum1, int intNum2) {

		int multi = intNum1 * intNum2;
		
		return multi;
	}
	
	public float devide(int intNum1, int intNum2) {

		int devide = intNum2 / intNum1;
		
		return devide;
	}
	
}
