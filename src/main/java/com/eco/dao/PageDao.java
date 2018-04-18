package com.eco.dao;

import java.util.List;

/*
 * date:   2018年4月10日 下午3:28:47
 * author: Shixiaodong
 */
public interface PageDao<T> {
	
	public default int getPageSize() {
		return 10;
	}
	
	public abstract int getRecordCount();
	
	public abstract List<T> getRecordByPageNo(int currentPage);
	
}
