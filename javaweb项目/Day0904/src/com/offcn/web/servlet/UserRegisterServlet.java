package com.offcn.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;
import com.offcn.utils.MyDateConverter;

public class UserRegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String[]> map =request.getParameterMap();
		User user = new User();
		
		MyDateConverter converter = new MyDateConverter();
		ConvertUtils.register(converter, Date.class);
		
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		UserService service = new UserServiceImpl();
		
		int result = service.addUser(user);
		
		if(result!=0){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
	}

}
