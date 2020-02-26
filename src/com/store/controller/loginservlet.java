package com.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.dao.UserDao;
import com.store.dao.UserDaoImpl;
import com.store.pojo.SysPermission;
import com.store.pojo.SysRole;
import com.store.pojo.SysUser;
import com.store.service.PermissionService;
import com.store.service.PermissionServiceImpl;
import com.store.service.RoleService;
import com.store.service.RoleServiceImpl;
import com.store.service.UserService;
import com.store.service.UserServiceImpl;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usercode =(request.getParameter("usercode")); 
		String psw = request.getParameter("userpsw");
		String captcha = request.getParameter("captcha");
		UserService  us=new UserServiceImpl();
		RoleService  rs=new RoleServiceImpl();
		PermissionService ps=new PermissionServiceImpl();
		SysUser User = us.getUserByCode(usercode);
		if (!captcha.equals(request.getSession().getAttribute("googleCode"))) {
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/page/login.jsp").forward(request, response);
		}
		if (User!=null) {
			if (User.getUserPwd().equals(psw)) {
				 //第一步  ，获取到该用户的角色信息 
				  //第二步 ，获取到该用户的权限信息 
				  //第三步  ，将用户信息放置到Session中 
				  List<SysRole> roleList=rs.queryAllByUserId(User.getId()); 
				  List<SysPermission> permissionList=ps.queryAllByUserId(User.getId());
				  if(roleList.size()>0) {
					  User.setRole(roleList.get(0));
				  }
				  User.setPermissionList(permissionList);
				  request.getSession().setAttribute("user", User);
			 
				request.getRequestDispatcher("EquipmentServlet").forward(request, response);
			}else {
				request.setAttribute("msg", "密码错误");
				request.getRequestDispatcher("/page/login.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "查无此人！");
			request.getRequestDispatcher("/page/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
