package com.store.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.service.EquipmentService;
import com.store.service.EquipmentServiceImpl;

/**
 * Servlet implementation class DelEquipmentServlet
 */
@WebServlet("/DelEquipmentServlet")
public class EquipmentDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		EquipmentService equipmentService = new EquipmentServiceImpl();
		equipmentService.delEquipment(Integer.parseInt(id));
		response.sendRedirect("EquipmentServlet");


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
