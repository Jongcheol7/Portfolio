package com.englishweb.commons;

public class PageCreator {
	
	private PageVO paging;
	private int beginPage;
	private int endPage;
	private boolean isPrev;
	private boolean isNext;
	private int articleTotalCount;
	private final int displayPageNum = 10;
	
	public void calcPaging() {
		endPage = (int) Math.ceil(paging.getPage() / (double) displayPageNum) * displayPageNum;
		beginPage = endPage - displayPageNum + 1;
		isPrev = (beginPage == 1) ? false : true;
		isNext = (articleTotalCount <= endPage*paging.getCountPerPage()) ? false : true;
		if(!isNext) {
			endPage = (int) Math.ceil(articleTotalCount / (double)paging.getCountPerPage());
		}
	}

	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return isPrev;
	}

	public void setPrev(boolean isPrev) {
		this.isPrev = isPrev;
	}

	public boolean isNext() {
		return isNext;
	}

	public void setNext(boolean isNext) {
		this.isNext = isNext;
	}

	public int getArticleTotalCount() {
		return articleTotalCount;
	}

	public void setArticleTotalCount(int articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		calcPaging();
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	@Override
	public String toString() {
		return "PageCreator [paging=" + paging + ", beginPage=" + beginPage + ", endPage=" + endPage + ", isPrev="
				+ isPrev + ", isNext=" + isNext + ", articleTotalCount=" + articleTotalCount + ", displayPageNum="
				+ displayPageNum + "]";
	}
	
	
	

}
