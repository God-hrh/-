package com.store.pojo;

public class SysRole {
	
	private    String id;
	private    String roleName;
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	private    int available;
	
}
