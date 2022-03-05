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
import com.englishweb.service.FreeBoardService;
import com.englishweb.service.IdiomBoardService;
import com.englishweb.service.WordBoardService;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.IdiomBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.WordBoardVO;

@Controller
@RequestMapping("/board")
public class IdiomBoardController {
	@Autowired
	private IdiomBoardService service;
	
	// 이디엄 목록 불러오기
	@GetMapping("/idiomBoard")
	public void getIdiomBoardPage(Model model, SearchVO paging) {
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles(paging));
		paging.setStartArticle(paging.getPage());
		List<IdiomBoardVO> list = service.getIdiomBoardList(paging);
		model.addAttribute("list", list);
		model.addAttribute("pc", pc);
	}
	
	// 글쓰기 페이지 요청
	@GetMapping("/idiomBoardWrite")
	public void getIdiomritePage() {
	}
	
	// 글 등록
	@PostMapping("/idiomBoardWrite")
	public String registerIdiomBoard(IdiomBoardVO vo) {
		service.insertIdiomBoard(vo);
		return "redirect:/board/idiomBoard";
	}

	// 글 상세내용 확인
	@GetMapping("/idiomBoardContent")
	public String getIdiomBoardContentPage(@RequestParam("boardNo") int boardNo, Model model, @ModelAttribute("pc") SearchVO paging) {
		IdiomBoardVO vo = service.getIdiomBoardOne(boardNo);
		System.out.println(vo.getIdiom());
		model.addAttribute("vo", vo);
		return "board/idiomBoardContent";
	}
	
	// 수정화면 보여주기
	@GetMapping("/idiomBoardModify")
	public String updateIdiomBoardForm(int boardNo, Model model, @ModelAttribute("pc") SearchVO paging) {
		model.addAttribute("vo", service.getIdiomBoardOne(boardNo));
		return "/board/idiomBoardUpdate";
	}
	// 수정처리
	@PostMapping("/idiomBoardModify")
	public String updateIdiomBoard(IdiomBoardVO vo, SearchVO paging) {
		service.update(vo);
		return "redirect:/board/idiomBoard?page="+paging.getPage()+"&countPerPage="+paging.getCountPerPage();
	}
	// 삭제처리
	@PostMapping("/idiomBoardDetete")
	public String deleteIdiomBoard(int boardNo, SearchVO paging) {
		service.delete(boardNo);
		return "redirect:/board/idiomBoard?page="+paging.getPage()+"&countPerPage="+paging.getCountPerPage();
	}


}
