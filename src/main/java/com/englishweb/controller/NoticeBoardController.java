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
import com.englishweb.commons.PageVO;
import com.englishweb.commons.SearchVO;
import com.englishweb.service.FreeBoardService;
import com.englishweb.service.NoticeBoardService;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.NoticeBoardVO;

@Controller
@RequestMapping("/board")
public class NoticeBoardController {
	
	@Autowired
	private NoticeBoardService service;
	
	// 자유게시판 목록 불러오기
	@GetMapping("/noticeBoard")
	public void getNoticeBoardPage(Model model, SearchVO paging) {
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles(paging));
		paging.setStartArticle(paging.getPage());
		List<NoticeBoardVO> list = service.getNoticeBoardList(paging);
		
		System.out.println(pc.getPaging());
		System.out.println(pc);
		
		model.addAttribute("list", list);
		model.addAttribute("pc", pc);
	}
	
	// 자유게시판 글쓰기 페이지 요청
	@GetMapping("/noticeBoardWrite")
	public void getNoticeBoardWritePage() {
	}
	
	// 자유게시판 글 등록
	@PostMapping("/noticeBoardWrite")
	public String registerNoticeBoard(NoticeBoardVO vo) {
		service.insertNoticeBoard(vo);
		return "redirect:/board/noticeBoard";
	}

	// 자유게시판 글 상세내용 확인
	@GetMapping("/noticeBoardContent")
	public String getNoticeBoardContentPage(@RequestParam("boardNo") int boardNo, Model model) {
		NoticeBoardVO vo = service.getNoticeBoardOne(boardNo);
		System.out.println(vo.getTitle());
		model.addAttribute("vo", vo);
		return "board/noticeBoardContent";
	}
	
	// 수정화면 보여주기
	@GetMapping("/noticeBoardModify")
	public String updateNoticeBoardForm(int boardNo, Model model) {
		model.addAttribute("vo", service.getNoticeBoardOne(boardNo));
		return "/board/noticeBoardUpdate";
	}
	// 수정처리
	@PostMapping("/noticeBoardModify")
	public String updateNoticeBoard(NoticeBoardVO vo) {
		service.update(vo);
		return "redirect:/board/noticeBoard";
	}
	// 삭제처리
	@PostMapping("/noticeBoardDetete")
	public String deleteNoticeBoard(int boardNo) {
		service.delete(boardNo);
		return "redirect:/board/noticeBoard";
	}
	

}
