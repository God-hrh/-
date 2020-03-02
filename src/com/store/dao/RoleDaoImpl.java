package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
		String sql="SELECT sys_role.id,sys_role.rolename,sys_role.available FROM sys_user_role,sys_user,sys_role WHERE sys_user.id = sys_user_role.sys_user_id AND sys_role.id = sys_user_role.sys_role_id AND  sys_user.id = ?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, userid);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysRole role=new SysRole();
				role.setId(rs.getString("id"));
				role.setRoleName(rs.getString("rolename"));
				role.setAvailable(rs.getInt("available"));
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
		String id = UUID.randomUUID().toString();
		String sql="insert into sys_role (id,rolename,available) values (?,?,1)";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, role.getRoleName());
            return stmt.executeUpdate()>0;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return false;
	}

	@Override
	public boolean updateSysRole(SysRole role) {
		String sql="update  sys_role set rolename=? where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, role.getRoleName());
			stmt.setString(2, role.getId());
            return stmt.executeUpdate()>0;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return false;
	}

	@Override
	public boolean delSysRole(String id) {
		String sql="update  sys_role set available=0 where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
            return stmt.executeUpdate()>0;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return false;
	}

	@Override
	public List<SysRole> queryAll(int pageSize, int page) {
		List<SysRole> list=new ArrayList<SysRole>();
		String sql="select id,rolename,available from sys_role  limit ?,?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, (page-1)*pageSize);
			stmt.setInt(2,pageSize);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysRole role=new SysRole();
				role.setId(rs.getString("id"));
				role.setRoleName(rs.getString("rolename"));
				role.setAvailable(rs.getInt("available"));
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
	public SysRole querySysRoleById(String id) {
		String sql="select id,rolename,available from sys_role where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysRole role=new SysRole();
				role.setId(rs.getString("id"));
				role.setRoleName(rs.getString("rolename"));
				role.setAvailable(rs.getInt("available"));
				return role;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public List<SysRole> queryAll() {
		List<SysRole> list=new ArrayList<SysRole>();
		String sql="select id,rolename,available from  sys_role where available= '1' ";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysRole role=new SysRole();
				role.setId(rs.getString("id"));
				role.setRoleName(rs.getString("rolename"));
				role.setAvailable(rs.getInt("available"));
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
					String sql="select count(id) from sys_role";
					conn=DBUtil.getConnection();
					try {
						stmt=conn.prepareStatement(sql);
						rs=stmt.executeQuery();
						if(rs.next()) {
							return rs.getInt(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						DBUtil.close(conn, stmt, rs);
					}		
					return 0;
	}

}
