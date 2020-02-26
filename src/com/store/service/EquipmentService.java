package com.store.service;

import java.util.List;

import com.store.pojo.Building;
import com.store.pojo.Equipment;

public interface EquipmentService {
	/**
	 * 添加设备的方法
	 * @param building
	 * @return 是否添加成功
	 */
	public  boolean   addEquipment(Equipment equipment);
	/**
	 * 更新设备的方法
	 * @param building
	 * @return 是否更新成功
	 */
	public  boolean   updateEquipment(Equipment equipment);
	/**
	 * 删除设备的方法
	 * @param id
	 * @return 是否删除成功
	 */
	public  boolean   delEquipment(int id);
	/**
	 * 分页查询的方法
	 * @param pageSize
	 * @param page
	 * @return 分页查询到的内容
	 */
	public  List<Equipment>  queryAll(int pageSize,int page);
	/**
	 * 根据id查询指定的设备对象
	 * @param id
	 * @return 唯一的设备对象
	 */
	public  Equipment      queryEquipmentById(int id);
	/**
	 * 查询所有的设备信息
	 * @return  包含所有设备信息的集合
	 */
	public  List<Equipment>  queryAll();
	
	
	/**
	 * 查询一共有多少条记录 
	 * @return  总条数
	 */

	public  int     getAllCount();
	
}
