package com.englishweb.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public Map<String, Object> detailFile(String saveFileName){
		Map<String, Object> file = sqlSessionTemplate.selectOne("file.selectFileInfo", saveFileName);
		//System.out.println(file.get("orgFileName"));
		return file;
	}
}
