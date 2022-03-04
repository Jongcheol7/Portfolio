package com.englishweb.commons;

public class SearchVO extends PageVO{
	
	private String keyword;
	private String condition;
	
	public SearchVO() {
		this.condition = "title";
		this.keyword = "";
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", condition=" + condition + "]";
	}
	
	

}
