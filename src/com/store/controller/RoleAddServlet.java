package com.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.SysRole;
import com.store.service.RoleService;
import com.store.service.RoleServiceImpl;

/**
 * Servlet implementation class RoleAddServlet
 */
@WebServlet("/RoleAddServlet")
public class RoleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//添加 Servelt
				//获取到用户输入的名字
				String name=request.getParameter("roleName");

				SysRole  b=new SysRole();
				b.setRoleName(name);
				
				RoleService  bs=new RoleServiceImpl();
				
				//调用添加的方法
				bs.addSysRole(b);
				response.sendRedirect("roleIndex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
