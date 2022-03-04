package com.englishweb.service;

import java.util.List;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.commons.SearchVO;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.RecordBoardVO;

@Service
public class RecordBoardService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 자유게시판 글 등록
	public void insertRecordBoard(RecordBoardVO vo) {
		sqlSessionTemplate.insert("recordBoard.insert", vo);
	}
	
	// 자유게시판 목록 불러오기
	public List<RecordBoardVO> getRecordBoardList(SearchVO page){
		List<RecordBoardVO> list = sqlSessionTemplate.selectList("recordBoard.getAllList", page);
		return list;
	}
	// 게시글 전체 수 조회
	public int countArticles(SearchVO vo) {
		return sqlSessionTemplate.selectOne("recordBoard.countArticles", vo);
	}
	// 자유게시판 상세보기
	public RecordBoardVO getRecordBoardOne(int boardNo) {
		RecordBoardVO vo = sqlSessionTemplate.selectOne("recordBoard.getContentOne", boardNo);
		sqlSessionTemplate.update("recordBoard.hitUp", boardNo);
		return vo;
	}
	
	// 오늘 등록된 자유게시판 갯수 가져오기
	public int getTodayRecordBoardNumber() {
		return sqlSessionTemplate.selectOne("recordBoard.todayRecordBoard");
	}
	
	// 메인화면에 자유게시판 10개만 보여주기
	public List<RecordBoardVO> getRecordBoardList10(){
		List<RecordBoardVO> list = sqlSessionTemplate.selectList("recordBoard.getList10");
		return list;
	}
	
	// 수정처리
	public void update(RecordBoardVO vo) {
		sqlSessionTemplate.update("recordBoard.update", vo);
	}
	
	// 삭제처리
	public void delete(int boardNo) {
		sqlSessionTemplate.delete("recordBoard.delete", boardNo);
	}
	
}
