package com.store.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.store.pojo.Repair;

import com.store.service.RepairService;
import com.store.service.RepairServiceImpl;


/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/maintainUpdate")
public class MaintainUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Repair  repair=new Repair();
		
		//添加 Servelt
		//获取到用户传入参数  维修单id
		String id=request.getParameter("id");
		//获取到用户传入参数  指派人id
		String repairContent = request.getParameter("repairContent");
	    repair.setId(Integer.parseInt(id));
    	repair.setRepairContent(repairContent);
		
		// 设置 状态更新   更新成1
		repair.setStatus(2);
		// 
		repair.setEndTime("now");
		
		RepairService  rs=new RepairServiceImpl();
		//通过服务器更新数据
		rs.updateRepair(repair);
	      //页面跳转
	      response.sendRedirect("maintainIndex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
