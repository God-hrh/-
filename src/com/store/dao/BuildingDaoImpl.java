package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.pojo.Building;
import com.store.util.DBUtil;

public class BuildingDaoImpl  implements BuildingDao {
	private   Connection         conn;
	private   PreparedStatement  stmt;
	private   ResultSet          rs;
	@Override
	public boolean addBuilding(Building building) {
		String sql="insert into building (buildingName) values (?)";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, building.getBuildingName());
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
	public boolean updateBuilding(Building building) {
		String sql="update  building set buildingName=? where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, building.getBuildingName());
			stmt.setInt(2, building.getId());
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
	public boolean delBuilding(int id) {
		String sql="update  building set del=1 where id=?";
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
	public List<Building> queryAll(int pageSize, int page) {
		List<Building> list=new ArrayList<Building>();
		String sql="select id,buildingName,del from building where del=0 limit ?,?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, (page-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Building b=new Building();
				b.setId(rs.getInt("id"));
				b.setBuildingName(rs.getString("buildingName"));
				b.setDel(rs.getInt("del"));
				list.add(b);
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
	public Building queryBuildingById(int id) {
		String sql="select id,buildingName,del from building where del=0  and id=? ";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs=stmt.executeQuery();
			if(rs.next()) {
				Building b=new Building();
				b.setId(rs.getInt("id"));
				b.setBuildingName(rs.getString("buildingName"));
				b.setDel(rs.getInt("del"));
				return b;
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
	public List<Building> queryAll() {
		List<Building> list=new ArrayList<Building>();
		String sql="select id,buildingName,del from building where del=0 ";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Building b=new Building();
				b.setId(rs.getInt("id"));
				b.setBuildingName(rs.getString("buildingName"));
				b.setDel(rs.getInt("del"));
				list.add(b);
				
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
	String sql="select count(id) from building where del=0";
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
