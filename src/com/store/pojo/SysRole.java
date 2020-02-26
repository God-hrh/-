package com.store.pojo;
/**
 * 角色实体类 
 * @author Administrator
 *
 */
public class SysRole {
	
	private    String id;
	private    String roleName;
	private    String available;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
}
