package com.biz.memo03.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biz.memo03.model.MemberVO;
import com.biz.memo03.model.MemoVO;
import com.biz.memo03.service.FileService;
import com.biz.memo03.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemoController {
	
	@Autowired
	MemoService mService;
	
	@Autowired
	FileService fService;
	
	@RequestMapping(value="memo",method=RequestMethod.GET)
	public String memo(Model model) {
		
		MemoVO memoVO = new MemoVO();
		LocalDate ld = LocalDate.now();
		memoVO.setM_date(ld.toString());
		model.addAttribute("MEMO",memoVO);
		
		return "bodys/memo_form";
	
	}
	
	
	@RequestMapping(value="memo",method=RequestMethod.POST)
	public String memo(@ModelAttribute MemoVO memoVO) {
		log.debug(memoVO.toString());
		int ret = mService.save(memoVO);
		return "bodys/memo_form" ;
	}

	/*
	 * 메모 리스트 보기에서
	 * 전체 메모보기를 로그인한 사용자가 작성한
	 * 메모만 보이도록 변경
	 */
	@RequestMapping(value="memo_list",method=RequestMethod.GET)
	public ModelAndView memo_list(HttpSession session) {
		
		MemberVO mVO = (MemberVO) session.getAttribute("LOGIN_INFO");
		String userid = mVO.getM_userid();
		
		List<MemoVO> memoList 
				= mService.selectByuserId(userid);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bodys/memo_list");
		mv.addObject("MEMOS", memoList);
		return mv;
		
	}

	
	
	@RequestMapping(value="memo_list2",method=RequestMethod.GET, produces="text/html;charset=utf8")
	public ModelAndView memo_list2() {
		
		List<MemoVO> memoList = mService.selectAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bodys/memo_card_list");
		mv.addObject("MEMOS", memoList);
		return mv;
	}

	@RequestMapping(value="memo_list1",method=RequestMethod.GET)
	public String memo_list(Model model) {
		
		List<MemoVO> memoList = mService.selectAll();
		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("body/memo_list");
//		mv.addObject("MEMOS", memoList);
		
		model.addAttribute("MEMOS",memoList);
		return "bodys/memo_list" ;
	}

	
	/*
	 * memo_list에서 메모를 클릭하면
	 * id를 ajax 통해서 보낸다.
	 * 
	 * 이 id에 해당하는 메모를 DB에서 읽어서
	 * bodys/memo view에 보여주는 코드 작성
	 */
	@RequestMapping(value="memo_view",method=RequestMethod.GET)
	public String memo_view(@RequestParam long id,Model model) {
	
		MemoVO vo = mService.findById(id);
		model.addAttribute("MEMO",vo);
		return "bodys/memo_form" ;

	}
	
	@ResponseBody
	@RequestMapping(value="memo_delete",method=RequestMethod.GET)
	public String memo_delete(@RequestParam long id,Model model) {
		//메모를 삭제할 때 tbl_memo 테이블에서 메모를 삭제하면
		//tbl_files 테이블의 데이터도 함께 삭제가 되지만 물리적으로 저장된
		//파일은 삭제 되지않는다.
		
		//1. 물리적 저장파일을 삭제하고 처리해 주어야 한다.
		fService.fileDelete(id);
		mService.delete(id);
		
		return "OK";
	
	}
}