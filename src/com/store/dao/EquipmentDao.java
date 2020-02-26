package com.store.dao;

import java.util.List;

import com.store.pojo.Building;
import com.store.pojo.Equipment;



public interface EquipmentDao {

    public List<Equipment> queryAll(int pageNo,int pageSize); 
    public List<Equipment> queryAll();
	public  boolean   addEquipment(Equipment equipment);
	
	public  boolean   updateEquipment(Equipment equipment);
	
	public  boolean   delEquipment(int id);
	
	public  Equipment      queryEquipmentById(int id);
	
	public  int     getAllCount();
	
}

