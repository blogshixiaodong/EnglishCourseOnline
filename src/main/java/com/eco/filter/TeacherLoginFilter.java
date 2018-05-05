package com.eco.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eco.bean.model.Teacher;
import com.eco.bean.model.User;

public class TeacherLoginFilter implements Filter{
	
	
	private String excludedPages;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludedPages =filterConfig.getInitParameter("excludedPages");
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		
		if(request.getServletPath().equals(excludedPages)) {
			chain.doFilter(req, res);
			return;
		}
		
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		if(teacher == null) {
			response.sendRedirect("login.jsp");
		}else {
			chain.doFilter(request,response);
		}
	}
	
	@Override
	public void destroy(){
		
	}
	
	
}
