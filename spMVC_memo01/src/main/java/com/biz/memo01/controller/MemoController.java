package com.biz.memo01.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo01.model.MemoVO;
import com.biz.memo01.service.MemoService;

@Controller
public class MemoController {

	@Autowired
	MemoService memoService;
	
	@RequestMapping("memo")
	public String memo(Model model) {
//		return "memoHome";
		List<MemoVO> memoList = memoService.selectAll();
		model.addAttribute("memoList", memoList);
		return "memo_list";
	}
	
	@RequestMapping("memo_view")
	public String memo_view(String id, Model model) {
		
		MemoVO vo = memoService.findById(Long.valueOf(id));
		model.addAttribute("MEMO", vo);
		return "memo_view";
	}
	
	@RequestMapping(value="memo_write", method = RequestMethod.GET)
	public String memo_write(Model model) {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String today = sf.format(d);
		
		LocalDate ld = LocalDate.now();
		today = ld.toString();
		
		MemoVO vo = new MemoVO();
		vo.setM_date(today);
		
		model.addAttribute("MEMO", vo);
		return "memo_write_form";
	}
	
	@RequestMapping(value="memo_write", method = RequestMethod.POST)
	public String memo_write(@ModelAttribute MemoVO vo) {
		
		memoService.memo_write(vo);
//		memoService.insert(vo);
		
		/*
		 Mapper Method에서 문자열을 return하면 /WEB-INF/views 폴더에 있는 
		 jsp 파일을 읽어서 렌더링을 하도록 기본값으로 설정되어 있다.
		 
		 문자열의 시작을 redirect:으로 하면 string은 views를 response하는
		 대신에 강제로 request 주소를 변경한다
		 */
		return "redirect:memo";
	}
	
	@RequestMapping("memo_update")
	public String memo_update(String id, Model model) {
		MemoVO vo = memoService.findById(Long.valueOf(id));
		
		model.addAttribute("MEMO", vo);
		return "memo_write_form";
	}
	
	@RequestMapping("memo_delete")
	public String memo_delete(String id) {
		
		int ret = memoService.delete(Long.valueOf(id));
		
		return "redirect:memo";
	}
}
