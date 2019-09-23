package com.offcn.web.filter;

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

import com.offcn.bean.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String uri = req.getRequestURI();//输入
		
		if(uri.equals(req.getContextPath()+"/login.jsp") || uri.equals(req.getContextPath()+"/LoginServlet") || uri.equals(req.getContextPath()+"/CheckCodeServlet")||uri.equals(req.getContextPath()+"/register.jsp") || uri.equals(req.getContextPath()+"/UserRegisterServlet") || uri.equals(req.getContextPath()+"/UserServlet")|| uri.endsWith(".jpg") || uri.endsWith(".js") || uri.endsWith(".css")){
			
			chain.doFilter(req, resp);
		}else{
			HttpSession session =req.getSession();
			User user = (User)session.getAttribute("user");
			
			if(user!=null){
				
				chain.doFilter(req, resp);
			}else{
				resp.sendRedirect("login.jsp?msg=pleaselogin");
			}
			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
