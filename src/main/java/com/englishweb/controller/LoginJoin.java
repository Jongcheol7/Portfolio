package com.englishweb.controller;

import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.englishweb.service.UserService;
import com.englishweb.vo.UserVO;

@Controller
public class LoginJoin {

	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public String join(HttpServletRequest request, UserVO user, Model model, RedirectAttributes ra) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birthYear")+request.getParameter("birthMonth")+request.getParameter("birthDay");
		user.setGender(gender);
		user.setBirth(birth);
		System.out.println(user);
		//아이디 중복확인 체크
		if(userService.checkId(user.getUserId()) != 0) {
			System.out.println("아이디 중복됨");
			ra.addFlashAttribute("msg", "ExistID");
			return "redirect:/";
		}
//		System.out.println(user.getNickName());
		userService.register(user);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(UserVO user) {
		System.out.println(user);
		int result = userService.login(user);
		System.out.println(result);
		if(result == 0) {
			System.out.println("로그인 실패");
		}else {
			System.out.println("로그인 성공");
		}
		return "redirect:/";
	}
	
}
