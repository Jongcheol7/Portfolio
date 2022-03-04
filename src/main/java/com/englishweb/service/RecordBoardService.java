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
public class RecordBoardService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	FileUtils fileUtils;
	
	// 자유게시판 글 등록
	public void insertRecordBoard(RecordBoardVO vo) {
		sqlSessionTemplate.insert("recordBoard.insert", vo);
	}
	
	// 파일 등록
	public void insertFile(Map<String, Object> map) {
		sqlSessionTemplate.insert("recordBoard.insertFile", map);
	}
	public void insertFile2(RecordBoardVO vo, MultipartFile[] file) throws Exception{
		insertRecordBoard(vo);
		List<Map<String, Object>> fileList = fileUtils.parseFileInfo(vo.getBoardNo(), vo.getUserId() , file);
		for(int i=0; i<fileList.size(); i++) {
			insertFile(fileList.get(i));
		}
	}
	// 파일 정보 뿌려주기
	public Map<String, Object> detailFile(int boardNo){
		RecordBoardVO vo = getRecordBoardOne(boardNo);
		//map.put("boardNo", vo.getBoardNo());
		List<Map<String, Object>> fileDetail = sqlSessionTemplate.selectList("recordBoard.detailFile", boardNo);
		System.out.println(fileDetail.get(0));
		Map<String, Object> resultBoard = new HashMap<String, Object>();
		resultBoard.put("content", vo);
		resultBoard.put("file", fileDetail);
		
		return resultBoard;
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
