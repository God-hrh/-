package com.store.service;

import java.util.List;

import com.store.pojo.SysPermission;

public interface PermissionService {

	/**
	 * 通过角色id查询该角色所有全新的方法
	 * @param roleid
	 * @return
	 */
	public  List<SysPermission>  queryAllByRoleId(String  roleid);
	
	
	
	
     /**
      * 通过用户的id查询该用户权限的方法
      * @param userid
      * @return
      */
	public  List<SysPermission>  queryAllByUserId(String  userid);
	

	
	/**
	 * 添加权限的方法
	 * @param SysPermission
	 * @return 是否添加成功
	 */
	public  boolean   addSysPermission(SysPermission permission);
	/**
	 * 更新权限的方法
	 * @param SysPermission
	 * @return 是否更新成功
	 */
	public  boolean   updateSysPermission(SysPermission permission);
	/**
	 * 删除权限的方法
	 * @param id
	 * @return 是否删除成功
	 */
	public  boolean   delSysPermission(int id);
	/**
	 * 分页查询的方法
	 * @param pageSize
	 * @param page
	 * @return 分页查询到的内容
	 */
	public  List<SysPermission>  queryAll(int pageSize,int page);
	/**
	 * 根据id查询指定的权限对象
	 * @param id
	 * @return 唯一的权限对象
	 */
	public  SysPermission      querySysPermissionById(int id);
	/**
	 * 查询所有的权限信息
	 * @return  包含所有权限信息的集合
	 */
	public  List<SysPermission>  queryAll();
	
	
	/**
	 * 查询一共有多少条记录 
	 * @return  总条数
	 */

	public  int     getAllCount();
	
}
