package com.store.service;

import java.util.List;

import com.store.pojo.SysUser;

public interface UserService {

	/**
	 * 根据用户编号获取用户对象信息
	 * @param code  编号
	 * @return  SysUser  用户对象
	 */
	public SysUser   getUserByCode(String code);
	
	
	/**
	 * 添加用户的方法
	 * @param SysUser
	 * @return 是否添加成功
	 */
	public  boolean   addSysUser(SysUser user);
	/**
	 * 更新用户的方法
	 * @param SysUser
	 * @return 是否更新成功
	 */
	public  boolean   updateSysUser(SysUser user ,String roleid);
	/**
	 * 删除用户的方法
	 * @param id
	 * @return 是否删除成功
	 */
	public  boolean   delSysUser(String id);
	/**
	 * 分页查询的方法
	 * @param pageSize
	 * @param page
	 * @return 分页查询到的内容
	 */
	public  List<SysUser>  queryAll(int pageSize,int page);
	/**
	 * 根据id查询指定的用户对象
	 * @param id
	 * @return 唯一的用户对象
	 */
	public  SysUser      querySysUserById(String id);
	/**
	 * 查询所有的用户信息
	 * @return  包含所有用户信息的集合
	 */
	public  List<SysUser>  queryAll();
	
	
	/**
	 * 查询一共有多少条记录 
	 * @return  总条数
	 */

	public  int     getAllCount();
	/**
	 * 通过角色的id查询该角色下的所有用户
	 * @param RoleId
	 * @return  所有的用户列表
	 */
	public List<SysUser>  getUsersByRoleId(String RoleId);

	
}
