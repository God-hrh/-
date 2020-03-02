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

import com.store.pojo.Page;
import com.store.pojo.Repair;
import com.store.pojo.SysUser;
import com.store.service.RepairService;
import com.store.service.RepairServiceImpl;

/**
 * Servlet implementation class BuildingIndexServlet
 */
@WebServlet("/maintainIndex")
public class MaintainIndexServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建一个分页对象
		Page page = new Page();
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null) {
			page.setPageNo(Integer.parseInt(pageNo));
		}

		// 查询所有的区域信息 ，显示到页面中
		// 服务层的实现类对象
		RepairService rs = new RepairServiceImpl();
		// 定义pageSize 和page

		// 调度的查询需要一个参数 维修单的状态是 受理中 stauts的值 为 1

		// 我们传递一个查询的参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", 1);
		// 从session中获取登陆用户对象
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		params.put("assignid", user.getId());
		List<Repair> list = rs.queryAll(page.getPageSize(), page.getPageNo(), params);
		page.setAllCount(rs.getAllCount(params));
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("page/maintain/list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
