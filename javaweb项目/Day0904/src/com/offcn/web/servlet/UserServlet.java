package com.offcn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fun  =request.getParameter("fun");
		if("checkUsername".equals(fun)){
			checkUsername(request,response);
		}
	}
	
	protected void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		UserService service = new UserServiceImpl();
		User user = service.getUserByUsername(username);
		
		if(user==null){
			out.print("yes");
		}else{
			out.print("no");
		}
		out.flush();
		out.close();
		
	}

}
