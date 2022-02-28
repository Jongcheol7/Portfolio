package com.englishweb.service;

import java.util.List;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.RecordBoardVO;

@Service
public class MeetingBoardService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 자유게시판 글 등록
	public void insertMeetingBoard(MeetingBoardVO vo) {
		sqlSessionTemplate.insert("meetingBoard.insert", vo);
	}
	
	// 자유게시판 목록 불러오기
	public List<MeetingBoardVO> getMeetingBoardList(){
		List<MeetingBoardVO> list = sqlSessionTemplate.selectList("meetingBoard.getAllList");
		return list;
	}
	
	// 자유게시판 상세보기
	public MeetingBoardVO getMeetingBoardOne(int boardNo) {
		MeetingBoardVO vo = sqlSessionTemplate.selectOne("meetingBoard.getContentOne", boardNo);
		return vo;
	}
	
	// 오늘 등록된 자유게시판 갯수 가져오기
	public int getTodayMeetingBoardNumber() {
		return sqlSessionTemplate.selectOne("recordBoard.todayRecordBoard");
	}
	
	// 메인화면에 자유게시판 10개만 보여주기
	public List<MeetingBoardVO> getMeetingBoardList10(){
		List<MeetingBoardVO> list = sqlSessionTemplate.selectList("recordBoard.getList10");
		return list;
	}
	
}
