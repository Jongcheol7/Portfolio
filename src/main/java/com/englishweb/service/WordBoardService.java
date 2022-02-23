package com.englishweb.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.WordBoardVO;
@Service
public class WordBoardService {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 자유게시판 글 등록
	public void insertWordBoard(WordBoardVO vo) {
		sqlSessionTemplate.insert("wordBoard.insert", vo);
	}
	
	// 자유게시판 목록 불러오기
	public List<WordBoardVO> getWordBoardList(){
		List<WordBoardVO> list = sqlSessionTemplate.selectList("wordBoard.getAllList");
		return list;
	}
	
	// 자유게시판 상세보기
	public WordBoardVO getWordBoardOne(int boardNo) {
		WordBoardVO vo = sqlSessionTemplate.selectOne("wordBoard.getContentOne", boardNo);
		return vo;
	}
	
	// 오늘 등록된 자유게시판 갯수 가져오기
	public int getTodayWordBoardNumber() {
		return sqlSessionTemplate.selectOne("wordBoard.todayWordBoard");
	}
	
	// 메인화면에 자유게시판 10개만 보여주기
	public List<WordBoardVO> getWordBoardList10(){
		List<WordBoardVO> list = sqlSessionTemplate.selectList("wordBoard.getList10");
		return list;
	}
}
