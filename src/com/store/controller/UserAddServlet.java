package com.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.Building;
import com.store.pojo.SysUser;
import com.store.service.BuildingService;
import com.store.service.BuildingServiceImpl;
import com.store.service.UserService;
import com.store.service.UserServiceImpl;

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/UserAdd")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
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
		String id=request.getParameter("user_id");
		String code=request.getParameter("user_code");
		String name=request.getParameter("user_name");
		String psw=request.getParameter("user_psw");

		SysUser user= new SysUser(id,code,name,psw);
		
		UserService  us=new UserServiceImpl();
		
		//调用添加的方法
		us.addSysUser(user);
		response.sendRedirect("userIndex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
