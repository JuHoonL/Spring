package com.biz.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.menu.mapper.MenuDao;
import com.biz.menu.model.DropMenuDTO;
import com.biz.menu.model.MenuDTO;
import com.biz.menu.model.MenuDTO.MenuDTOBuilder;

@Service
public class MenuService {

	@Autowired
	MenuDao mDao;
	
	public List<DropMenuDTO> getDBMenu() {
		List<DropMenuDTO> menuList = mDao.getMenus();
		
		return menuList;
	}
	
	public List<MenuDTO> getBulider(){
		
		List<MenuDTO> menuList = new ArrayList<MenuDTO>();
		
		// builder패턴 : 생성자와 setter의 단점을 모두 보완한 방식
		// 생성자패턴의 단점(데이터 주입시 순서에 유의)과
		// setter패턴의 단점(코드가 길어지고 복잡함)을 모두 보완하는 패턴방식
		MenuDTO m = MenuDTO.builder()
				.menu_id("M0001")
				.menu_title("홈으로")
				.menu_href("/").build();
		
		menuList.add(m);
		
		//위의 방법을 아래와 같이 사용 가능
		menuList.add(
				MenuDTO.builder()
				.menu_id("M0002")
				.menu_title("낙서장")
				.menu_href("#").build()
				);
		
		return menuList;
	}
	
	public List<MenuDTO> getMenus() {
		
		List<MenuDTO> menuList = new ArrayList<MenuDTO>();
		
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setMenu_id("M0001");
		menuDTO.setMenu_title("홈");
		menuDTO.setMenu_href("/");
		menuList.add(menuDTO);
		
		menuDTO = new MenuDTO();
		menuDTO.setMenu_id("M0002");
		menuDTO.setMenu_title("게시판");
		menuDTO.setMenu_href("#");
		menuList.add(menuDTO);
		
		menuDTO = new MenuDTO();
		menuDTO.setMenu_id("M0003");
		menuDTO.setMenu_title("메모장");
		menuDTO.setMenu_href("#");
		menuList.add(menuDTO);
		
		menuDTO = new MenuDTO();
		menuDTO.setMenu_id("M0004");
		menuDTO.setMenu_title("로그인");
		menuDTO.setMenu_href("#");
		menuList.add(menuDTO);
		
		menuDTO = new MenuDTO();
		menuDTO.setMenu_id("M0005");
		menuDTO.setMenu_title("회원가입");
		menuDTO.setMenu_href("#");
		menuList.add(menuDTO);
		
		// 생성자를 이용한 입력방법
		menuList.add(new MenuDTO("M0010","Home","#"));
		menuList.add(new MenuDTO("M0011","Home1","#"));
		menuList.add(new MenuDTO("M0012","Home2","#"));
		
		return menuList;
	}
	
	public List<DropMenuDTO> getDropMenu() {
		
		List<DropMenuDTO> dropmenuList = new ArrayList<DropMenuDTO>();
		
		DropMenuDTO menuDTO = new DropMenuDTO();
		menuDTO.setMenu_id("M0001");
		menuDTO.setMenu_title("홈");
		menuDTO.setMenu_href("/");
		dropmenuList.add(menuDTO);
		
		menuDTO = new DropMenuDTO();
		menuDTO.setMenu_id("M0002");
		menuDTO.setMenu_title("게시판");
		menuDTO.setMenu_href("#");
		dropmenuList.add(menuDTO);
		
		List<DropMenuDTO> submenus = new ArrayList<DropMenuDTO>();
		
		menuDTO = new DropMenuDTO();
		menuDTO.setMenu_id("M0004");
		menuDTO.setMenu_title("회원리스트");
		menuDTO.setMenu_href("#");
		submenus.add(menuDTO);
		
		menuDTO = new DropMenuDTO();
		menuDTO.setMenu_id("M0005");
		menuDTO.setMenu_title("시스템 정보");
		menuDTO.setMenu_href("#");
		submenus.add(menuDTO);

		menuDTO = new DropMenuDTO();
		menuDTO.setMenu_id("M0003");
		menuDTO.setMenu_title("관리자");
		menuDTO.setSub_menus(submenus);
		menuDTO.setMenu_href(null);
		dropmenuList.add(menuDTO);
		
		return dropmenuList;
	}
}
