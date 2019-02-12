package com.biz.memo02.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo02.service.MemoService;
import com.biz.memo02.vo.MemberVO;
import com.biz.memo02.vo.MemoVO;

@Controller
public class MemoController {
	
	@Autowired
	MemoService memoService;
	
	 //	폼을 열때 사용할 reqPath
	@RequestMapping(value="memo_write", method=RequestMethod.GET)
	public String memo_write(Model model) {
		
		model.addAttribute("BODY", "WRITE");
		
		return "home";
	}
	
	@RequestMapping("memo_home")
	public String memo_list(Model model) {
		
		List<MemoVO> memoList = memoService.selectAll();
//		for(MemoVO vo : memoList) {
//			System.out.println(vo);
//		}
		model.addAttribute("MEMOS",memoList);
		model.addAttribute("BODY","LIST");
		model.addAttribute("memberVO",new MemberVO());
		
		return "home";
	}
	
	@RequestMapping("memo_view")
	public String memo_view(@Param("id") long id, String MSG, Model model) {
				
		//매개변수로 전달받은 id를 사용해서 데이터를 읽어오고
		//memo_view와 렌더링 처리
//		System.out.println(id);
		
		MemoVO vo = memoService.getMemo(id);
		
		model.addAttribute("MSG",MSG);
		model.addAttribute("MEMO",vo);
		model.addAttribute("BODY","VIEW");
		return "home";
	}
	
	// 폼으로부터 데이터를 전달 받을 때 사용할 reqPath
	@RequestMapping(value="memo_write", method=RequestMethod.POST)
	public String memo_write(Model model, @ModelAttribute MemoVO vo) {
		
		String retMsg = "";
		String resPath = "";
//		int ret = memoService.insertDB(vo);
		int ret = memoService.writeDB(vo);
		
		if(ret>0) {
			resPath = "redirect:memo_home";
		} else {
			retMsg = "데이터추가 오류";
			resPath = "home";
		}
		
		model.addAttribute("MESSAGE", retMsg);
		model.addAttribute("BODY", "WRITE");
		return resPath;
	}
	
	@RequestMapping(value="memo_update", method=RequestMethod.GET)
	public String memo_update(@Param("id") long id, Model model) {
		
		MemoVO vo = memoService.getMemo(id);
		
		model.addAttribute("MEMO", vo);
		model.addAttribute("BODY", "WRITE");
		
		return "home";
	}
	
	@RequestMapping("memo_delete")
	public String memo_delete(@Param("id") long id, Model model) {
		
		int ret = memoService.delete(id);
//		int ret = -1;
		String resMsg = "";
		String resPath = "";
		
		if(ret>0) {
			resPath = "redirect:memo_home";
		} else {
			resPath = "redirect:memo_view";
			resMsg ="DEL-ERR";
		}
		
		model.addAttribute("id",id);
		model.addAttribute("MSG",resMsg);
		return resPath;
	}
}
