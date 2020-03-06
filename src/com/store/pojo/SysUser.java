package com.store.pojo;

import java.util.List;

public class SysUser {
	
	private  String  id;
	private  String  userCode;
	private  String  userName;
	private  String  userPwd;
	private  String  salt;
	private  int     locked;
	private  String userRole;
	public String toString() {
		return "SysUser [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", userPwd=" + userPwd
				+ ", locked=" + locked + ", userRole=" + userRole + "]";
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public SysUser() {
		super();
	}
	//关系属性     该用户关联的角色对象
	private  SysRole  role;
	//关系属性   权限
		List<SysPermission>  permissionList;
	public List<SysPermission> getPermissionList() {
			return permissionList;
		}
		public void setPermissionList(List<SysPermission> permissionList) {
			this.permissionList = permissionList;
		}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getSalt() {
		return salt;
	}
	public SysUser(String id, String userCode, String userName, String userPwd) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getLocked() {
		return locked;
	}
	public void setLocked(int locked) {
		this.locked = locked;
	}
	
	
	
}
