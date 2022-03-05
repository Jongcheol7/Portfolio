package com.englishweb.commons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.englishweb.service.UserService;

@Controller
public class FindIdPwController {

	//private final ApplicationContext context = new ClassPathXmlApplicationContext("main/webapp/WEB-INF/config/root-context.xml");
	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Autowired
	private UserService service;
	
	// 아이디 찾기
	@GetMapping("/user/findID")
	public String findID() {
		return "user/findID";
	}
	
	@PostMapping("/user/findIDResult")
	public String findIDResult(String userName, String email, Model model) {
		
		Map<String, Object> infoFromUser = new HashMap<String, Object>();
		infoFromUser.put("userName", userName);
		infoFromUser.put("email", email);
		
		int result = service.checkNameEmail(infoFromUser);
		if(result == 1) {
			String userId = service.findIdByEmail(email);
			// 메일서비스 시작
			// 메일 제목, 내용
			String subject = "아이디 찾기 입니다";
			String content = userId;
			// 보내는 사람
			String from = "whdcjf817@naver.com";
			// 받는 사람
			String to = email;
			
			try {
				// 메일 내용 넣을 객체와, 이를 도와주는 Helper 객체 생성
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

				// 메일 내용을 채워줌
				mailHelper.setFrom(from);	// 보내는 사람 셋팅
				mailHelper.setTo(to);		// 받는 사람 셋팅
				mailHelper.setSubject(subject);	// 제목 셋팅
				mailHelper.setText(content);	// 내용 셋팅

				// 메일 전송
				mailSender.send(mail);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			// 메일서비스 끝
		}else {
			model.addAttribute("msg", "회원 정보를 다시 입력해주세요");
		}
		return "/user/findIDResult";
	}
	
	// 비밀번호 찾기
	@GetMapping("/user/findPW")
	public String findPW() {
		return "user/findPW";
	}
	
	@PostMapping("/user/findPWResult")
	public String findPWResult(String userName, String userId, String email, Model model) {
		Map<String, Object> infoFromUser = new HashMap<String, Object>();
		infoFromUser.put("userName", userName);
		infoFromUser.put("userId", userId);
		infoFromUser.put("email", email);
		int result = service.checkNameEmailId(infoFromUser);
		if(result == 1) {
			// 임시비밀번호 만들기
			int randomNumber = (int)(Math.random()*1000);
			String tempPw = "aaa!!!"+ randomNumber;
			
			// 임시비밀번호 암호화
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String secureTempPw = encoder.encode(tempPw);
			
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("email", email);
			info.put("tempPw", secureTempPw);
			service.changeTempPw(info);
			
			// 메일서비스 시작
			// 메일 제목, 내용
			String subject = "임시 비밀번호 입니다";
			String content = tempPw + "  비밀번호를 최대한 빠르게 바꿔주세요";
			// 보내는 사람
			String from = "whdcjf817@naver.com";
			// 받는 사람
			String to = email;
			
			try {
				// 메일 내용 넣을 객체와, 이를 도와주는 Helper 객체 생성
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

				// 메일 내용을 채워줌
				mailHelper.setFrom(from);	// 보내는 사람 셋팅
				mailHelper.setTo(to);		// 받는 사람 셋팅
				mailHelper.setSubject(subject);	// 제목 셋팅
				mailHelper.setText(content);	// 내용 셋팅

				// 메일 전송
				mailSender.send(mail);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			// 메일서비스 끝
		}else {
			model.addAttribute("msg", "회원 정보를 다시 입력해주세요");
		}
		return null;
	}
	
}
