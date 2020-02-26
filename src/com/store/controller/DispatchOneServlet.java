package com.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.Building;
import com.store.pojo.Repair;
import com.store.pojo.SysRole;
import com.store.pojo.SysUser;
import com.store.service.BuildingService;
import com.store.service.BuildingServiceImpl;
import com.store.service.RepairService;
import com.store.service.RepairServiceImpl;
import com.store.service.RoleService;
import com.store.service.RoleServiceImpl;
import com.store.service.UserService;
import com.store.service.UserServiceImpl;

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/dispatchOne")
public class DispatchOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchOneServlet() {
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
		String repairId=request.getParameter("id");
	  
		RepairService  rs=new RepairServiceImpl();
		
		Repair repair =rs.queryRepairById(Integer.parseInt(repairId));
		request.setAttribute("repair", repair);
		//将维修人员角色的所有用户也转递页面中去
		UserService  us=new UserServiceImpl();
		//定义一个角色的id
		String roleId="eb7c9189-61ab-11e9-be1c-507b9dce6747";
		List<SysUser> ulist=us.getUsersByRoleId(roleId);
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("/page/dispatch/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
