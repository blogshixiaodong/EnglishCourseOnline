package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.User;
import com.eco.dao.UserDao;

/*
 * date:   2018年4月20日 下午10:18:16
 * author: Shixiaodong
 */
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {

	@Override
	public List<User> selectUserByEngclassId(Integer engclassId){
		String sql = "SELECT u.userid, username, age, idcard, sex, imgurl " +
				     "FROM user_class uc, user u " + 
				     "WHERE uc.userid = u.userid AND uc.classid = ?";
		return this.queryForList(sql, engclassId);
	}
	
	@Override
	public User selectUserByUserId(int userId){
		String sql = "SELECT * FROM user WHERE userid = ?";
		User user = queryForObject(sql, userId);
		return user;
	}

	@Override
	public List<CourseDetail> selectCoursebyUserId(int userId){
		String sql = "SELECT t4.*,starttime,t3.courserecordid, endtime, closetime, signcount FROM user_class t1 LEFT JOIN engclass t2 ON t1.`classid` = t2.`classid` LEFT JOIN course_record t3\r\n" + 
				"ON t2.`courserecordid` = t3.`courserecordid` LEFT JOIN course t4 ON t3.`courseid` = t4.`courseid`\r\n" + 
				"WHERE t1.`userid` = ?";
		
		List<CourseDetail> CourseDetailList = queryForListEx(sql, CourseDetail.class, userId);
		
		return CourseDetailList;
	}

	@Override
	public boolean isExistUser(int userid) {
		String sql = "SELECT * FROM user WHERE userid = ?";
		User user = queryForObject(sql, userid);
		return user == null;
	}

	@Override
	public List<User> selectUserListByClassId(int classId){
		String sql = "SELECT user.* FROM user,user_class WHERE user.userid = user_class.userid AND user_class.classid = ?";
		List<User> userlist = queryForList(sql, classId); 
		return userlist;
	}	

}
