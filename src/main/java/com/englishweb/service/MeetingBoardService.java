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
		sqlSessionTemplate.update("meetingBoard.hitUp", boardNo);
		return vo;
	}
	

	// 수정처리
	public void update(MeetingBoardVO vo) {
		sqlSessionTemplate.update("meetingBoard.update", vo);
	}
	
	// 삭제처리
	public void delete(int boardNo) {
		sqlSessionTemplate.delete("meetingBoard.delete", boardNo);
	}
}
