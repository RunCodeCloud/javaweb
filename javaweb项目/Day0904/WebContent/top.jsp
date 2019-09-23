<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
    function logout(){
    	window.parent.location="${pageContext.request.contextPath}/LogoutServlet";
    }
</script>
</head>
<body>
<body>
		<div align="right">
			欢迎，${sessionScope.user.username }
		    <a href="javascript:logout()">退出登录</a>
		</div>
	</body>
</body>
</html>