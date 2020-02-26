package com.store.dao;

import java.util.List;
import java.util.Map;

import com.store.pojo.Building;
import com.store.pojo.Equipment;
import com.store.pojo.Repair;
/**
 * 区域类的  dao层
 * @author Administrator
 *
 */
public interface RepairDao {
	/**
	 * 添加区域的方法
	 * @param Repair
	 * @return 是否添加成功
	 */
	public  boolean   addRepair(Repair Repair);
	/**
	 * 更新区域的方法
	 * @param Repair
	 * @return 是否更新成功
	 */
	public  boolean   updateRepair(Repair Repair);
	/**
	 * 删除区域的方法
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
	 * 根据id查询指定的区域对象
	 * @param id
	 * @return 唯一的区域对象
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
	/**
	 * 查询所有地点
	 * @return
	 */
	public  List<Building>  queryAllEquipmentBuilding();
	
	/**
	 * 查询所有的设备名称
	 * @return  包含所有区域信息的集合
	 */
	public  List<Equipment>  queryAllEquipmentName();
	
	
	/**
	 * 查询一共有多少条记录 
	 * @return  总条数
	 */

	public  int     getAllCount();
	
}
