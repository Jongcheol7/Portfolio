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
import com.englishweb.vo.FreeBoardVO;

@Controller
@RequestMapping("/board")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService service;
	
	// 자유게시판 목록 불러오기
	@GetMapping("/freeBoard")
	public void getFreeBoardPage(Model model) {
		List<FreeBoardVO> list = service.getFreeBoardList();
		model.addAttribute("list", list);
	}
	
	// 자유게시판 글쓰기 페이지 요청
	@GetMapping("/freeBoardWrite")
	public void getFreeBoardWritePage() {
	}
	
	// 자유게시판 글 등록
	@PostMapping("/freeBoardWrite")
	public String registerFreeBoard(FreeBoardVO vo) {
		service.insertFreeBoard(vo);
		return "redirect:/board/freeBoard";
	}

	// 자유게시판 글 상세내용 확인
	@GetMapping("/freeBoardContent")
	public String getFreeBoardContentPage(@RequestParam("boardNo") int boardNo, Model model) {
		FreeBoardVO vo = service.getFreeBoardOne(boardNo);
		System.out.println(vo.getTitle());
		model.addAttribute("vo", vo);
		return "board/freeBoardContent";
	}
	
	

}
