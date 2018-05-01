package com.eco.dao;

import com.eco.bean.model.PageContainer;

/*
 * date:   2018年4月10日 下午3:28:47
 * author: Shixiaodong
 */
public interface PageDao {
	
	public abstract Boolean isPaging();	
	
	public abstract void beginPaging(PageContainer pageContainer);
	
	public abstract void closePaging();
	
}
