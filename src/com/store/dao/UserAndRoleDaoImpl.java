package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.store.util.DBUtil;
import com.store.util.MyUUID;

public class UserAndRoleDaoImpl  implements UserAndRoleDao{

	private   Connection         conn;
	private   PreparedStatement  stmt;
	private   ResultSet          rs;
	
	
	@Override
	public void addUserAndRoleTable(String userid, String roleid) {
		String sql="insert  into sys_user_role (id,sys_user_id,sys_role_id) values (?,?,?)";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, MyUUID.getId());
			stmt.setString(2, userid);
			stmt.setString(3, roleid);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
	}

	@Override
	public void delUserAndRoleTable(String userid) {
		String sql="delete  from sys_user_role where sys_user_id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, userid);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
	}

}
