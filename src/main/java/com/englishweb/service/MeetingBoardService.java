package com.englishweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.commons.FileUtils;
import com.englishweb.commons.SearchVO;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.RecordBoardVO;

@Service
public class MeetingBoardService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	FileUtils fileUtils;
	
	// 자유게시판 글 등록
	public void insertMeetingBoard(MeetingBoardVO vo) {
		sqlSessionTemplate.insert("meetingBoard.insert", vo);
	}
	
	// 파일 등록
	public void insertFile(Map<String, Object> map) {
		sqlSessionTemplate.insert("meetingBoard.insertFile", map);
	}
	public void insertFile2(MeetingBoardVO vo, MultipartFile[] file) throws Exception{
		insertMeetingBoard(vo);
		List<Map<String, Object>> fileList = fileUtils.parseFileInfo(vo.getBoardNo(), vo.getUserId(), file);
		for(int i=0; i<fileList.size(); i++) {
			insertFile(fileList.get(i));
		}
	}
	// 파일 정보 뿌려주기
	public Map<String, Object> detailFile(int boardNo){
		MeetingBoardVO vo = getMeetingBoardOne(boardNo);
		//map.put("boardNo", vo.getBoardNo());
		List<Map<String, Object>> fileDetail = sqlSessionTemplate.selectList("meetingBoard.detailFile", boardNo);
		//System.out.println(fileDetail.get(0));
		Map<String, Object> resultBoard = new HashMap<String, Object>();
		resultBoard.put("content", vo);
		resultBoard.put("file", fileDetail);
		
		return resultBoard;
	}
	
	
	// 모든 파일 저장된 이름 불러오기
	public List<Map<String, Object>> getAllFileName(){
		List<Map<String, Object>> getAllFile = sqlSessionTemplate.selectList("meetingBoard.getAllFileName");
		//System.out.println(getAllFile.toString());
		return getAllFile;
	}
	
	// 자유게시판 목록 불러오기
	public List<MeetingBoardVO> getMeetingBoardList(SearchVO page){
		List<MeetingBoardVO> list = sqlSessionTemplate.selectList("meetingBoard.getAllList",page);
		return list;
	}
	// 게시글 전체 수 조회
	public int countArticles(SearchVO vo) {
		return sqlSessionTemplate.selectOne("meetingBoard.countArticles", vo);
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
