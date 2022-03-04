package com.englishweb.commons;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.englishweb.service.FileService;

@Controller
public class FileDownload {

	@Resource(name = "uploadPath")
	String uploadPath;
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/board/filedownload")
	public void downloadFile(String saveFileNameFromView, HttpServletResponse response) throws IOException {
		/*
		 * Map<String, Object> giveToDb = null; giveToDb.put("boardNo", boardNo);
		 * giveToDb.put("orgFileName", orgFileNameFromInput);
		 */
		System.out.println("서비스로 보낼 저장된 파일 이름 : " + saveFileNameFromView);
		Map<String, Object> fileFromDb = fileService.detailFile(saveFileNameFromView);
		
		String saveFileName = (String) fileFromDb.get("saveFileName");
		String orgFileName = (String) fileFromDb.get("orgFileName");
		
		System.out.println("saveFileName : " + saveFileName);
		System.out.println("orgFileName : " + orgFileName);
		
		File downloadFile = new File(uploadPath + saveFileName);
		byte fileByte[] = FileUtils.readFileToByteArray(downloadFile);
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(orgFileName, "UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
