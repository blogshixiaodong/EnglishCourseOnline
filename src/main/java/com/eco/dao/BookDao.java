package com.eco.dao;

import com.eco.bean.Book;

/*
 * date:   2018年4月10日 下午2:42:58
 * author: Shixiaodong
 */
public interface BookDao extends BaseDao<Book>, PageDao<Book> {
	
	public abstract int getCount();
	
	public abstract int deleteByAge();
	
}
