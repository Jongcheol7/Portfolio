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
import com.englishweb.vo.NoticeBoardVO;

@Service
public class NoticeBoardService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 자유게시판 글 등록
	public void insertNoticeBoard(NoticeBoardVO vo) {
		sqlSessionTemplate.insert("noticeBoard.insert", vo);
	}
	
	// 자유게시판 목록 불러오기
	public List<NoticeBoardVO> getNoticeBoardList(SearchVO page){
		List<NoticeBoardVO> list = sqlSessionTemplate.selectList("noticeBoard.getAllList", page);
		return list;
	}
	// 게시글 전체 수 조회
	public int countArticles(SearchVO vo) {
		return sqlSessionTemplate.selectOne("noticeBoard.countArticles", vo);
	}
	
	// 자유게시판 상세보기
	public NoticeBoardVO getNoticeBoardOne(int boardNo) {
		NoticeBoardVO vo = sqlSessionTemplate.selectOne("noticeBoard.getContentOne", boardNo);
		sqlSessionTemplate.update("noticeBoard.hitUp", boardNo);
		return vo;
	}
	
	// 오늘 등록된 자유게시판 갯수 가져오기
	public int getTodayNoticeBoardNumber() {
		return sqlSessionTemplate.selectOne("noticeBoard.todayFreeBoard");
	}
	
	// 메인화면에 자유게시판 12개만 보여주기
	public List<NoticeBoardVO> getNoticeBoardList12(){
		List<NoticeBoardVO> list = sqlSessionTemplate.selectList("noticeBoard.getList12");
		return list;
	}
	

	
	// 수정처리
	public void update(NoticeBoardVO vo) {
		sqlSessionTemplate.update("noticeBoard.update", vo);
	}
	
	// 삭제처리
	public void delete(int boardNo) {
		sqlSessionTemplate.delete("noticeBoard.delete", boardNo);
	}
	
}
