package com.store.service;

import java.util.List;

import com.store.pojo.SysRole;

public interface RoleService {


    /**
     * 通过用户的id查询该用户角色的方法
     * @param userid
     * @return
     */
	public  List<SysRole>  queryAllByUserId(String  userid);
	
	
	
	
	/**
	 * 添加角色的方法
	 * @param SysRole
	 * @return 是否添加成功
	 */
	public  boolean   addSysRole(SysRole role);
	/**
	 * 更新角色的方法
	 * @param SysRole
	 * @return 是否更新成功
	 */
	public  boolean   updateSysRole(SysRole role);
	/**
	 * 删除角色的方法
	 * @param id
	 * @return 是否删除成功
	 */
	public  boolean   delSysRole(int id);
	/**
	 * 分页查询的方法
	 * @param pageSize
	 * @param page
	 * @return 分页查询到的内容
	 */
	public  List<SysRole>  queryAll(int pageSize,int page);
	/**
	 * 根据id查询指定的角色对象
	 * @param id
	 * @return 唯一的角色对象
	 */
	public  SysRole      querySysRoleById(int id);
	/**
	 * 查询所有的角色信息
	 * @return  包含所有角色信息的集合
	 */
	public  List<SysRole>  queryAll();
	
	
	/**
	 * 查询一共有多少条记录 
	 * @return  总条数
	 */

	public  int     getAllCount();
	
	
	
	
}
