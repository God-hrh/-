package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.store.pojo.Building;
import com.store.pojo.Equipment;
import com.store.pojo.SysUser;
import com.store.util.DBUtil;

public class UserDaoImpl  implements  UserDao {
	private   Connection         conn;
	private   PreparedStatement  stmt;
	private   ResultSet          rs;
	@Override
	public SysUser getUserByCode(String code) {
		SysUser  user=null;
		conn=DBUtil.getConnection();
		String sql="select id,usercode,username,userpwd  from sys_user where usercode=?";
		try {
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, code);
			
			rs=stmt.executeQuery();
			if(rs.next()) {
				user=new SysUser();
				user.setId(rs.getString("id"));
				user.setUserCode(rs.getString("usercode"));
				user.setUserName(rs.getString("username"));
				user.setUserPwd(rs.getString("userpwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return user;
	}

	@Override
	public boolean addSysUser(SysUser user) {
		String sql="insert into sys_user (id,usercode,username,userpwd) values (?,?,?,?)";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getUserCode());
			stmt.setString(3, user.getUserName());
			stmt.setString(4, user.getUserPwd());
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
	public boolean updateSysUser(SysUser user) {
		List<String>  list=new ArrayList<>(); 
		String  sql="update sys_user   set  usercode=?, username=? ";
		list.add(user.getUserCode());
		list.add(user.getUserName());
		if(user.getUserPwd()!=null && !user.getUserPwd().equals("")) {
			sql+=",userpwd=?";
			list.add(user.getUserPwd());
		}
		sql+="where id=?";
		list.add(user.getId());
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			for (int i=0;i<list.size();i++) {
				stmt.setString(i+1, list.get(i));
			}
		  return 	stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return false;
	}

	@Override
	public boolean delSysUser(String id) {
		String sql="delete  from sys_user where id=?";
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
	public List<SysUser> queryAll(int page, int pageSize) {
	
		List<SysUser> list=new ArrayList<SysUser>();
		String sql="select id,usercode,username,userpwd,locked from sys_user limit ?,?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, (page-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysUser u=new SysUser();
				u.setId(rs.getString("id"));
				u.setUserName(rs.getString("username"));
				u.setUserCode(rs.getString("usercode"));
				u.setUserPwd(rs.getString("userpwd"));
				u.setLocked(rs.getInt("locked"));
				list.add(u);
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
	public SysUser querySysUserById(String id) {
		String sql="select id,usercode,username,userpwd,locked from sys_user where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			if(rs.next()) {
				SysUser u=new SysUser();
				u.setId(rs.getString("id"));
				u.setUserName(rs.getString("username"));
				u.setUserCode(rs.getString("usercode"));
				u.setUserPwd(rs.getString("userpwd"));
				u.setLocked(rs.getInt("locked"));
				return u;
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
	public SysUser querySysUserIDByName(String name) {
		String sql="select id,usercode,userpwd,locked from sys_user where username=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next()) {
				SysUser u=new SysUser();
				u.setId(rs.getString("id"));
				u.setUserCode(rs.getString("usercode"));
				u.setUserPwd(rs.getString("userpwd"));
				u.setLocked(rs.getInt("locked"));
				return u;
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
	public List<SysUser> queryAll() {
		return null;
	}

	@Override
	public int getAllCount() {
		
			// TODO Auto-generated method stub
			String sql="select count(id) from sys_user";
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
	@Override
	public List<SysUser> getUsersByRoleId(String RoleId) {
		List<SysUser> list=new ArrayList<SysUser>();
		String sql="select id,usercode,username,userpwd,locked from sys_user where id in(select sys_user_id from sys_user_role where sys_role_id=?)";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, RoleId);
			rs=stmt.executeQuery();
			while(rs.next()) {
				SysUser u=new SysUser();
				u.setId(rs.getString("id"));
				u.setUserName(rs.getString("username"));
				u.setUserCode(rs.getString("usercode"));
				u.setUserPwd(rs.getString("userpwd"));
				u.setLocked(rs.getInt("locked"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return list;
	}
}
