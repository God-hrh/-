package com.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.service.PermissionService;
import com.store.service.PermissionServiceImpl;

/**
 * Servlet implementation class PerDelServlet
 */
@WebServlet("/PerDelServlet")
public class PerDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int id = Integer.parseInt(request.getParameter("id"));
		PermissionService pService = new PermissionServiceImpl();

		pService.delSysPermission(id);
		request.getRequestDispatcher("perIndex").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
