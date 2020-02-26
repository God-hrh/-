package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.pojo.SysPermission;
import com.store.util.DBUtil;

public class PermissionDaoImpl implements  PermissionDao{
	private   Connection         conn;
	private   PreparedStatement  stmt;
	private   ResultSet          rs;
	@Override
	public List<SysPermission> queryAllByRoleId(String roleid) {
		String sql="SELECT sys_permission.id,sys_permission.`name`,sys_permission.type,sys_permission.url,sys_permission.percode,sys_permission.parentid,sys_permission.parentids,sys_permission.sortstring,sys_permission.available FROM sys_permission  where   id  in ( select sys_permission_id from sys_role_permission  where sys_role_id =?) ORDER BY  sortstring";
		List<SysPermission> list=new ArrayList<SysPermission>();
		conn=DBUtil.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, roleid);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				SysPermission  permission=new SysPermission();
				permission.setId(rs.getInt("id"));
				permission.setName(rs.getString("name"));
				permission.setParentid(rs.getString("parntid"));
				permission.setParentids(rs.getString("parentids"));
				permission.setSortstring(rs.getString("sortstring"));
				permission.setUrl(rs.getString("url"));
				permission.setPercode(rs.getString("percode"));
				permission.setType(rs.getString("type"));
				permission.setAvailable(rs.getString("available"));
				list.add(permission);
				
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
	public List<SysPermission> queryAllByUserId(String userid) {
String sql="SELECT sys_permission.id,sys_permission.`name`,sys_permission.type,sys_permission.url,sys_permission.percode,sys_permission.parentid,sys_permission.parentids,sys_permission.sortstring,sys_permission.available FROM sys_permission  where   id  in ( select sys_permission_id from sys_role_permission  where sys_role_id in ( select sys_role_id from sys_user_role  where sys_user_id=?)) ORDER BY  sortstring";
		List<SysPermission> list=new ArrayList<SysPermission>();
		conn=DBUtil.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, userid);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				SysPermission  permission=new SysPermission();
				permission.setId(rs.getInt("id"));
				permission.setName(rs.getString("name"));
				permission.setParentid(rs.getString("parentid"));
				permission.setParentids(rs.getString("parentids"));
				permission.setSortstring(rs.getString("sortstring"));
				permission.setUrl(rs.getString("url"));
				permission.setPercode(rs.getString("percode"));
				permission.setType(rs.getString("type"));
				permission.setAvailable(rs.getString("available"));
				list.add(permission);
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
	public boolean addSysPermission(SysPermission permission) {
		// 学生作业
		String sql = "insert into sys_permission(`name`,type,url,parentid,parentids,sortstring,available) values (?,?,?,'1','0/1/',?,'1')";
		conn = DBUtil.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, permission.getName());
			stmt.setString(2, permission.getType());
			stmt.setString(3, permission.getUrl());
			stmt.setString(4, permission.getSortstring());
			return stmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateSysPermission(SysPermission permission) {
		//  学生作业
		String sql="update  sys_permission set name=?,type=?,url=?,sortstring=? where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, permission.getName());
			stmt.setString(2, permission.getType());
			stmt.setString(3, permission.getUrl());
			stmt.setString(4, permission.getSortstring());	
			stmt.setInt(5, permission.getId());
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
	public boolean delSysPermission(int id) {
		// 学生作业
		String sql="delete from sys_permission where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
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
	public List<SysPermission> queryAll(int pageSize, int page) {
		
		
		String sql="SELECT id,`name`,type,url,percode,parentid,parentids,sortstring,available FROM sys_permission limit ?,?";
		List<SysPermission> list=new ArrayList<SysPermission>();
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, (page-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysPermission  permission=new SysPermission();
				permission.setId(rs.getInt("id"));
				permission.setName(rs.getString("name"));
				permission.setParentid(rs.getString("parentid"));
				permission.setParentids(rs.getString("parentids"));
				permission.setSortstring(rs.getString("sortstring"));
				permission.setUrl(rs.getString("url"));
				permission.setPercode(rs.getString("percode"));
				permission.setType(rs.getString("type"));
				permission.setAvailable(rs.getString("available"));
				list.add(permission);
				
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
	public SysPermission querySysPermissionById(int id) {
		// 学生作业
		String sql="SELECT id,`name`,type,url,percode,parentid,parentids,sortstring,available FROM sys_permission where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysPermission  permission=new SysPermission();
				permission.setId(rs.getInt("id"));
				permission.setName(rs.getString("name"));
				permission.setParentid(rs.getString("parentid"));
				permission.setParentids(rs.getString("parentids"));
				permission.setSortstring(rs.getString("sortstring"));
				permission.setUrl(rs.getString("url"));
				permission.setPercode(rs.getString("percode"));
				permission.setType(rs.getString("type"));
				permission.setAvailable(rs.getString("available"));
				return permission;
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
	public List<SysPermission> queryAll() {
		// 学生作业
		String sql="SELECT id,`name`,type,url,percode,parentid,parentids,sortstring,available FROM sys_permission ";
		List<SysPermission> list=new ArrayList<SysPermission>();
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
		
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysPermission  permission=new SysPermission();
				permission.setId(rs.getInt("id"));
				permission.setName(rs.getString("name"));
				permission.setParentid(rs.getString("parentid"));
				permission.setParentids(rs.getString("parentids"));
				permission.setSortstring(rs.getString("sortstring"));
				permission.setUrl(rs.getString("url"));
				permission.setPercode(rs.getString("percode"));
				permission.setType(rs.getString("type"));
				permission.setAvailable(rs.getString("available"));
				list.add(permission);
				
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
		// 学生作业
		String sql="select count(id) from sys_permission ";
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
