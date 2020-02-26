package com.store.service;

import java.util.List;

import com.store.dao.BuildingDao;
import com.store.dao.BuildingDaoImpl;
import com.store.pojo.Building;

public class BuildingServiceImpl  implements BuildingService{


	
	 BuildingDao   buildingDao =new BuildingDaoImpl();
	
	@Override
	public boolean addBuilding(Building building) {
		return buildingDao.addBuilding(building);
	}

	@Override
	public boolean updateBuilding(Building building) {
		return buildingDao.updateBuilding(building);
	}

	@Override
	public boolean delBuilding(int id) {
		// TODO Auto-generated method stub
		return buildingDao.delBuilding(id);
	}

	@Override
	public List<Building> queryAll(int pageSize, int page) {
		return buildingDao.queryAll(pageSize,page);
	}

	@Override
	public Building queryBuildingById(int id) {
		return buildingDao.queryBuildingById(id);
	}

	@Override
	public List<Building> queryAll() {
		return buildingDao.queryAll();
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return buildingDao.getAllCount();
	}

}
