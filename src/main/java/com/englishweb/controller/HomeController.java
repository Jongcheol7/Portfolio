package com.englishweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.englishweb.service.FreeBoardService;
import com.englishweb.service.WordBoardService;

@Controller
public class HomeController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	@Autowired
	private WordBoardService wordBoardService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("todayWordBoard", wordBoardService.getTodayWordBoardNumber());
		model.addAttribute("freeBoardHome", freeBoardService.getFreeBoardList10());
		return "index";
	}
	
	
	
}
