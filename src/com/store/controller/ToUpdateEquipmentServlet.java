package com.store.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.service.EquipmentService;
import com.store.service.EquipmentServiceImpl;
import com.store.pojo.Equipment;

/**
 * Servlet implementation class ToUpdateEquipmentServlet
 */
@WebServlet("/ToUpdateEquipmentServlet")
public class ToUpdateEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		EquipmentService eService = new EquipmentServiceImpl();
		
		Equipment equipment = eService.queryEquipmentById(id);
		
		request.setAttribute("e", equipment);
		request.getRequestDispatcher("page/equipment/updateequipment.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
