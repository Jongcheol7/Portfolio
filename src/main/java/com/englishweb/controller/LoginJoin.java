package com.englishweb.controller;

import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.englishweb.commons.ChangePwVO;
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
	// 로그인 요청 처리
	@PostMapping("/loginCheck")
	public String loginCheck(@RequestBody UserVO inputData, HttpSession session) {
		System.out.println("id : " + inputData.getUserId() );
		System.out.println("pw : " + inputData.getUserPw());
		String result = null;
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserVO dbData = userService.selectOne(inputData.getUserId());
		
		if(dbData != null) {
			//if(dbData.getUserPw().equals(inputData.getUserPw())) {
			if(encoder.matches(inputData.getUserPw(), dbData.getUserPw())) {
				session.setAttribute("login", dbData);
				result = "loginSuccess";
			}else {
				result = "pwFail";
			}
		}else {
			result = "idFail";
		}
		return result;
	}
	
	// 로그아웃 처리
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		UserVO vo = (UserVO) session.getAttribute("login");
		if(vo != null) {
			session.removeAttribute("login");
		}
		return new ModelAndView("redirect:/");
	}
	
	// 마이페이지 페이지 이동
	@GetMapping("/mypage")
	public ModelAndView mypageForm(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		UserVO user = (UserVO) session.getAttribute("login");
		System.out.println(user.getUserId());
		mv.addObject("vo", userService.selectOne(user.getUserId()));
		mv.setViewName("/board/mypage");
		return mv;
	}
	// 회원 정보 수정 페이지 이동
	@GetMapping("/userModify")
	public ModelAndView userModifyForm(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		UserVO user = (UserVO) session.getAttribute("login");
		mv.addObject("vo", userService.selectOne(user.getUserId()));
		mv.setViewName("/board/userModifyForm");
		return mv;
	}
	
	
	@PostMapping("/pwModify")
	public String userModify(@RequestBody ChangePwVO pws, HttpSession session) {
		
		System.out.println("beforePw : " + pws.getBeforePw());
		System.out.println("afterPw : " + pws.getAfterPw());
		String result = null;
		
		UserVO user = (UserVO) session.getAttribute("login");
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(!encoder.matches(pws.getBeforePw(), user.getUserPw())) {
			result = "wrongPrevPw";
		}else {
			user.setUserPw(encoder.encode(pws.getAfterPw()));
			userService.modifyPw(user);
			result = "success";
		}
		return result;
	}

}
