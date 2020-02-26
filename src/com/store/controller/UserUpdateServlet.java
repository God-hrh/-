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
@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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
		String id=request.getParameter("id");
		String name=request.getParameter("userName");
		String code=request.getParameter("userCode");
		String pwd=request.getParameter("userPwd");
		String roleid=request.getParameter("roleid");
		
		SysUser  user=new SysUser();
		user.setId(id);
		user.setUserName(name);
		user.setUserPwd(pwd);
		user.setUserCode(code);
		UserService  us=new UserServiceImpl();
		us.updateSysUser(user, roleid);
	      //页面跳转
	      response.sendRedirect("userIndex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
