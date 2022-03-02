package com.englishweb.service;

import java.util.List;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;

@Service
public class FreeBoardService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 자유게시판 글 등록
	public void insertFreeBoard(FreeBoardVO vo) {
		sqlSessionTemplate.insert("freeBoard.insert", vo);
	}
	
	// 자유게시판 목록 불러오기
	public List<FreeBoardVO> getFreeBoardList(){
		List<FreeBoardVO> list = sqlSessionTemplate.selectList("freeBoard.getAllList");
		return list;
	}
	
	// 자유게시판 상세보기
	public FreeBoardVO getFreeBoardOne(int boardNo) {
		FreeBoardVO vo = sqlSessionTemplate.selectOne("freeBoard.getContentOne", boardNo);
		return vo;
	}
	
	// 오늘 등록된 자유게시판 갯수 가져오기
	public int getTodayFreeBoardNumber() {
		return sqlSessionTemplate.selectOne("freeBoard.todayFreeBoard");
	}
	
	// 메인화면에 자유게시판 10개만 보여주기
	public List<FreeBoardVO> getFreeBoardList10(){
		List<FreeBoardVO> list = sqlSessionTemplate.selectList("freeBoard.getList10");
		return list;
	}
	
	
	// 수정처리
	public void update(FreeBoardVO vo) {
		sqlSessionTemplate.update("freeBoard.update", vo);
	}
	
	// 삭제처리
	public void delete(int boardNo) {
		sqlSessionTemplate.delete("freeBoard.delete", boardNo);
	}
}
