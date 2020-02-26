package com.store.service;

import java.util.List;

import com.store.pojo.Building;

public interface BuildingService {
	/**
	 * 添加区域的方法
	 * @param building
	 * @return 是否添加成功
	 */
	public  boolean   addBuilding(Building building);
	/**
	 * 更新区域的方法
	 * @param building
	 * @return 是否更新成功
	 */
	public  boolean   updateBuilding(Building building);
	/**
	 * 删除区域的方法
	 * @param id
	 * @return 是否删除成功
	 */
	public  boolean   delBuilding(int id);
	/**
	 * 分页查询的方法
	 * @param pageSize
	 * @param page
	 * @return 分页查询到的内容
	 */
	public  List<Building>  queryAll(int pageSize,int page);
	/**
	 * 根据id查询指定的区域对象
	 * @param id
	 * @return 唯一的区域对象
	 */
	public  Building      queryBuildingById(int id);
	/**
	 * 查询所有的区域信息
	 * @return  包含所有区域信息的集合
	 */
	public  List<Building>  queryAll();	
	/**
	 * 查询一共有多少条记录 
	 * @return  总条数
	 */

	public  int     getAllCount();
}
