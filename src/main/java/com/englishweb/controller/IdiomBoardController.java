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
import com.englishweb.service.IdiomBoardService;
import com.englishweb.service.WordBoardService;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.IdiomBoardVO;
import com.englishweb.vo.WordBoardVO;

@Controller
@RequestMapping("/board")
public class IdiomBoardController {
	@Autowired
	private IdiomBoardService service;
	
	// 자유게시판 목록 불러오기
	@GetMapping("/idiomBoard")
	public void getIdiomBoardPage(Model model) {
		List<IdiomBoardVO> list = service.getIdiomBoardList();
		model.addAttribute("list", list);
	}
	
	// 자유게시판 글쓰기 페이지 요청
	@GetMapping("/idiomBoardWrite")
	public void getIdiomritePage() {
	}
	
	// 자유게시판 글 등록
	@PostMapping("/idiomBoardWrite")
	public String registerIdiomBoard(IdiomBoardVO vo) {
		service.insertIdiomBoard(vo);
		return "redirect:/board/idiomBoard";
	}

	// 자유게시판 글 상세내용 확인
	@GetMapping("/idiomBoardContent")
	public String getIdiomBoardContentPage(@RequestParam("boardNo") int boardNo, Model model) {
		IdiomBoardVO vo = service.getIdiomBoardOne(boardNo);
		System.out.println(vo.getIdiom());
		model.addAttribute("vo", vo);
		return "board/idiomBoardContent";
	}
	
	

}
