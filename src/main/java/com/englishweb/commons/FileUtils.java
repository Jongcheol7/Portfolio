package com.englishweb.commons;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUtils {

	@Resource(name="uploadPath")
	String uploadPath;
	
	public List<Map<String, Object>> parseFileInfo(int boardNo2, String userId, MultipartFile[] file) throws Exception{
		
		int boardNo = boardNo2;
		String creaID = userId;
		
		List<Map<String, Object>> fileList = new ArrayList<Map<String,Object>>();
		
		File target = new File(uploadPath);
		if(!target.exists()) target.mkdir();
		
		for(int i=0; i<file.length; i++) {
			String orgFileName = file[i].getOriginalFilename();
			String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
			String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
			Long saveFileSize = file[i].getSize();
			
			System.out.println("==============");
			System.out.println("파일 실제 이름 : " + orgFileName);
			System.out.println("파일 저장 이름 : " + saveFileName);
			System.out.println("파일 크기 : " + saveFileSize);
			System.out.println("content type : " + file[i].getContentType());
			
			target = new File(uploadPath, saveFileName);
			file[i].transferTo(target);
			
			Map<String, Object> fileInfo = new HashMap<String, Object>();
			
			fileInfo.put("boardNo", boardNo);
			fileInfo.put("orgFileName", orgFileName);
			fileInfo.put("saveFileName", saveFileName);
			fileInfo.put("fileSize", saveFileSize);
			fileInfo.put("creaID", creaID);
			fileList.add(fileInfo);
		}
		
		return fileList;
		
	}
	
}
