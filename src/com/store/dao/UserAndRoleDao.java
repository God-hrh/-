package com.store.dao;

public interface UserAndRoleDao {

	
	/**
	 * 添加中间表的信息 
	 * @param userid
	 * @param roleid
	 */
	public  void   addUserAndRoleTable(String userid,String roleid);
	

	/**
	 * 删除中间表的信息 
	 * @param userid
	 * @param roleid
	 */
	public  void   delUserAndRoleTable(String userid);
	
	
}
