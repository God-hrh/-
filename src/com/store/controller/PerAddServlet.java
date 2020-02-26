package com.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.SysPermission;
import com.store.service.PermissionService;
import com.store.service.PermissionServiceImpl;

/**
 * Servlet implementation class PerAddServlet
 */
@WebServlet("/PerAddServlet")
public class PerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("permission_name");
		String type = request.getParameter("permission_type");
		String url = request.getParameter("permission_url");
		String sort = request.getParameter("permission_sort");
		
		SysPermission sysPermission = new SysPermission();
		sysPermission.setName(name);
		sysPermission.setType(type);
		sysPermission.setUrl(url);
		sysPermission.setSortstring(sort);
		
		PermissionService p = new PermissionServiceImpl();
		p.addSysPermission(sysPermission);
		
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
