<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jquery.validate.css">
<script src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js" ></script>
<script src="js/add_methods.js"></script>
<script src="js/message_cn.js"></script>
<script>
   function checkusername(){
	   var username = $('#username').val();
	   $.get('${pageContext.request.contextPath}/UserServlet',{"fun":"checkUsername","username":username},function(data){
		 
		   if(data=='yes'){
			   $('#usernamespan').css('color','green');
			   $('#usernamespan').html('√ 用户名可用');
		   }else{
			   $('#usernamespan').css('color','red');
			   $('#usernamespan').html('× 用户名被占用');
		   }
		   
	   });
	   
   }
</script>
<script>
            var result;
			$(function(){
				result = $('#myForm').validate({
					//指定验证规则
					rules:{
						username:{
							required:true,
							//maxlength:10,
							//minlength:6
							rangelength:[6,10]
						},
						
						password:{
							required:true,
							maxlength:10,
							minlength:6
						},
						repassword:{
							equalTo:"#password"
						},
						name:{
							required:true
						},
						email:{
							email:true
						}
						
					},
					
                     //提示信息展示的位置
					 errorPlacement:function(error,element){
                        error.appendTo(element.parent());
                     }
				});
				
			});
			
			
			function subForm(){
				if(result.form()){
					return true;
				}
				return false;
			}
</script>
</head>
<body>
		 <h1>注册用户</h1>
	  <form action="${pageContext.request.contextPath }/UserRegisterServlet" method="post" id="myForm">
	  
		 <table align="center">
		 	<tr>
		 	  <td>用户名：</td>
		 	  <td>
		 	  	<input type="text" name="username" id="username" onblur="checkusername()"  /><span id="usernamespan"></span>
		 	  </td>
		 	</tr>
		 	<tr>
		 	  <td>密码：</td>
		 	  <td>
		 	  	<input type="password" name="password" id="password"  />
		 	  </td>
		 	</tr>
		 	<tr>
		 	  <td>确认密码：</td>
		 	  <td>
		 	  	<input type="password" name="repassword" id="repassword"  />
		 	  </td>
		 	</tr>
		 	<tr>
		 	  <td>姓名：</td>
		 	  <td>
		 	  	<input type="text" name="name" id="name"  />
		 	  </td>
		 	</tr>
		 	<tr>
		 	  <td>性别：</td>
		 	  <td>
		 	  	<input type="radio" value="男" name="sex"  checked/>男
		 	  	<input type="radio" value="女" name="sex"  />女
		 	  </td>
		 	</tr>
		 	<tr>
		 	  <td>email：</td>
		 	  <td>
		 	  	<input type="text" name="email" id="email"  />
		 	  </td>
		 	</tr>
		 	<tr>
		 	  <td>出生日期：</td>
		 	  <td>
		 	  	<input type="text" name="birthday" id="birthday" onfocus="WdatePicker({maxDate:'new Date()',dateFmt:'yyyy-MM-dd'})" class="Wdate" readonly  />
		 	  </td>
		 	</tr>
		 	<tr>
		 	  <td>
		 	  	<input type="submit" value=" 提交 " onclick="return subForm()"  />
		 	  	<input type="reset" value=" 重填 "  />
		 	  </td>
		 	</tr>
		 </table>
	  </form>	 
	</body>
</html>