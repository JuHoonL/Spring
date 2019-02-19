package com.biz.health01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value = "home2", method = RequestMethod.GET)
	public String home02(Model model, String MSG) {
				
		model.addAttribute("MSG",MSG);
		
		return "home02";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVO vo, Model model, HttpSession session) {
		
		UserVO sVO = uS.user_FindByUserId(vo.getUserId());
		
		System.out.println(sVO);
		
		String retMsg = "";
		if(sVO == null) {
			retMsg = "false";
		} else {
			if(sVO.getPassword().equals(vo.getPassword())) {
				retMsg = "true";
				session.setAttribute("LOGIN",sVO);
			} else {
				retMsg = "false";
			}
		}
		
		model.addAttribute("MSG",retMsg);
		
		return "redirect:home2";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("LOGIN");
		
		return "redirect:home2";
	}
	
	@RequestMapping(value = "user_join", method = RequestMethod.GET)
	public String user_join() {
		
		return "user_join";
	}
	
	@RequestMapping(value="user_join", method = RequestMethod.POST)
	public String user_join(@ModelAttribute UserVO vo, Model model) {
		
		uS.user_Insert(vo);
		
		return "home";
	}
	
	@RequestMapping(value="user_DB", method = RequestMethod.GET)
	public String user_DB(@ModelAttribute UserVO vo, Model model) {
		
		
		
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
		id = 32;
		vo = fkS.food_FindById(id);
		foodselectList.add(vo);
		id = 58;
		vo = fkS.food_FindById(id);
		foodselectList.add(vo);

		
		int totalkcal = fkS.totalKcal(foodselectList);
		int listSize = foodselectList.size();
		
		model.addAttribute("SELECTFOOD",foodselectList);
		model.addAttribute("TOTALKCAL",totalkcal);
		model.addAttribute("FLISTSIZE",listSize);

		return "food_select";
	}
	
	@RequestMapping(value="sports", method=RequestMethod.GET)
	public String sports(@ModelAttribute UserVO vo, Model model, HttpSession session) {
		
//		UserVO uVO = uS.user_FindByUserId(session.getAttribute(userId));
//		String Kal = foodselect에서 합해진 총 음식 칼로리 TOTALKCAL값 받아온거
		
		String Kg = "73";
		String Kal = "300";
		
//		String Kal = fkS.overKcal(vo, kList);
		
		List<String> spoList = kS.Kcal(Kg, Kal);
//		List<String> spoList = kS.Kcal(uVO.getWeight(), Kal);
		
		for(String s : spoList) {
			System.out.println(s);
		}
		
		model.addAttribute("SLIST",spoList);
		
		return "sports";
	}
	
	
}
