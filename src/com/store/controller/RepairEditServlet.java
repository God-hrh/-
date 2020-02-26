package com.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.dao.RepairDao;
import com.store.dao.RepairDaoImpl;
import com.store.pojo.Building;
import com.store.pojo.Equipment;



@WebServlet("/repairIndex")
public class RepairEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RepairDaoImpl repairDaoImpl=new RepairDaoImpl();	
		List<Building> list =repairDaoImpl.queryAllEquipmentBuilding();
		List<Equipment> list1=repairDaoImpl.queryAllEquipmentName();
		 request.setAttribute("list", list);
		 request.setAttribute("list1", list1);
		request.getRequestDispatcher("/page/repair/add.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
