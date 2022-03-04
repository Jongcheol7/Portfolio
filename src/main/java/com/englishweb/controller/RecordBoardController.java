package com.englishweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.commons.PageCreator;
import com.englishweb.commons.SearchVO;
import com.englishweb.service.FreeBoardService;
import com.englishweb.service.RecordBoardService;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.RecordBoardVO;

@Controller
@RequestMapping("/board")
public class RecordBoardController {
	
	@Autowired
	private RecordBoardService service;
	
	// 영어녹음게시판 목록 불러오기
	@GetMapping("/recordBoard")
	public void getRecordBoardPage(Model model, SearchVO paging) {
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles(paging));
		paging.setStartArticle(paging.getPage());
		List<RecordBoardVO> list = service.getRecordBoardList(paging);
		model.addAttribute("list", list);
		model.addAttribute("pc", pc);
	}
	
	// 영어녹음게시판 글쓰기 페이지 요청
	@GetMapping("/recordBoardWrite")
	public void getRecordBoardWritePage() {
	}
	
	// 영어녹음게시판 글 등록
	@PostMapping("/recordBoardWrite")
	public String registerRecordBoard(RecordBoardVO vo) throws IllegalStateException, IOException {
		// 파일 업로드 처리
		String fileName = null;
		MultipartFile recordFile = vo.getRecordFile();
		if(!recordFile.isEmpty()) {
			String originalFileName = recordFile.getOriginalFilename();
			//확장자 구하기
			String ext = FilenameUtils.getExtension(originalFileName);
			// UUID 구하기
			UUID uuid = UUID.randomUUID();
			fileName = uuid + "." + ext;
			recordFile.transferTo(new File("C:\\upload\\"+ fileName));
		}
		System.out.println(vo);
		vo.setRecordFileName(fileName);
		service.insertRecordBoard(vo);
		return "redirect:/board/recordBoard";
	}

	// 영어녹음게시판 글 상세내용 확인
	@GetMapping("/recordBoardContent")
	public String getRecordBoardContentPage(@RequestParam("boardNo") int boardNo, Model model) {
		RecordBoardVO vo = service.getRecordBoardOne(boardNo);
		System.out.println(vo.getTitle());
		System.out.println(vo.getRecordFileName());
		model.addAttribute("vo", vo);
		return "board/recordBoardContent";
	}
	
	// 수정화면 보여주기
	@GetMapping("/recordBoardModify")
	public String updateRecordBoardForm(int boardNo, Model model) {
		model.addAttribute("vo", service.getRecordBoardOne(boardNo));
		return "/board/recordBoardUpdate";
	}
	// 수정처리
	@PostMapping("/recordBoardModify")
	public String updateRecordBoard(RecordBoardVO vo) {
		service.update(vo);
		return "redirect:/board/recordBoard";
	}
	// 삭제처리
	@PostMapping("/recordBoardDetete")
	public String deleteRecordBoard(int boardNo) {
		service.delete(boardNo);
		return "redirect:/board/recordBoard";
	}

	

}
