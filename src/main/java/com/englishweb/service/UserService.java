package com.englishweb.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishweb.vo.UserVO;

@Service
public class UserService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 아이디 중복확인
//	public int checkId(String userId) {
//		int result = sqlSessionTemplate.selectOne("userMapper.checkId",userId);
//		return result;
//	}
	
	// 회원가입
//	public void register(UserVO user) {
//		sqlSessionTemplate.insert("userMapper.register", user);
//	}
	
	// 로그인
	public int login(UserVO user) {
		int result = sqlSessionTemplate.selectOne("userMapper.login", user );
		return result;
	}
	
	// 아이디 중복체크 기능
	public int checkId(String userId) {
		int checkIdResult = sqlSessionTemplate.selectOne("userMapper.checkId", userId);
		return checkIdResult;
	}
	// 닉네임 중복체크 기능
	public int checkNickName(String nickName) {
		int checkNickNameResult = sqlSessionTemplate.selectOne("userMapper.checkNickName", nickName);
		return checkNickNameResult;
	}
	// 이메일 중복체크 기능
	public int checkEmaile(String email) {
		int checkEmaileResult = sqlSessionTemplate.selectOne("userMapper.checkEmail", email);
		return checkEmaileResult;
	}
	// 전화번호 중복체크 기능
	public int checkPhone(String phone) {
		int checkPhoneResult = sqlSessionTemplate.selectOne("userMapper.checkPhone", phone);
		return checkPhoneResult;
	}
	
	// 회원 가입 기능
	public void register(UserVO user) {
		sqlSessionTemplate.insert("userMapper.register", user);
	}
	
	// 회원 정보 조회 기능
	public UserVO selectOne(String userId) {
		
		return null;
	}
	
	// 회훤 탈퇴 기능
	public void delete(String userId) {
		
	}
	
	// 회원 정보 전체 조회 기능
	public List<UserVO> selectAll(){
		
		return null;
	}
	
}
