package com.store.service;

import java.util.List;

import com.store.dao.EquipmentDao;
import com.store.dao.EquipmentDaoImpl;
import com.store.pojo.Equipment;

public class EquipmentServiceImpl  implements  EquipmentService{

	//依赖属性 
	EquipmentDao  equipmentDao=new EquipmentDaoImpl();
	
	@Override
	public boolean addEquipment(Equipment equipment) {
		
		return equipmentDao.addEquipment(equipment);
	}

	@Override
	public boolean updateEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		return equipmentDao.updateEquipment(equipment);
	}

	@Override
	public boolean delEquipment(int id) {
		// TODO Auto-generated method stub
		return equipmentDao.delEquipment(id);
	}

	@Override
	public List<Equipment> queryAll(int pageSize, int page) {
		// TODO Auto-generated method stub
		return equipmentDao.queryAll(pageSize, page);
	}

	@Override
	public Equipment queryEquipmentById(int id) {
		// TODO Auto-generated method stub
		return equipmentDao.queryEquipmentById(id);
	}

	@Override
	public List<Equipment> queryAll() {
		// TODO Auto-generated method stub
		return equipmentDao.queryAll();
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return equipmentDao.getAllCount();
	}

}
