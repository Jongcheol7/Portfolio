package com.englishweb.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.IdiomBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.WordBoardVO;
@Service
public class IdiomBoardService {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 자유게시판 글 등록
	public void insertIdiomBoard(IdiomBoardVO vo) {
		sqlSessionTemplate.insert("idiomBoard.insert", vo);
	}
	
	// 자유게시판 목록 불러오기
	public List<IdiomBoardVO> getIdiomBoardList(){
		List<IdiomBoardVO> list = sqlSessionTemplate.selectList("idiomBoard.getAllList");
		return list;
	}
	
	// 자유게시판 상세보기
	public IdiomBoardVO getIdiomBoardOne(int boardNo) {
		IdiomBoardVO vo = sqlSessionTemplate.selectOne("idiomBoard.getContentOne", boardNo);
		sqlSessionTemplate.update("idiomBoard.hitUp", boardNo);
		return vo;
	}
	
	// 오늘 등록된 자유게시판 갯수 가져오기
	public int getTodayIdiomBoardNumber() {
		return sqlSessionTemplate.selectOne("idiomBoard.todayIdiomBoard");
	}
	
	// 메인화면에 자유게시판 10개만 보여주기
	public List<IdiomBoardVO> getIdiomBoardList10(){
		List<IdiomBoardVO> list = sqlSessionTemplate.selectList("idiomBoard.getList10");
		return list;
	}
	
	// 수정처리
	public void update(IdiomBoardVO vo) {
		sqlSessionTemplate.update("idiomBoard.update", vo);
	}
	
	// 삭제처리
	public void delete(int boardNo) {
		sqlSessionTemplate.delete("idiomBoard.delete", boardNo);
	}
}
