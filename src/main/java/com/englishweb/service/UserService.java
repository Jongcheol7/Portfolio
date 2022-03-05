package com.englishweb.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		// 회원 비밀번호를 암호화 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("암호화 하기 전 :" + user.getUserPw());
		// 비밀번호 암호화 해서 user 객체에 다시 저장
		String securePw = encoder.encode(user.getUserPw());
		System.out.println("암호화 후 : " + securePw);
		user.setUserPw(securePw);
		sqlSessionTemplate.insert("userMapper.register", user);
	}
	
	// 회원 정보 조회 기능
	public UserVO selectOne(String userId) {
		return sqlSessionTemplate.selectOne("userMapper.selectOne", userId);
	}
	
	// 회원 비밀번호 수정
	public void modifyPw(UserVO user) {
		sqlSessionTemplate.update("userMapper.changePw", user);
	}
	
	// 회훤 탈퇴 기능
	public void delete(String userId) {
		
	}
	
	// 회원 정보 전체 조회 기능
	public List<UserVO> selectAll(){
		
		return null;
	}
	
	// 아이디 찾기 (입력한 이메일과 이름이 존재하는지 여부)
	public int checkNameEmail(Map<String, Object> info) {
		int result = sqlSessionTemplate.selectOne("userMapper.checkNameEmail", info);
		return result;
	}
	// 이메일로 아이디 찾기
	public String findIdByEmail(String email) {
		return sqlSessionTemplate.selectOne("userMapper.findByEmail", email);
	}
	// 비밀번호 찾기 (입력한 이메일, 이름, 아이디 조회후 존재하는지 확인)
	public int checkNameEmailId(Map<String, Object> info) {
		int result = sqlSessionTemplate.selectOne("userMapper.checkNameEmailId",info);
		return result;
	}
	
	// 이메일로 임비 비밀번호 바꿔주기
	public void changeTempPw(Map<String, Object> info) {
		sqlSessionTemplate.update("userMapper.changeTempPw", info);
	}
	
}
