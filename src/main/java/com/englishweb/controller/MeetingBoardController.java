package com.englishweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.englishweb.commons.PageCreator;
import com.englishweb.commons.SearchVO;
import com.englishweb.service.FreeBoardService;
import com.englishweb.service.MeetingBoardService;
import com.englishweb.service.RecordBoardService;
import com.englishweb.vo.FileUploadVO;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.RecordBoardVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.coobird.thumbnailator.Thumbnailator;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/board")
public class MeetingBoardController {
	
	@Autowired
	private MeetingBoardService service;
	
	// 목록 불러오기
	@GetMapping("/meetingBoard")
	public void getMeetingBoardPage(Model model, SearchVO paging) {
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles(paging));
		paging.setStartArticle(paging.getPage());
		List<MeetingBoardVO> list = service.getMeetingBoardList(paging);
		model.addAttribute("list", list);
		model.addAttribute("pc", pc);
	}
	
	// 글쓰기 페이지 요청
	@GetMapping("/meetingBoardWrite")
	public void getMeetingBoardWritePage() {
	}
	
	
	// 글 상세내용 확인
	@GetMapping("/meetingBoardContent")
	public String getMeetingBoardContentPage(@RequestParam("boardNo") int boardNo, Model model, @ModelAttribute("pc") SearchVO paging) {
		Map<String, Object> resultBoard = service.detailFile(boardNo);
		model.addAttribute("vo", resultBoard.get("content"));
		model.addAttribute("file", resultBoard.get("file"));
		
		return "board/meetingBoardContent";
	}
	
	// 수정화면 보여주기
	@GetMapping("/meetingBoardModify")
	public String updateMeetingBoardForm(int boardNo, Model model, @ModelAttribute("pc") SearchVO paging) {
		model.addAttribute("vo", service.getMeetingBoardOne(boardNo));
		return "/board/meetingBoardUpdate";
	}
	// 수정처리
	@PostMapping("/meetingBoardModify")
	public String updateMeetingBoard(MeetingBoardVO vo, SearchVO paging) {
		service.update(vo);
		return "redirect:/board/meetingBoard?page="+paging.getPage()+"&countPerPage="+paging.getCountPerPage();
	}
	// 삭제처리
	@PostMapping("/meetingBoardDetete")
	public String deleteMeetingBoard(int boardNo, SearchVO paging) {
		service.delete(boardNo);
		return "redirect:/board/meetingBoard?page="+paging.getPage()+"&countPerPage="+paging.getCountPerPage();
	}
	

}
