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
@WebServlet("/buildingOne")
public class BuildingOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingOneServlet() {
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
	
		BuildingService  bs=new BuildingServiceImpl();
		//调用添加的方法
		Building  b=bs.queryBuildingById(Integer.parseInt(sid));
		request.setAttribute("building", b);
		request.getRequestDispatcher("/page/building/buildingedit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
