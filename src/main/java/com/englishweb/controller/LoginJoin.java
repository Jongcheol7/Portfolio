package com.englishweb.controller;

import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.englishweb.service.UserService;
import com.englishweb.vo.UserVO;

@RestController
public class LoginJoin {

	@Autowired
	private UserService userService;

	/*
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
	 */

	// 아이디 중복확인 요청 처리
	@PostMapping("/checkId")
	public String checkId(@RequestBody String userId) {
		System.out.println("checkId로 넘어온 id : " + userId);
		int checkNum = userService.checkId(userId);
		if(checkNum == 1) {
			System.out.println("아이디가 중복됨");
			return "NO";
		}else {
			System.out.println("아이디 사용 가능");
			return "OK";
		}
	}
	// 닉네임 중복확인 요청 처리
	@PostMapping("/checkNickName")
	public String checkNickName(@RequestBody String nickName) {
		System.out.println("checkNickName로 넘어온 닉네임 : " + nickName);
		int checkNum = userService.checkNickName(nickName);
		if(checkNum == 1) {
			System.out.println("닉네임이 중복됨");
			return "NO";
		}else {
			System.out.println("닉네임 사용 가능");
			return "OK";
		}
	}
	// 이메일 중복확인 요청 처리
	@PostMapping("/checkEmail")
	public String checkEmail(@RequestBody String email) {
		System.out.println("checkEmail로 넘어온 email : " + email);
		int checkNum = userService.checkEmaile(email);
		if(checkNum == 1) {
			System.out.println("이메일이 중복됨");
			return "NO";
		}else {
			System.out.println("이메일 사용 가능");
			return "OK";
		}
	}
	// 전화번호 중복확인 요청 처리
	@PostMapping("/checkPhone")
	public String checkPhone(@RequestBody String phone) {
		System.out.println("checkPhone로 넘어온 phone : " + phone);
		int checkNum = userService.checkPhone(phone);
		if(checkNum == 1) {
			System.out.println("전화번호가 중복됨");
			return "NO";
		}else {
			System.out.println("전화번호 사용 가능");
			return "OK";
		}
	}
	
	// 회원가입 요청 처리
	@PostMapping("/join")
	public String register(@RequestBody UserVO user) {
		System.out.println("register로 넘어온 uservo : " + user);
		userService.register(user);
		return "joinSuccess";
	}

}
