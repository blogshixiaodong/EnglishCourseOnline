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
public interface EngclassDao {

	/** 
	* 开设班级 
	* @param engclass void
	*/ 
	public abstract void insert(Engclass engclass);

	/**
	 * 
	 * @param teacherId
	 * @return selectEgcListByTchId
	 */
	public abstract List<EngclassDetail> selectEngclassListByTeacherId(Integer teacherId);
	
	
	/** 
	* 查询用户班级信息
	* @param userid
	* @return List<EngclassDetail>
	*/ 
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
	
}
