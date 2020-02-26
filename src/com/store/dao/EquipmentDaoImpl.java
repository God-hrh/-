package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.pojo.Building;
import com.store.pojo.Equipment;
import com.store.util.DBUtil;

public class EquipmentDaoImpl implements EquipmentDao{
	
	private   Connection         conn;
	private   PreparedStatement  stmt;
	private   ResultSet          rs;

	public List<Equipment> queryAll(int page, int pageSize) {
		List<Equipment> list=new ArrayList<Equipment>();
		String sql="select id,equipment_id,equipment_name,equipment_type,"
				+ "createtime,responsible_person,remark,del from equipment where del=0 limit ?,?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, (page-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Equipment e=new Equipment();
				e.setId(rs.getInt("id"));
				e.setEquipment_id(rs.getString("equipment_id"));
				e.setEquipment_name(rs.getString("equipment_name"));
				e.setEquipment_type(rs.getString("equipment_type"));
				e.setCreatetime(rs.getString("createtime"));
				e.setResponsible_person(rs.getString("responsible_person"));
				e.setRemark(rs.getString("remark"));
				e.setDel(rs.getInt("del"));
				list.add(e);
//				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	
	public List<Equipment> queryAll() {
		List<Equipment> list=new ArrayList<Equipment>();
		String sql="select id,equipment_id,equipment_name,equipment_type,\"\r\n" + 
				"+ \"createtime,responsible_person,remark,del from equipment where del=0 ";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			
			rs=stmt.executeQuery();
			while(rs.next()) {
				Equipment e=new Equipment();
				e.setId(rs.getInt("id"));
				e.setEquipment_id(rs.getString("equipment_id"));
				e.setEquipment_name(rs.getString("equipment_name"));
				e.setEquipment_type(rs.getString("equipment_type"));
				e.setCreatetime(rs.getString("createtime"));
				e.setResponsible_person(rs.getString("responsible_person"));
				e.setRemark(rs.getString("remark"));
				e.setDel(rs.getInt("del"));
				list.add(e);
				System.out.println(list);
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
	public boolean addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		String sql="insert into equipment (equipment_id,equipment_name,equipment_type,createtime,responsible_person,remark,del) values (?,?,?,?,?,?,0)";
		conn = DBUtil.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, equipment.getEquipment_id());
			stmt.setString(2, equipment.getEquipment_name());
			stmt.setString(3, equipment.getEquipment_type());
			stmt.setString(4, equipment.getCreatetime());
			stmt.setString(5, equipment.getResponsible_person());
			stmt.setString(6, equipment.getRemark());
			return stmt.executeUpdate()>0;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateEquipment(Equipment equipment) {
	
		String sql = "update equipment set equipment_id=?,equipment_name=?,equipment_type=?,createtime=?,responsible_person=?,remark=? where id=?";
		conn = DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, equipment.getEquipment_id());
			stmt.setString(2, equipment.getEquipment_name());
			stmt.setString(3, equipment.getEquipment_type());
			stmt.setString(4, equipment.getCreatetime());
			stmt.setString(5, equipment.getResponsible_person());
			stmt.setString(6, equipment.getRemark());
			stmt.setInt(7, equipment.getId());
			return stmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delEquipment(int id) {
		String sql="update  equipment set del=1 where id=?";
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
	public Equipment queryEquipmentById(int id) {
		
		String sql="select id,equipment_id,equipment_name,equipment_type,createtime,responsible_person,remark,del from equipment where del=0 and id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Equipment e=new Equipment();
				e.setId(rs.getInt("id"));
				e.setEquipment_id(rs.getString("equipment_id"));
				e.setEquipment_name(rs.getString("equipment_name"));
				e.setEquipment_type(rs.getString("equipment_type"));
				e.setCreatetime(rs.getString("createtime"));
				e.setResponsible_person(rs.getString("responsible_person"));
				e.setRemark(rs.getString("remark"));
				e.setDel(rs.getInt("del"));
				return e;
				
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
	public int getAllCount() {
		// TODO Auto-generated method stub
		String sql="select count(id) from equipment where del=0";
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

