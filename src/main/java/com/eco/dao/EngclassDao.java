package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;


/*
 * date:   2018年4月20日 下午10:31:04
 * author: Shixiaodong
 */
/**
 * @author 15129
 *
 */
public interface EngclassDao extends PageDao {

	/** 
	* 开设班级 
	* @param engclass void
	*/ 
	public abstract long insert(Engclass engclass);

	/**
	 * 
	 * @param teacherId
	 * @return selectEgcListByTchId
	 */
	public abstract List<EngclassDetail> selectEngclassListByTeacherId(Integer teacherId);
	
	/** 
	* @Description: 查询用户当前正在进行的班级信息 
	* @param userId
	* @return List<EngclassDetail>
	*/ 
	public abstract List<EngclassDetail> selectUserNowEngclassListByUserId(Integer userId);
	

	public List<EngclassDetail> selectUserAllEngclassListByUserId(Integer userid);

	
	/** 
	* 根据班级查询教师id 
	* @param classId
	* @return Integer
	*/ 
	public Integer selectTeacherIdByEngclassId(Integer classId);
	
	
	/**
	 * 根据教师id和班级id查询班级信息
	 * @param teacherId
	 * @param classId
	 * @return
	 */
	public Engclass selectEngclassByTeacherIdAndEngclassId(Integer teacherId, Integer classId);
	 
	/**
	 * 根据教师id和班级名称查询所有符合条件的班级信息列表
	 * @param teacherId
	 * @param className
	 * @return
	 */
	public List<Engclass> selectEngclassListByTeacherIdAndEngclassName(Integer teacherId, String className);
	
	/**根据班级id铲鲟班级的详细信息
	 * @param engclassId
	 * @return
	 */
	public EngclassDetail selectEngclassDetailByEngclassId(Integer engclassId);
	
	
	/** 
	* @Description: 根据用户id获取用户所有的班级记录数
	* @param userId
	* @return int
	*/ 
	public int countAllEngclassDetailByUserId(Integer userId);
	
	
	/** 
	* @Description: 根据教师id获取该教师的班级记录数
	* @param teacherId
	* @return int
	*/ 
	public int countAllEngclassDetailByTeacher(Integer teacherId);
	
	/** 
	* @Description: 通过班级id查询该班级是学生人数 
	* @param engclassId
	* @return int
	*/ 
	public int countAllUserByEngclassId(Integer engclassId);
	
	public List<Engclass> selectEngclassListByCourseId(Integer courseId);
	
	
	public int selectCourseRecordIdByEngclassId(Integer engclassId);
	
	public void updateUserEngclassId(Integer oldEngclassId,Integer engclassId);
	
	
}
