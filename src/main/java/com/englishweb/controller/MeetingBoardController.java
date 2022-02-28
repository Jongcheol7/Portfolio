package com.englishweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.englishweb.service.FreeBoardService;
import com.englishweb.service.MeetingBoardService;
import com.englishweb.service.RecordBoardService;
import com.englishweb.vo.FileUploadVO;
import com.englishweb.vo.FreeBoardVO;
import com.englishweb.vo.MeetingBoardVO;
import com.englishweb.vo.RecordBoardVO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("/board")
public class MeetingBoardController {
	
	@Autowired
	private MeetingBoardService service;
	
	// 영어녹음게시판 목록 불러오기
	@GetMapping("/meetingBoard")
	public void getMeetingBoardPage(Model model) {
		List<MeetingBoardVO> list = service.getMeetingBoardList();
		model.addAttribute("list", list);
	}
	
	// 영어녹음게시판 글쓰기 페이지 요청
	@GetMapping("/meetingBoardWrite")
	public void getMeetingBoardWritePage() {
	}
	
	// 영어녹음게시판 글 등록
	@PostMapping(value="/meetingBoardWrite", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String registerMeetingBoard(MultipartFile[] uploadFile, MeetingBoardVO vo) throws IllegalStateException, IOException {
		List<FileUploadVO> list = new ArrayList<FileUploadVO>();
		String uploadFolder = "C:\\upload";
		// 폴더 만들기
		File uploadPath = new File(uploadFolder);
		System.out.println("upload path : " + uploadPath);
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		String str = "";
		String strU = "";
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("upload File name : " + multipartFile.getOriginalFilename());
			System.out.println("upload File size : " + multipartFile.getSize());
			str += multipartFile.getOriginalFilename() + ",";
			FileUploadVO fileVO = new FileUploadVO();

			String uploadFileName = multipartFile.getOriginalFilename();
			fileVO.setFileName(uploadFileName);

			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			//					File saveFile = new File(uploadFolder, uploadFileName);

			//UUID를 이용해서 파일명 바꾸기
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			strU += uploadFileName + ",";


			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				InputStream in = new FileInputStream(saveFile.getAbsolutePath());

				// vo객체에 심어주기
				fileVO.setUuid(uuid.toString());
				fileVO.setUploadPath(getFolder());


				// 이미지 파일인지 검사하기
				if(checkImageType(saveFile)) {
					fileVO.setFileType(false);

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+ uploadFileName));
					Thumbnailator.createThumbnail(in,thumbnail, 100, 100);
					thumbnail.close();
				}
				System.out.println(fileVO);
				list.add(fileVO);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		vo.setMeetingFileNames(str);
		vo.setFileNamesUUID(strU);
		System.out.println(vo);
		service.insertMeetingBoard(vo);
		return "redirect:/board/meetingBoard";
	}

	
	// 영어녹음게시판 글 상세내용 확인
	@GetMapping("/meetingBoardContent")
	public String getMeetingBoardContentPage(@RequestParam("boardNo") int boardNo, Model model) {
		MeetingBoardVO vo = service.getMeetingBoardOne(boardNo);
		System.out.println(vo);
		// 구분자 , 로 파일 이름을 붙여준 파일명
		String fullNames = vo.getMeetingFileNames();
		// ,를 기점으로 파일 명 나누기
		String[] eachName = fullNames.split(",");
		for(int i=0; i<eachName.length; i++) {
			System.out.println(eachName[i]);
		}
		
		String fullNamesU = vo.getFileNamesUUID();
		// ,를 기점으로 파일 명 나누기
		String[] eachNameU = fullNamesU.split(",");
		for(int i=0; i<eachNameU.length; i++) {
			System.out.println(eachNameU[i]);
		}
		
		model.addAttribute("vo", vo);
		model.addAttribute("eachName", eachName);
		model.addAttribute("eachNameU", eachNameU);
		return "board/meetingBoardContent";
	}
	
	
	// 연,월,일 폴더 생성
		private String getFolder() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String str = sdf.format(date);
			return str.replace("-", File.separator);
		}
		
		// 이미지 파일인지 아닌지 검사하는 메서드
		private boolean checkImageType(File file) {
			try {
				String contentType = Files.probeContentType(file.toPath());
				return contentType.startsWith("image");
			}catch(IOException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		// 화면에 썸네일 보여주기
		@GetMapping("/display")
		@ResponseBody
		public ResponseEntity<byte[]> getFile(String fileName){
			File file = new File("C:\\upload\\" + fileName);
			ResponseEntity<byte[]> result = null;
			try {
				HttpHeaders header = new HttpHeaders();
				header.add("Content-Type", Files.probeContentType(file.toPath()));
				result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			}catch(IOException e) {
				e.printStackTrace();
			}
			return result;
		}
	
	

}
