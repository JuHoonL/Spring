package com.biz.ajax.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.biz.ajax.vo.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	
	public List<ProductVO> readFile() {
		
		List<ProductVO> pList = new ArrayList<ProductVO>();
		
		String txtFile = "product.txt";
		
		ClassPathResource cpr = new ClassPathResource(txtFile);
		
		InputStreamReader isr ;
		
		BufferedReader br ;
		
		try {
			isr = new InputStreamReader(cpr.getInputStream());
			br = new BufferedReader(isr);
			
			while(true) {
				String rF = br.readLine();
				if(rF == null) break;
				
				String[] strRF = rF.split(":");
				
				ProductVO vo = new ProductVO();
				vo.setP_ccode(strRF[0]);
				vo.setP_cname(strRF[1]);
				vo.setP_vat(strRF[2]);
				vo.setP_iprice(Integer.valueOf(strRF[3]));
				vo.setP_oprice(Integer.valueOf(strRF[4]));
				
				pList.add(vo);
			}
			br.close();
			isr.close();
			
			return pList;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
