package com.offcn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.bean.Category;
import com.offcn.service.CategoryService;
import com.offcn.service.impl.CategoryServiceImpl;

import net.sf.json.JSONArray;

public class CategoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fun = request.getParameter("fun");
		
		if("findall".equals(fun)){
			findall(request,response);
		}
	}
	
	protected void findall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		CategoryService service = new CategoryServiceImpl();
		List<Category> list = service.getAllCategory();
		
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
		
		
		out.flush();
		out.close();
	}

}
