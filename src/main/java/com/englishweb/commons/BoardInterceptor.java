package com.englishweb.commons;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class BoardInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("게시판 인터셉터");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			System.out.println("회원 인증 실패");
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter printwriter = response.getWriter();
			printwriter.print("<script>alert('로그인을 해주십시오');</script>");
			printwriter.print("<script>location.href='/';</script>");
			printwriter.flush();
			printwriter.close();
			return false;
		}
		
		System.out.println("회원 인증 성공");
		return true;
	}
	
	
}
