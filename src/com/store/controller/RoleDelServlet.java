package com.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.Building;
import com.store.service.BuildingService;
import com.store.service.BuildingServiceImpl;
import com.store.service.RoleService;
import com.store.service.RoleServiceImpl;

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/roleDel")
public class RoleDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//添加 Servelt
		//获取到参数中的 id
		String sid=request.getParameter("id");
		RoleService  bs=new RoleServiceImpl();
		//调用删除的方法
		bs.delSysRole(sid);
		response.sendRedirect("roleIndex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
