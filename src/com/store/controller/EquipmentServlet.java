package com.store.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.Page;

import com.store.service.EquipmentService;
import com.store.service.EquipmentServiceImpl;
import com.store.pojo.Equipment;

/**
 * Servlet implementation class EquipmentServlet
 */
@WebServlet("/EquipmentServlet")
public class EquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Page page=new Page(); 
		String pageNo=request.getParameter("pageNo");
		if(pageNo!=null) {
			page.setPageNo(Integer.parseInt(pageNo));
		}
		
		EquipmentService equipmentService = new EquipmentServiceImpl();
		
		List<Equipment> list =  equipmentService.queryAll(page.getPageNo(),page.getPageSize());
		
		 page.setAllCount(equipmentService.getAllCount());
		request.setAttribute("list", list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("page/equipment/equipment.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
