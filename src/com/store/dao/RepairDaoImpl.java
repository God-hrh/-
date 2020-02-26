package com.store.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.naming.java.javaURLContextFactory;

import com.store.pojo.Building;
import com.store.pojo.Equipment;
import com.store.pojo.Repair;
import com.store.util.DBUtil;

public class RepairDaoImpl  implements RepairDao {
	private   Connection         conn;
	private   PreparedStatement  stmt;
	private   ResultSet          rs;
	@Override
	public boolean addRepair(Repair repair) {
		String sql="insert into Repair (buildingid,userid,content,equipmentid,imgurl,starttime) values (?,?,?,?,?,now())";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, repair.getBuildingId());
			stmt.setString(2, repair.getUserId());
			stmt.setString(3, repair.getContent());
			stmt.setInt(4, repair.getEquipmentId());
			stmt.setString(5, repair.getImgUrl());
//			java.util.Date utilDate=new java.util.Date();
//			Date sqlDate=new Date(utilDate.getTime());//java.sql.date
//			stmt.setDate(6, sqlDate);
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
	public boolean updateRepair(Repair Repair) {
		String sql="update  Repair set RepairName=? where id=?";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
//			stmt.setString(1, Repair.getRepairName());
			stmt.setInt(2, Repair.getId());
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
	public boolean delRepair(int id) {
		String sql="update  Repair set del=1 where id=?";
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
	public List<Building>  queryAllEquipmentBuilding() {
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
	public Repair queryRepairById(int id) {
		String sql="SELECT `repair`.id,`repair`.buildingid,`repair`.userid,`repair`.content,`repair`.starttime,`repair`.endtime,`repair`.assignid,`repair`.`status`,`repair`.equipmentid,`repair`.imgurl,`repair`.addr,`repair`.accepttime,`repair`.repaircontent,`repair`.repairno,equipment.equipment_name,building.buildingName,sys_user.username,sys2.username assignname FROM `repair` INNER JOIN equipment ON `repair`.equipmentid = equipment.id INNER JOIN building ON `repair`.buildingid = building.id INNER JOIN sys_user ON `repair`.userid = sys_user.id LEFT JOIN sys_user AS sys2 ON `repair`.assignid = sys2.id    where repair.id=? ";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
		    stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs.next()) {
				Repair  repair=new Repair();
				repair.setId(rs.getInt("id"));
				repair.setBuildingId(rs.getInt("buildingid"));
				repair.setUserId(rs.getString("userid"));
				repair.setContent(rs.getString("content"));
				repair.setStartTime(rs.getString("starttime"));
				repair.setEndTime(rs.getString("endtime"));
				repair.setAssignId(rs.getString("assignid"));
				repair.setStatus(rs.getInt("status"));
				repair.setEquipmentId(rs.getInt("equipmentid"));
				repair.setImgUrl(rs.getString("imgurl"));
				repair.setAddr(rs.getString("addr"));
				repair.setAcceptTime(rs.getString("accepttime"));
				repair.setRepairContent(rs.getString("repaircontent"));
				repair.setRepairNo(rs.getString("repairno"));
				repair.setEquipmentName(rs.getString("equipment_name"));
				repair.setUserName(rs.getString("username"));
				repair.setBuildingName(rs.getString("buildingName"));
				repair.setAssignName(rs.getString("assignname"));
				return repair;
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
	public List<Equipment> queryAllEquipmentName() {
		List<Equipment> list=new ArrayList<Equipment>();
		String sql="select id,equipment_id,equipment_name,"
				+ "equipment_type,del from equipment where del=0 ";
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Equipment e =new Equipment();
				e.setId(rs.getInt("id"));
				e.setEquipment_id(String.valueOf(rs.getInt("equipment_id")));
				e.setEquipment_name(rs.getString("equipment_name"));
				e.setEquipment_type(rs.getString("equipment_type"));
				e.setDel(rs.getInt("del"));
				list.add(e);
				
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
	String sql="select count(id) from Repair where del=0";
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
	public List<Repair> queryAll(int pageSize, int page, Map<String, Object> param) {
		String sql="SELECT `repair`.id,`repair`.buildingid,`repair`.userid,`repair`.content,`repair`.starttime,`repair`.endtime,`repair`.assignid,`repair`.`status`,`repair`.equipmentid,`repair`.imgurl,`repair`.addr,`repair`.accepttime,`repair`.repaircontent,`repair`.repairno,equipment.equipment_name,building.buildingName,sys_user.username,sys2.username assignname FROM `repair` INNER JOIN equipment ON `repair`.equipmentid = equipment.id INNER JOIN building ON `repair`.buildingid = building.id INNER JOIN sys_user ON `repair`.userid = sys_user.id LEFT JOIN sys_user AS sys2 ON `repair`.assignid = sys2.id   where 1=1 ";
		List<Repair> list=new ArrayList<Repair>();
		
		//查询界面 增加  自定义 条件查询功能 
		List<Object> params=new ArrayList<Object>();
		
		
		//自定义参数的判断 
		//如果状态的参数不为空 ，怎需要设置条件查询语句
		if(param!=null &&param.get("status")!=null) {
			sql+=" and  status= ?";
			params.add(param.get("status"));
		}
		
		conn=DBUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			
			for(int index=0;index<params.size();index++) {
				stmt.setObject(index+1, params.get(index));
			}
			rs=stmt.executeQuery();
			while(rs.next()) {
				Repair  repair=new Repair();
				repair.setId(rs.getInt("id"));
				repair.setBuildingId(rs.getInt("buildingid"));
				repair.setUserId(rs.getString("userid"));
				repair.setContent(rs.getString("content"));
				repair.setStartTime(rs.getString("starttime"));
				repair.setEndTime(rs.getString("endtime"));
				repair.setAssignId(rs.getString("assignid"));
				repair.setStatus(rs.getInt("status"));
				repair.setEquipmentId(rs.getInt("equipmentid"));
				repair.setImgUrl(rs.getString("imgurl"));
				repair.setAddr(rs.getString("addr"));
				repair.setAcceptTime(rs.getString("accepttime"));
				repair.setRepairContent(rs.getString("repaircontent"));
				repair.setRepairNo(rs.getString("repairno"));
				repair.setEquipmentName(rs.getString("equipment_name"));
				repair.setUserName(rs.getString("username"));
				repair.setBuildingName(rs.getString("buildingName"));
				repair.setAssignName(rs.getString("assignname"));
				list.add(repair);
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
	public List<Repair> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllCount(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
