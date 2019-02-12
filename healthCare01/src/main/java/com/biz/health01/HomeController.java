package com.biz.health01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.health01.service.FkcalService;
import com.biz.health01.service.KcalService;
import com.biz.health01.service.UserService;
import com.biz.health01.vo.KcalVO;
import com.biz.health01.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	FkcalService fkS;
	@Autowired
	KcalService kS;
	@Autowired
	UserService uS;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
				
		return "home";
	}
	
	@RequestMapping(value = "user_join", method = RequestMethod.GET)
	public String user_join() {
		
		return "user_join";
	}
	
	@RequestMapping(value="user_join", method = RequestMethod.POST)
	public String user_join(@ModelAttribute UserVO vo, Model model) {
		
		uS.user_Insert(vo);
		
		return "user_DB";
	}
	
	@RequestMapping(value="food_select", method=RequestMethod.GET)
	public String food_select(Model model) {
		
		
		List<KcalVO> foodList = fkS.food_selectGroupCate();

		model.addAttribute("ALLFOODCATE",foodList);

		return "food_selectHome";
	}
	
	@RequestMapping(value="food_select01", method=RequestMethod.GET)
	public String food_select(@Param("cate_code") String cate_code, Model model) {
		
		List<KcalVO> foodList = fkS.food_selectGroupCate();

		model.addAttribute("ALLFOODCATE",foodList);
		
		List<KcalVO> foodcateList = fkS.food_FindByCate_Code(cate_code);

		model.addAttribute("CATEFOOD",foodcateList);
		
		List<KcalVO> foodselectList = new ArrayList<KcalVO>();
		
		long id = 26; //나중에 음식vo에서 받아올 아이디값
		
		KcalVO vo = fkS.food_FindById(id);
		foodselectList.add(vo);
		int totalkcal = fkS.totalKcal(foodselectList);
		int listSize = foodselectList.size();
		
		model.addAttribute("SELECTFOOD",foodselectList);
		model.addAttribute("TOTALKCAL",totalkcal);
		model.addAttribute("FLISTSIZE",listSize);

		return "food_select";
	}
}
