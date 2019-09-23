<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    
     <c:if test="${param.msg=='checkcodeerror' }">
       <h2 style="color:red">验证码错误</h2>
     </c:if>
   
       <c:if test="${param.msg=='loginerror' }">
       <h2 style="color:red">用户名或密码错误</h2>
     </c:if>
     
     <c:if test="${param.msg=='pleaselogin' }">
       <h2 style="color:red">请登录</h2>
     </c:if>

		<h1 align="center">商城后台管理系统</h1>
		<img src="img/333.jpg" width="100" height="100" />
		<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
			<table align="center">
				<tr>
					<td>用户名：</td>
					<td>
						<input type="text" name="username"  />
					</td>
				</tr>
				
				<tr>
					<td>密码：</td>
					<td>
						<input type="password" name="password"  />
					</td>
				</tr>
				
				<tr>
					<td>验证码：</td>
					<td>
						<table>
							<tr>
								<td><input type="text" size="4" name="checkcode"  /></td>
								<td><img src="${pageContext.request.contextPath}/CheckCodeServlet"  /></td>
							</tr>
							
						</table>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit" value="登录"  />
						<input type="reset" value="重置"  />
					</td>
				</tr>
			</table>
		</form>
		<div align="center">还没有注册？请点击<a href="register.jsp">注册</a></div>
	</body>
</html>
