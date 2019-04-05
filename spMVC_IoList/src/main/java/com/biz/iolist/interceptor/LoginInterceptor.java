package com.biz.iolist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.iolist.model.MemberVO;

// 시작하면 제일 먼저 실행 : 로그인이 되어있지 않은경우 로그인 페이지로 넘어가는 클래스
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// return super.preHandle(request, response, handler);
		HttpSession session = request.getSession();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		
		if(memberVO == null) {
			session.removeAttribute("LOGIN_INFO");
			response.sendRedirect("login?LOGIN_MSG=LOGIN_REQ");
			return false;
		}
		return true;
	}
	
	

	
	
}
