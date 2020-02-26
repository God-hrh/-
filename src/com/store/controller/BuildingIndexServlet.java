package com.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.Building;
import com.store.pojo.Page;
import com.store.service.BuildingService;
import com.store.service.BuildingServiceImpl;

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/buildingIndex")
public class BuildingIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个分页对象 
		Page page=new Page(); 
		String pageNo=request.getParameter("pageNo");
		if(pageNo!=null) {
			page.setPageNo(Integer.parseInt(pageNo));
		}
		
		//查询所有的区域信息  ，显示到页面中 
		  //服务层的实现类对象
		 BuildingService  bs=new BuildingServiceImpl();
		 //定义pageSize 和page
		 List<Building> list= bs.queryAll(page.getPageSize(),page.getPageNo());
		 page.setAllCount(bs.getAllCount());
		 request.setAttribute("list", list);
		 request.setAttribute("page",page);
		 request.getRequestDispatcher("page/building/building.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
