package com.store.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.pojo.Building;
import com.store.pojo.Page;
import com.store.pojo.Repair;
import com.store.pojo.SysPermission;
import com.store.pojo.SysRole;
import com.store.pojo.SysUser;
import com.store.service.BuildingService;
import com.store.service.BuildingServiceImpl;
import com.store.service.PermissionService;
import com.store.service.PermissionServiceImpl;
import com.store.service.RepairService;
import com.store.service.RepairServiceImpl;
import com.store.service.RoleService;
import com.store.service.RoleServiceImpl;
import com.store.service.UserService;
import com.store.service.UserServiceImpl;

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/repairs")
public class RepairIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**s
     * @see HttpServlet#HttpServlet()
     */
    public RepairIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//创建一个分页对象 
		Page page=new Page(); 
		//查询所有的区域信息  ，显示到页面中 
		  //服务层的实现类对象
		RepairService  rs=new RepairServiceImpl();
		
		
		//获取用户模糊查询的参数  
		
		String equipmentName=request.getParameter("equipmentName");
		String userName=request.getParameter("userName");
		String status=request.getParameter("status");
		
		Map<String,Object> params=new HashMap<String,Object>();
		
		params.put("equipmentName", equipmentName);
		params.put("userName", userName);
		if(status!=null&& !status.equals("all")) {
		params.put("status",Integer.parseInt(status));
		}
		page.setAllCount(rs.getAllCount(params));
		String pageNo=request.getParameter("pageNo");
		if(pageNo!=null && !pageNo.equals("")) {
			page.setPageNo(Integer.parseInt(pageNo));
		}

		 List<Repair> list= rs.queryAll(page.getPageSize(),page.getPageNo(),params);
		 request.setAttribute("list", list);
		 request.setAttribute("params", params);
		 request.setAttribute("page",page);
		 request.getRequestDispatcher("page/repair/list.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
