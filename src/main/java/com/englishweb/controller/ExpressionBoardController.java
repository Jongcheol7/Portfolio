package com.englishweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.englishweb.service.ExpressionBoardService;
import com.englishweb.service.FreeBoardService;
import com.englishweb.service.WordBoardService;
import com.englishweb.vo.ExpressionBoardVO;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.WordBoardVO;

@Controller
@RequestMapping("/board")
public class ExpressionBoardController {
	@Autowired
	private ExpressionBoardService service;
	
	// 자유게시판 목록 불러오기
	@GetMapping("/expressionBoard")
	public void getExpressionBoardPage(Model model) {
		List<ExpressionBoardVO> list = service.getExpressionBoardList();
		model.addAttribute("list", list);
	}
	
	// 자유게시판 글쓰기 페이지 요청
	@GetMapping("/expressionBoardWrite")
	public void getExpressionBoardWritePage() {
	}
	
	// 자유게시판 글 등록
	@PostMapping("/expressionBoardWrite")
	public String registerExpressionBoard(ExpressionBoardVO vo) {
		service.insertExpressionBoard(vo);
		return "redirect:/board/expressionBoard";
	}

	// 자유게시판 글 상세내용 확인
	@GetMapping("/expressionBoardContent")
	public String getExpressionBoardContentPage(@RequestParam("boardNo") int boardNo, Model model) {
		ExpressionBoardVO vo = service.getExpressionBoardOne(boardNo);
		System.out.println(vo.getExpression());
		model.addAttribute("vo", vo);
		return "board/expressionBoardContent";
	}
	
	// 수정화면 보여주기
	@GetMapping("/expressionBoardModify")
	public String updateExpressionBoardForm(int boardNo, Model model) {
		model.addAttribute("vo", service.getExpressionBoardOne(boardNo));
		return "/board/expressionBoardUpdate";
	}
	// 수정처리
	@PostMapping("/expressionBoardModify")
	public String updateExpressionBoard(ExpressionBoardVO vo) {
		service.update(vo);
		return "redirect:/board/expressionBoard";
	}
	// 삭제처리
	@PostMapping("/expressionBoardDetete")
	public String deleteExpressionBoard(int boardNo) {
		service.delete(boardNo);
		return "redirect:/board/expressionBoard";
	}


}
