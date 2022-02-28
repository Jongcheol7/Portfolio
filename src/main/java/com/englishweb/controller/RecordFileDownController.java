package com.englishweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class RecordFileDownController {
	
	@GetMapping("/recordFileDownload")
	public void recordFileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String filename = request.getParameter("recordFileName");
		String realFilename = "";
		System.out.println(filename);
		
		try {
            String browser = request.getHeader("User-Agent"); 
            //파일 인코딩 
            if (browser.contains("MSIE") || browser.contains("Trident")
                    || browser.contains("Chrome")) {
                filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+",
                        "%20");
            } else {
                filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
            }
        } catch (UnsupportedEncodingException ex) {
            System.out.println("UnsupportedEncodingException");
        }
		realFilename = "C:\\EnglishRecord\\" + filename;
		System.out.println("realFIlename : " + realFilename);
		File file1 = new File(realFilename);
		if(!file1.exists()) {
			return ;
		}
		
		// 파일명 지정
		response.setContentType("application/octer-stream");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition", "attachment; filename=\""+filename + "\"");
		try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(realFilename);
 
            int ncount = 0;
            byte[] bytes = new byte[512];
 
            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            System.out.println("FileNotFoundException : " + e);
        }
	}
	
	/*
	// 파일 다운로드
		@GetMapping(value="/fileDownload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
		@ResponseBody
		public ResponseEntity<Resource> downloadFile(String fileNameUUID){
			System.out.println("download file : " + fileNameUUID);
			Resource resource = new FileSystemResource("C:\\upload\\"+fileNameUUID);
			System.out.println("resource : " + resource);
			
			String resourceName = resource.getFilename();
			// uuid 제거된 원래 이름
			String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
			HttpHeaders headers = new HttpHeaders();
			try {
				//headers.add("Content-Disposition", "attachment; filename=" + new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
				headers.add("Content-Disposition", "attachment; filename=" + new String(resourceOriginalName.getBytes("UTF-8"),"ISO-8859-1"));
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
		}
		*/
	
	@GetMapping("/fileDownload")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String filename = request.getParameter("fileNameUUID");
		String realFilename = "";
		System.out.println(filename);
		
		try {
            String browser = request.getHeader("User-Agent"); 
            //파일 인코딩 
            if (browser.contains("MSIE") || browser.contains("Trident")
                    || browser.contains("Chrome")) {
                filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+",
                        "%20");
            } else {
                filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
            }
        } catch (UnsupportedEncodingException ex) {
            System.out.println("UnsupportedEncodingException");
        }
		realFilename = "C:\\upload\\" + filename;
		System.out.println("realFIlename : " + realFilename);
		File file1 = new File(realFilename);
		if(!file1.exists()) {
			return ;
		}
		
		// 파일명 지정
		response.setContentType("application/octer-stream");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition", "attachment; filename=\""+filename + "\"");
		try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(realFilename);
 
            int ncount = 0;
            byte[] bytes = new byte[512];
 
            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            System.out.println("FileNotFoundException : " + e);
        }
	}
	
}
