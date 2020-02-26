package com.store.service;

import java.util.List;
import java.util.Map;

import com.store.pojo.Repair;

/**
 * 
 * @title   RepairServcie.java
 * @author  付军
 * @data    2020年2月25日上午9:19:03
 * @version 1.0
 */
public interface RepairService {

	
	/**
	 * 设备报修的方法
	 * @param Repair
	 * @return 是否报修成功
	 */
	public  boolean   addRepair(Repair repair);
	/**
	 * 更新维修的方法
	 * @param Repair
	 * @return 是否更新成功
	 */
	public  boolean   updateRepair(Repair repair);
	/**
	 * 删除维修的方法
	 * @param id
	 * @return 是否删除成功
	 */
	public  boolean   delRepair(int id);
	/**
	 * 分页查询的方法
	 * @param pageSize
	 * @param page
	 * @return 分页查询到的内容
	 */
	public  List<Repair>  queryAll(int pageSize,int page,Map<String,Object> param);
	/**
	 * 根据id查询指定的维修对象
	 * @param id
	 * @return 唯一的维修对象
	 */
	public  Repair      queryRepairById(int id);
	/**
	 * 查询所有的维修信息
	 * @return  包含所有维修信息的集合
	 */
	public  List<Repair>  queryAll();
	
	
	/**
	 * 查询一共有多少条记录 
	 * @return  总条数
	 */

	public  int     getAllCount(Map<String,Object> param);
	
	
	
}
