package com.englishweb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishweb.vo.UserVO;

@Service
public class UserService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 아이디 중복확인
	public int checkId(String userId) {
		int result = sqlSessionTemplate.selectOne("userMapper.checkId",userId);
		return result;
	}
	
	// 회원가입
	public void register(UserVO user) {
		sqlSessionTemplate.insert("userMapper.register", user);
	}
	
	// 로그인
	public int login(UserVO user) {
		int result = sqlSessionTemplate.selectOne("userMapper.login", user );
		return result;
	}
	
}
