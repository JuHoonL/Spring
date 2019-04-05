package com.biz.iolist.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.IolistDto;
import com.biz.iolist.model.IolistVO;
import com.biz.iolist.service.IolistService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes("iolistVO")
@Controller
@RequestMapping("/iolist")
public class IolistController {

	@Autowired
	IolistService iService;
	
	@ModelAttribute("iolistVO")
	public IolistVO newiolistVO() {
		IolistVO iolistVO = new IolistVO();
		
		return iolistVO;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
//		List<IolistVO> ioList = iService.selectAll();
		
		List<IolistDto> ioList = iService.iolistJoin();
		
		model.addAttribute("LIST",ioList);
		model.addAttribute("BODY","IO_LIST");
		
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model) {
		
		IolistVO iolistVO = new IolistVO();
				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		Date d = new Date();
		String today = sdf.format(d);
		String time = sdf1.format(d);
		iolistVO.setIo_date(today);
		iolistVO.setIo_time(time);
		
		model.addAttribute("iolistVO",iolistVO);
		model.addAttribute("BODY","IO_WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam long io_id,Model model) {

		log.debug("리스트 아이디는 리스트 아이디는 리스트 아이디는 리스트 아이디는 리스트 아이디는 :"+io_id);
		IolistVO iolistVO = iService.findById(io_id);
		
		model.addAttribute("iolistVO",iolistVO);
		model.addAttribute("ACTION","UPDATE");
		model.addAttribute("BODY","IO_WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("iolistVO") IolistVO iolistVO, Model model, SessionStatus sessionS) {
		
		if(iolistVO.getIo_id() == 0) {
			iService.insert(iolistVO);
			model.addAttribute("MSG","데이터 추가 성공!!");
		}else {
			iService.update(iolistVO);
			model.addAttribute("MSG","데이터 수정 성공!!");
		}
		
		sessionS.setComplete();
		
		return "redirect:/iolist/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam long io_id,Model model) {

		iService.delete(io_id);
		
		return "redirect:/iolist/list";
	}
}
