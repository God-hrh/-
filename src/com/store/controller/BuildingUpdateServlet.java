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

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/buildingUpdate")
public class BuildingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingUpdateServlet() {
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
		String name=request.getParameter("buildingName");
		Building  b=new Building();
		b.setBuildingName(name);
		b.setId(Integer.parseInt(sid));
		BuildingService  bs=new BuildingServiceImpl();
		//调用修改的方法
	      bs.updateBuilding(b);
	      //页面跳转
	      response.sendRedirect("buildingIndex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
