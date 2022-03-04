package com.englishweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.englishweb.service.ExpressionBoardService;
import com.englishweb.service.FreeBoardService;
import com.englishweb.service.IdiomBoardService;
import com.englishweb.service.NoticeBoardService;
import com.englishweb.service.RecordBoardService;
import com.englishweb.service.WordBoardService;

@Controller
public class HomeController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	@Autowired
	private WordBoardService wordBoardService;
	@Autowired
	private RecordBoardService recordBoardService;
	@Autowired
	private ExpressionBoardService expressionBoardService;
	@Autowired
	private IdiomBoardService idiomBoardService;
	@Autowired
	private NoticeBoardService noticeBoardService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("todayWordBoard", wordBoardService.getTodayWordBoardNumber());
		model.addAttribute("todayRecordBoard", recordBoardService.getTodayRecordBoardNumber());
		model.addAttribute("freeBoardHome", freeBoardService.getFreeBoardList12());
		model.addAttribute("noticeBoardHome", noticeBoardService.getNoticeBoardList12());
		model.addAttribute("todayExpressionBoard", expressionBoardService.getTodayExpressionBoardNumber());
		model.addAttribute("todayIdiomBoard", idiomBoardService.getTodayIdiomBoardNumber());
		System.out.println("index화면으로");
		return "index";
	}
	
	
	
}
