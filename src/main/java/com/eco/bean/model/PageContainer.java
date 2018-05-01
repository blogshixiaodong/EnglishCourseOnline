package com.eco.bean.model;
/*
 * date:   2018年5月1日 上午11:05:02
 * author: Shixiaodong
 */
public class PageContainer {
	
	private Integer pageSize;
	
	private Integer recordCount;
	
	private Integer pageCount;
	
	private Integer currentPageNo;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
		pageCount = recordCount / pageSize;
		if(recordCount % pageSize != 0) {
			pageCount += 1;
		}
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	

	

}
