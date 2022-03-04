package com.englishweb.service;

import java.util.List;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishweb.commons.PageVO;
import com.englishweb.commons.SearchVO;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;

@Service
public class FreeBoardService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 자유게시판 글 등록
	public void insertFreeBoard(FreeBoardVO vo) {
		sqlSessionTemplate.insert("freeBoard.insert", vo);
		/* 테스트용
		for(int i=1; i<=320; i++) {
			FreeBoardVO a = new FreeBoardVO();
			a.setUserId("테스트 id " + i);
			a.setWriter("테스트");
			a.setTitle("테스트 제목 " +i);
			a.setContent("테스트 내용");
			sqlSessionTemplate.insert("freeBoard.insert", a);
		}
		*/
	}
	
	
	// 자유게시판 목록 불러오기
	public List<FreeBoardVO> getFreeBoardList(SearchVO page){
		List<FreeBoardVO> list = sqlSessionTemplate.selectList("freeBoard.getAllList", page);
		return list;
	}
	// 게시글 전체 수 조회
	public int countArticles(SearchVO vo) {
		return sqlSessionTemplate.selectOne("freeBoard.countArticles", vo);
	}
	
	// 자유게시판 상세보기
	public FreeBoardVO getFreeBoardOne(int boardNo) {
		FreeBoardVO vo = sqlSessionTemplate.selectOne("freeBoard.getContentOne", boardNo);
		sqlSessionTemplate.update("freeBoard.hitUp", boardNo);
		return vo;
	}
	
	// 오늘 등록된 자유게시판 갯수 가져오기
	public int getTodayFreeBoardNumber() {
		return sqlSessionTemplate.selectOne("freeBoard.todayFreeBoard");
	}
	
	// 메인화면에 자유게시판 12개만 보여주기
	public List<FreeBoardVO> getFreeBoardList12(){
		List<FreeBoardVO> list = sqlSessionTemplate.selectList("freeBoard.getList12");
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
