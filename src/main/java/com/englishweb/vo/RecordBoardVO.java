package com.englishweb.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class RecordBoardVO {
	
	private String id;
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
	private String userId;
	private MultipartFile recordFile;
	private String recordFileName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public MultipartFile getRecordFile() {
		return recordFile;
	}
	public void setRecordFile(MultipartFile recordFile) {
		this.recordFile = recordFile;
	}
	public String getRecordFileName() {
		return recordFileName;
	}
	public void setRecordFileName(String recordFileName) {
		this.recordFileName = recordFileName;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RecordBoardVO [id=" + id + ", boardNo=" + boardNo + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", recordFile=" + recordFile
				+ ", recordFileName=" + recordFileName + "]";
	}
	
	

}
