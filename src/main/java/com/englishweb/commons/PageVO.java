package com.englishweb.commons;

public class PageVO {
	
	private int page;
	private int countPerPage;
	private int startArticle;
	
	public PageVO() {
		this.page = 1;
		this.countPerPage = 10;
	}
	

	public int getStartArticle() {
		return startArticle;
	}


	public void setStartArticle(int page) {
		this.startArticle = (page-1) * countPerPage;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", countPerPage=" + countPerPage + "]";
	}
	
	
	
}
