package com.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.Building;
import com.store.pojo.SysRole;
import com.store.service.BuildingService;
import com.store.service.BuildingServiceImpl;
import com.store.service.RoleService;
import com.store.service.RoleServiceImpl;

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/roleUpdate")
public class RoleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		//添加 Servelt
		//获取到用户传入参数  id
		String sid=request.getParameter("id");
		String name=request.getParameter("roleName");
		SysRole  b=new SysRole();
		b.setRoleName(name);
		b.setId(sid);
		RoleService  bs=new RoleServiceImpl();
		//调用修改的方法
	      bs.updateSysRole(b);
	      //页面跳转
	      response.sendRedirect("roleIndex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
