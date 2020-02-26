package com.store.service;

import java.util.List;

import com.store.dao.RoleDao;
import com.store.dao.RoleDaoImpl;
import com.store.pojo.SysRole;

public class RoleServiceImpl implements RoleService{
	
	private RoleDao  roleDao=new RoleDaoImpl();

	@Override
	public List<SysRole> queryAllByUserId(String userid) {
		// TODO Auto-generated method stub
		return roleDao.queryAllByUserId(userid);
	}

	@Override
	public boolean addSysRole(SysRole role) {
		// TODO Auto-generated method stub
		return roleDao.addSysRole(role);
	}

	@Override
	public boolean updateSysRole(SysRole role) {
		// TODO Auto-generated method stub
		return roleDao.updateSysRole(role);
	}

	@Override
	public boolean delSysRole(int id) {
		// TODO Auto-generated method stub
		return delSysRole(id);
	}

	@Override
	public List<SysRole> queryAll(int pageSize, int page) {
		// TODO Auto-generated method stub
		return roleDao.queryAll(pageSize, page);
	}

	@Override
	public SysRole querySysRoleById(int id) {
		// TODO Auto-generated method stub
		return roleDao.querySysRoleById(id);
	}

	@Override
	public List<SysRole> queryAll() {
		// TODO Auto-generated method stub
		return roleDao.queryAll();
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return roleDao.getAllCount();
	}

}
