package com.englishweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.englishweb.commons.PageCreator;
import com.englishweb.commons.SearchVO;
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
	
	// 영어표현 목록 불러오기
	@GetMapping("/expressionBoard")
	public void getExpressionBoardPage(Model model, SearchVO paging) {
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles(paging));
		paging.setStartArticle(paging.getPage());
		List<ExpressionBoardVO> list = service.getExpressionBoardList(paging);
		model.addAttribute("list", list);
		model.addAttribute("pc", pc);
	}
	
	// 글쓰기 페이지 요청
	@GetMapping("/expressionBoardWrite")
	public void getExpressionBoardWritePage() {
	}
	
	// 글 등록
	@PostMapping("/expressionBoardWrite")
	public String registerExpressionBoard(ExpressionBoardVO vo) {
		service.insertExpressionBoard(vo);
		return "redirect:/board/expressionBoard";
	}

	// 글 상세내용 확인
	@GetMapping("/expressionBoardContent")
	public String getExpressionBoardContentPage(@RequestParam("boardNo") int boardNo, Model model, @ModelAttribute("pc") SearchVO paging) {
		ExpressionBoardVO vo = service.getExpressionBoardOne(boardNo);
		System.out.println(vo.getExpression());
		model.addAttribute("vo", vo);
		return "board/expressionBoardContent";
	}
	
	// 수정화면 보여주기
	@GetMapping("/expressionBoardModify")
	public String updateExpressionBoardForm(int boardNo, Model model, @ModelAttribute("pc") SearchVO paging) {
		model.addAttribute("vo", service.getExpressionBoardOne(boardNo));
		return "/board/expressionBoardUpdate";
	}
	// 수정처리
	@PostMapping("/expressionBoardModify")
	public String updateExpressionBoard(ExpressionBoardVO vo, SearchVO paging) {
		service.update(vo);
		return "redirect:/board/expressionBoard?page="+paging.getPage()+"&countPerPage="+paging.getCountPerPage();
	}
	// 삭제처리
	@PostMapping("/expressionBoardDetete")
	public String deleteExpressionBoard(int boardNo, SearchVO paging) {
		service.delete(boardNo);
		return "redirect:/board/expressionBoard?page="+paging.getPage()+"&countPerPage="+paging.getCountPerPage();
	}


}
