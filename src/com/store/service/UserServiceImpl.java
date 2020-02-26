package com.store.service;

import java.util.List;

import com.store.dao.RoleDao;
import com.store.dao.RoleDaoImpl;
import com.store.dao.UserAndRoleDao;
import com.store.dao.UserAndRoleDaoImpl;
import com.store.dao.UserDao;
import com.store.dao.UserDaoImpl;
import com.store.pojo.SysRole;
import com.store.pojo.SysUser;

public class UserServiceImpl  implements UserService {
	
	//依赖属性  
	UserAndRoleDao  userAndroleDao=new UserAndRoleDaoImpl();
	UserDao  userDao=new  UserDaoImpl();
    RoleDao  roleDao=new RoleDaoImpl();
	
	
	@Override
	public SysUser getUserByCode(String code) {
		// TODO Auto-generated method stub
		return userDao.getUserByCode(code);
	}

	@Override
	public boolean addSysUser(SysUser user) {
		// TODO Auto-generated method stub
		return userDao.addSysUser(user);
	}

	@Override
	public boolean updateSysUser(SysUser user,String roleid) {
		//更新用户的角色 
		userAndroleDao.delUserAndRoleTable(user.getId());
		userAndroleDao.addUserAndRoleTable(user.getId(), roleid);
		return userDao.updateSysUser(user);
	}

	@Override
	public boolean delSysUser(String id) {
		// TODO Auto-generated method stub
		return userDao.delSysUser(id);
	}

	@Override
	public List<SysUser> queryAll(int pageSize, int page) {
		// TODO Auto-generated method stub
		return userDao.queryAll(pageSize,page);
	}

	@Override
	public SysUser querySysUserById(String id) {
		SysUser user=userDao.querySysUserById(id);
		List<SysRole> roleList=roleDao.queryAllByUserId(id);
		if(roleList.size()>0) {
		user.setRole(roleList.get(0));
		}
		return user;
	}

	@Override
	public List<SysUser> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public int getAllCount() {
		return userDao.getAllCount();
	}

	@Override
	public List<SysUser> getUsersByRoleId(String RoleId) {
		// TODO Auto-generated method stub
		return userDao.getUsersByRoleId(RoleId);
	}

}
