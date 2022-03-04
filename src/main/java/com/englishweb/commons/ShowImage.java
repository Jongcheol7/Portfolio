package com.englishweb.commons;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.englishweb.service.MeetingBoardService;

@Controller
public class ShowImage implements WebMvcConfigurer{
	
	@Resource(name = "uploadPath")
	String uploadPath;
	
	@Autowired
	private MeetingBoardService service;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/img/**").addResourceLocations("file:///c:/upload/");
	}
	
	@GetMapping("/showImg")
	public String showPhoto(int field, HttpServletResponse response) throws Exception{
		
		List<Map<String, Object>> AllSaveFileName = service.getAllFileName();
		/*
		 * for(int i=0; i<AllSaveFileName.size(); i++) {
		 * System.out.println(i+"번째 파일이름 : " +
		 * AllSaveFileName.get(i).get("saveFileName")); }
		 */
		String one = (AllSaveFileName.size() >= 1) ? (String) AllSaveFileName.get(0).get("saveFileName") : null;
		String two = (AllSaveFileName.size() >= 2) ? (String) AllSaveFileName.get(1).get("saveFileName") : null;
		String three = (AllSaveFileName.size() >= 3) ? (String) AllSaveFileName.get(2).get("saveFileName") : null;
		String four = (AllSaveFileName.size() >= 4) ? (String) AllSaveFileName.get(3).get("saveFileName") : null;
		String five = (AllSaveFileName.size() >= 5) ? (String) AllSaveFileName.get(4).get("saveFileName") : null;
		
		ServletOutputStream bout = null;
		String imgpath = null;
		FileInputStream f = null;
		int length;
		byte[] buffer;
		
		switch(field) {
		case 1:
			if(one == null) break;
			response.setContentType("image/jpg");
			bout = response.getOutputStream();
			imgpath = uploadPath + one;
			f = new FileInputStream(imgpath);
			buffer = new byte[10];
			while((length=f.read(buffer)) != -1) {
				bout.write(buffer,0,length);
			}
			break;
		case 2:
			if(two == null) break;
			response.setContentType("image/jpg");
			bout = response.getOutputStream();
			imgpath = uploadPath + two;
			f = new FileInputStream(imgpath);
			buffer = new byte[10];
			while((length=f.read(buffer)) != -1) {
				bout.write(buffer,0,length);
			}
			break;
		case 3:
			if(three == null) break;
			response.setContentType("image/jpg");
			bout = response.getOutputStream();
			imgpath = uploadPath + three;
			f = new FileInputStream(imgpath);
			buffer = new byte[10];
			while((length=f.read(buffer)) != -1) {
				bout.write(buffer,0,length);
			}
			break;
		case 4:
			if(four == null) break;
			response.setContentType("image/jpg");
			bout = response.getOutputStream();
			imgpath = uploadPath + four;
			f = new FileInputStream(imgpath);
			buffer = new byte[10];
			while((length=f.read(buffer)) != -1) {
				bout.write(buffer,0,length);
			}
			break;
		case 5:
			if(five == null) break;
			response.setContentType("image/jpg");
			bout = response.getOutputStream();
			imgpath = uploadPath + five;
			f = new FileInputStream(imgpath);
			buffer = new byte[10];
			while((length=f.read(buffer)) != -1) {
				bout.write(buffer,0,length);
			}
			break;
		default:
			break;
		}
		/*
		response.setContentType("image/jpg");
		ServletOutputStream bout = response.getOutputStream();
		
		String imgpath = uploadPath + one;
		FileInputStream f = new FileInputStream(imgpath);
		int length;
		byte[] buffer = new byte[10];
		while((length=f.read(buffer)) != -1) {
			bout.write(buffer,0,length);
		}
		*/
		return null;
	}
	
}
