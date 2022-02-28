package com.englishweb.vo;

import java.util.Date;

public class IdiomBoardVO {
	
	private int boardNo;
	private String writer;
	private String idiom;
	private String content;
	private Date regDate;
	private int viewCnt;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIdiom() {
		return idiom;
	}
	public void setIdiom(String idiom) {
		this.idiom = idiom;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	
}
