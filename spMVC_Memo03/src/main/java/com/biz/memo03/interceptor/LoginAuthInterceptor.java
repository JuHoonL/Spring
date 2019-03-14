package com.biz.memo03.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.memo03.model.MemberVO;

public class LoginAuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
//		return super.preHandle(request, response, handler);
		/* 
			request정보중에 login정보가 있는가를 검사해보고 login정보가 있으면(not null) Controller에게
			제어권을 넘기고 그렇지않으면 login_form을 보여서 login을 하도록 하겠다. 
		*/	

		//1. HttpServletRequest에서 필요한 session정보만 추출하자
		//preHandler는 Override 된 method이기 때문에 마음대로 매개변수를 바꿀수 없어서 선행작업이 필요
		HttpSession session = request.getSession();
			//가. 혹시 LOGIN 정보에 ROLE 정보가 필요할 때 사용
			MemberVO membervo = (MemberVO) session.getAttribute("LOGIN_INFO");
			//나. 그냥 LOGIN 되었는가만 확인하고 싶을 때 사용
			Object object = session.getAttribute("LOGIN_INFO");
		
		
		//2. 추출한 LOGIN 정보가 null 이 아닌지를 검사
		if(membervo == null) {
			
			response.sendRedirect("login");
			return false;
			
		} else {
			/*
			 	membervo에 ROLE 항목이 있다면 해당 ROLE을 검사
			 	
			 	if(membervo.getM_role() == "USER" {
			 		return redirect:/login_form;
			 	}
			 	if(membervo.getM_role() == "ADMIN") {
			 		// 관리자로 계속 진행
			 	}
			 
			 */
		}
		
		
		//최종 return값이 true이면 Controller에게 req정보를 전달해서 계속 업무를 수행하라
		//최종 return값이 false이면 더이상 진행하지 말고 모든 것을 멈추어라
		return true;
	}
	
	
}
