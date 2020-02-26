package com.store.service;

import java.util.List;
import java.util.Map;

import com.store.dao.RepairDao;
import com.store.dao.RepairDaoImpl;
import com.store.pojo.Repair;

public class RepairServiceImpl implements RepairService {

	 //依赖属性 
	
	RepairDao  repairDao=new RepairDaoImpl();
	
	@Override
	public boolean addRepair(Repair repair) {
		// TODO Auto-generated method stub
		return repairDao.addRepair(repair);
	}

	@Override
	public boolean updateRepair(Repair repair) {
		// TODO Auto-generated method stub
		return repairDao.updateRepair(repair);
	}

	@Override
	public boolean delRepair(int id) {
		// TODO Auto-generated method stub
		return repairDao.delRepair(id);
	}

	@Override
	public List<Repair> queryAll(int pageSize, int page, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return repairDao.queryAll(pageSize, page, param);
	}

	@Override
	public Repair queryRepairById(int id) {
		// TODO Auto-generated method stub
		return repairDao.queryRepairById(id);
	}

	@Override
	public List<Repair> queryAll() {
		// TODO Auto-generated method stub
		return repairDao.queryAll();
	}

	@Override
	public int getAllCount(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return repairDao.getAllCount(param);
	}

}
