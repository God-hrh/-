package com.store.filter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.store.pojo.SysUser;

/**
 * Servlet Filter implementation class login
 */
@WebFilter("/*")
public class loginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		SysUser sysUser =  (SysUser) httpServletRequest.getSession().getAttribute("user");
		String path = httpServletRequest.getServletPath();
		if (path.contains("/img.jpg")||path.contains("/page/login.jsp")||path.contains("/loginservlet")) {
			chain.doFilter(request, response);
		}else {
			if (sysUser==null) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/page/login.jsp");
				return ;
			}else {
				chain.doFilter(request, response);
			}
		}
		// pass the request along the filter chain
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
