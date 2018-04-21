package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.model.Engclass;
import com.eco.bean.model.User;
import com.eco.dao.EngclassDao;

/*
 * date:   2018年4月20日 下午10:32:20
 * author: Shixiaodong
 */
public class EngclassDaoImpl extends AbstractBaseDao<Engclass> implements EngclassDao {

	@Override
	public void createEngClass(Engclass engclass) {
		String sql = "INSERT INTO engclass(teacherid,courserecordid,classname,usercount,classroom) VALUES(?,?,?,?,?)";
		this.insert(sql, engclass.getTeacherId(),engclass.getCourseRecordId(),engclass.getClassName(),
					engclass.getUserCount(),engclass.getClassRoom() );
		
	}

	
	
	
	

}
