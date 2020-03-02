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
import com.store.pojo.SysUser;
import com.store.service.BuildingService;
import com.store.service.BuildingServiceImpl;
import com.store.service.RepairService;
import com.store.service.RepairServiceImpl;
import com.store.service.UserService;
import com.store.service.UserServiceImpl;

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/dispatchUpdate")
public class DispatchUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Repair  repair=new Repair();
		
		//添加 Servelt
		//获取到用户传入参数  维修单id
		String id=request.getParameter("id");
		//获取到用户传入参数  指派人id
		String assignId=request.getParameter("assignId");
	    repair.setId(Integer.parseInt(id));
    	repair.setAssignId(assignId);
		
		// 设置 状态更新   更新成1
		repair.setStatus(1);
		// accepttime 受理时间需要更新   更新成当前时间 
		repair.setAcceptTime("now");
		
		RepairService  rs=new RepairServiceImpl();
		//通过服务器更新数据
		rs.updateRepair(repair);
	      //页面跳转
	      response.sendRedirect("dispatchIndex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
