package com.store.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.naming.java.javaURLContextFactory;

import com.store.dao.RepairDao;
import com.store.dao.RepairDaoImpl;
import com.store.dao.UserDao;
import com.store.dao.UserDaoImpl;
import com.store.pojo.Repair;
import com.store.pojo.SysUser;


/**
 * Servlet implementation class RepairSubmitServlet
 */
@WebServlet("/submit")
@MultipartConfig
public class RepairAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		int equipment_name_id=Integer.parseInt(request.getParameter("equipment_name_id"));
		
		int equipment_building_id=Integer.parseInt(request.getParameter("equipment_building_id"));
		String equipment_content=request.getParameter("equipment_content");
		String equipment_user=request.getParameter("equipment_user");
//		System.out.println("报修人是"+equipment_user);
		//报修图片文件对象
		//String equipment_img=request.getParameter("equipment_img");
		Part part=request.getPart("equipment_img");
		//获取到文件的名字
		String imgName=part.getSubmittedFileName();
//		System.out.println("照片名字"+imgName);
		
		//获取定义unload文件夹的绝对位置   要自定义更改tomcat的相对位置
		String realPath=request.getServletContext().getRealPath("/upload/");
//		System.out.println(realPath);
		
		part.write(realPath+imgName);
		
		
		
		
		UserDao userDao=new UserDaoImpl();
		SysUser sys=new SysUser();
		 sys=userDao.querySysUserIDByName(equipment_user);
		 String userId=sys.getId();

		 Repair repair=new Repair(equipment_building_id,userId,equipment_content,equipment_name_id,imgName);
		 RepairDao repairDao=new RepairDaoImpl();
		if( repairDao.addRepair(repair)) {
			 		response.sendRedirect("repairs");
		}else {
			response.sendRedirect("repairs");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
