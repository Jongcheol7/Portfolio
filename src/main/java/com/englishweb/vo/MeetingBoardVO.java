package com.englishweb.vo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MeetingBoardVO {
	
	private String id;
	private Long boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
	private String userId;
	private List<MultipartFile> meetingFile;
	private String fileNamesUUID;
	private String meetingFileNames;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Long boardNo) {
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
	public List<MultipartFile> getMeetingFile() {
		return meetingFile;
	}
	public void setMeetingFile(List<MultipartFile> meetingFile) {
		this.meetingFile = meetingFile;
	}
	public String getMeetingFileNames() {
		return meetingFileNames;
	}
	public void setMeetingFileNames(String meetingFileNames) {
		this.meetingFileNames = meetingFileNames;
	}
	public String getFileNamesUUID() {
		return fileNamesUUID;
	}
	public void setFileNamesUUID(String fileNamesUUID) {
		this.fileNamesUUID = fileNamesUUID;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "MeetingBoardVO [id=" + id + ", boardNo=" + boardNo + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", meetingFile="
				+ meetingFile + ", fileNamesUUID=" + fileNamesUUID + ", meetingFileNames=" + meetingFileNames + "]";
	}
	
	

	

	
	

}
