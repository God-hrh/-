package com.store.service;

import java.util.List;

import com.store.dao.PermissionDao;
import com.store.dao.PermissionDaoImpl;
import com.store.pojo.SysPermission;

public class PermissionServiceImpl implements PermissionService {

	
	//依赖属性    
	
	private PermissionDao  permissionDao=new PermissionDaoImpl();
	@Override
	public List<SysPermission> queryAllByRoleId(String roleid) {
		return permissionDao.queryAllByRoleId(roleid);
	}

	@Override
	public List<SysPermission> queryAllByUserId(String userid) {
		return permissionDao.queryAllByUserId(userid);
	}

	@Override
	public boolean addSysPermission(SysPermission permission) {
		return permissionDao.addSysPermission(permission);
	}

	@Override
	public boolean updateSysPermission(SysPermission permission) {
		return permissionDao.updateSysPermission(permission);
	}

	@Override
	public boolean delSysPermission(int id) {
		return permissionDao.delSysPermission(id);
	}

	@Override
	public List<SysPermission> queryAll(int pageSize, int page) {
		return permissionDao.queryAll(pageSize, page);
	}

	@Override
	public SysPermission querySysPermissionById(int id) {
		return permissionDao.querySysPermissionById(id);
	}

	@Override
	public List<SysPermission> queryAll() {
		return permissionDao.queryAll();
	}

	@Override
	public int getAllCount() {
		return permissionDao.getAllCount();
	}

}
