package com.eco.bean.model;

import java.io.Serializable;
import java.util.List;

/*
 * date:   2018年5月1日 上午11:05:02
 * author: Shixiaodong
 */
public class PageContainer<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer pageSize;
	
	private Integer recordCount;
	
	private Integer pageCount;
	
	private Integer currentPageNo;
	
	private List<T> list;

	public Integer getPageSize() {
		if(pageSize == null) {
			pageSize = 5;
		}
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
		pageCount = recordCount / getPageSize();
		if(recordCount % getPageSize() != 0) {
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

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
