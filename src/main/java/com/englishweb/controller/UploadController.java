package com.englishweb.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.englishweb.service.MeetingBoardService;
import com.englishweb.service.RecordBoardService;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.RecordBoardVO;

@Controller
public class UploadController {
	
	@Autowired
	RecordBoardService recordService;
	@Autowired
	MeetingBoardService meetingService;

	@PostMapping("/board/recordBoardWrite")
	public ModelAndView recordBoardInsert(RecordBoardVO vo ,MultipartFile[] file) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/recordBoard");
		for(int i=0; i<file.length; i++) {
			System.out.println("======================");
			System.out.println("파일 이름 : " + file[i].getName());
			System.out.println("파일 실제 이름 : " + file[i].getOriginalFilename());
			System.out.println("파일 크기 : " + file[i].getSize());
			System.out.println("content type : " + file[i].getContentType());
			System.out.println("======================");
		}
		recordService.insertFile2(vo, file);
		
		return mv;
	}
	
	@PostMapping("/board/meetingBoardWrite")
	public ModelAndView meetingBoardInsert(MeetingBoardVO vo ,MultipartFile[] file) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/meetingBoard");
		for(int i=0; i<file.length; i++) {
			System.out.println("======================");
			System.out.println("파일 이름 : " + file[i].getName());
			System.out.println("파일 실제 이름 : " + file[i].getOriginalFilename());
			System.out.println("파일 크기 : " + file[i].getSize());
			System.out.println("content type : " + file[i].getContentType());
			System.out.println("======================");
		}
		meetingService.insertFile2(vo, file);
		
		return mv;
	}
	
}
