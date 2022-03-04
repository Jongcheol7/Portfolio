package com.englishweb.service;

import java.util.List;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishweb.commons.SearchVO;
import com.englishweb.vo.ExpressionBoardVO;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;

@Service
public class ExpressionBoardService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 자유게시판 글 등록
	public void insertExpressionBoard(ExpressionBoardVO vo) {
		sqlSessionTemplate.insert("expressionBoard.insert", vo);
	}
	
	// 자유게시판 목록 불러오기
	public List<ExpressionBoardVO> getExpressionBoardList(SearchVO page){
		List<ExpressionBoardVO> list = sqlSessionTemplate.selectList("expressionBoard.getAllList", page);
		return list;
	}
	// 게시글 전체 수 조회
	public int countArticles(SearchVO vo) {
		return sqlSessionTemplate.selectOne("expressionBoard.countArticles", vo);
	}
	
	// 자유게시판 상세보기
	public ExpressionBoardVO getExpressionBoardOne(int boardNo) {
		ExpressionBoardVO vo = sqlSessionTemplate.selectOne("expressionBoard.getContentOne", boardNo);
		sqlSessionTemplate.update("expressionBoard.hitUp", boardNo);
		return vo;
	}
	
	// 오늘 등록된 자유게시판 갯수 가져오기
	public int getTodayExpressionBoardNumber() {
		return sqlSessionTemplate.selectOne("expressionBoard.todayExpressionBoard");
	}
	
	// 수정처리
	public void update(ExpressionBoardVO vo) {
		sqlSessionTemplate.update("expressionBoard.update", vo);
	}
	
	// 삭제처리
	public void delete(int boardNo) {
		sqlSessionTemplate.delete("expressionBoard.delete", boardNo);
	}
	
	
}
