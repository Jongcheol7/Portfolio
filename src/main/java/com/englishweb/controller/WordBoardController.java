package com.englishweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.englishweb.commons.PageCreator;
import com.englishweb.commons.SearchVO;
import com.englishweb.service.FreeBoardService;
import com.englishweb.service.WordBoardService;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.WordBoardVO;

@Controller
@RequestMapping("/board")
public class WordBoardController {
	@Autowired
	private WordBoardService service;
	
	// 자유게시판 목록 불러오기
	@GetMapping("/wordBoard")
	public void getWordBoardPage(Model model, SearchVO paging) {
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles(paging));
		paging.setStartArticle(paging.getPage());
		List<WordBoardVO> list = service.getWordBoardList(paging);
		model.addAttribute("list", list);
		model.addAttribute("pc", pc);
	}
	
	// 자유게시판 글쓰기 페이지 요청
	@GetMapping("/wordBoardWrite")
	public void getWordBoardWritePage() {
	}
	
	// 자유게시판 글 등록
	@PostMapping("/wordBoardWrite")
	public String registerWordBoard(WordBoardVO vo) {
		service.insertWordBoard(vo);
		return "redirect:/board/wordBoard";
	}

	// 자유게시판 글 상세내용 확인
	@GetMapping("/wordBoardContent")
	public String getWordBoardContentPage(@RequestParam("boardNo") int boardNo, Model model) {
		WordBoardVO vo = service.getWordBoardOne(boardNo);
		System.out.println(vo.getWord());
		model.addAttribute("vo", vo);
		return "board/wordBoardContent";
	}
	
	// 수정화면 보여주기
	@GetMapping("/wordBoardModify")
	public String updateWordBoardForm(int boardNo, Model model) {
		model.addAttribute("vo", service.getWordBoardOne(boardNo));
		return "/board/wordBoardUpdate";
	}
	// 수정처리
	@PostMapping("/wordBoardModify")
	public String updateWordBoard(WordBoardVO vo) {
		service.update(vo);
		return "redirect:/board/wordBoard";
	}
	// 삭제처리
	@PostMapping("/wordBoardDetete")
	public String deleteWordBoard(int boardNo) {
		service.delete(boardNo);
		return "redirect:/board/wordBoard";
	}
	

}
