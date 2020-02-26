package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.pojo.Building;
import com.store.pojo.SysRole;
import com.store.pojo.SysUser;
import com.store.util.DBUtil;

public class RoleDaoImpl   implements  RoleDao{
	private   Connection         conn;
	private   PreparedStatement  stmt;
	private   ResultSet          rs;
	@Override
	public List<SysRole> queryAllByUserId(String userid) {
		List<SysRole> list=new ArrayList<SysRole>();
		String sql="SELECT sys_role.id,sys_role.rolename,sys_role.available FROM sys_user_role,sys_user,sys_role WHERE sys_user.id = sys_user_role.sys_user_id AND sys_role.id = sys_user_role.sys_role_id AND sys_user.id = ?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, userid);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysRole role=new SysRole();
				role.setId(rs.getString("id"));
				role.setRoleName(rs.getString("rolename"));
				role.setAvailable(rs.getString("available"));
				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return list;
	}

	@Override
	public boolean addSysRole(SysRole role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSysRole(SysRole role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delSysRole(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SysRole> queryAll(int pageSize, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysRole querySysRoleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysRole> queryAll() {
		List<SysRole> list=new ArrayList<SysRole>();
		String sql="select id,rolename,available from sys_role ";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysRole role=new SysRole();
				role.setId(rs.getString("id"));
				role.setRoleName(rs.getString("rolename"));
				role.setAvailable(rs.getString("available"));
				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return list;

	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
