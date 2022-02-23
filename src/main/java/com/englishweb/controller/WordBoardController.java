package com.englishweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.englishweb.service.FreeBoardService;
import com.englishweb.service.WordBoardService;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.WordBoardVO;

@Controller
@RequestMapping("/board")
public class WordBoardController {
	@Autowired
	private WordBoardService service;
	
	// 자유게시판 목록 불러오기
	@GetMapping("/wordBoard")
	public void getWordBoardPage(Model model) {
		List<WordBoardVO> list = service.getWordBoardList();
		model.addAttribute("list", list);
	}
	
	// 자유게시판 글쓰기 페이지 요청
	@GetMapping("/wordBoardWrite")
	public void getFreeBoardWritePage() {
	}
	
	// 자유게시판 글 등록
	@PostMapping("/wordBoardWrite")
	public String registerFreeBoard(WordBoardVO vo) {
		service.insertWordBoard(vo);
		return "redirect:/board/wordBoard";
	}

	// 자유게시판 글 상세내용 확인
	@GetMapping("/wordBoardContent")
	public String getFreeBoardContentPage(@RequestParam("boardNo") int boardNo, Model model) {
		WordBoardVO vo = service.getWordBoardOne(boardNo);
		System.out.println(vo.getWord());
		model.addAttribute("vo", vo);
		return "board/wordBoardContent";
	}
	
	

}
