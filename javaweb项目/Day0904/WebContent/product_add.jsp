<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css"  />
<script src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery.js"></script>
<script>
  $(function(){
	  
	  $.getJSON('CategoryServlet',{"fun":"findall"},function(data){
		  
		  var str = "";
		  for(var i=0;i<data.length;i++){
			  str = str+"<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>";
		  }
		  
		  $('#cid').html($('#cid').html()+str);
	  });
	  
  })
</script>
</head>
<body>
	 <div class="formbody">
      <div class="formtitle"><span>商品信息</span></div>
		<form action="ProductServlet" method="post" enctype="multipart/form-data">
	    <ul class="forminfo">
	    	 
	    	 <!-- 商品分类信息 -->
	    	 <li>
	    	 	<label>商品分类</label>
	    	 	<select name="cid" class="dfinput" id="cid">
	    	 		<option value='0'>请选择</option>
	    	 	</select>
	    	 </li>
	    	 
	    	 
		    <li><label>商品名称</label><input name="pname" type="text" class="dfinput" /><i>商品名称不能超过30个字符</i></li>
		    <li><label>颜色</label><input name="color" type="text" class="dfinput" /></li>
		    <li><label>单价</label><input name="price" type="text" class="dfinput" /></li>
		    <li><label>简介</label>
		    	<textarea name="description" cols="10" rows="10" class="textinput" style="height: 80px"></textarea>
		    </li>
		    <li><label>商品展示图</label>
		    	<input name="pic" type="file"/><font style="color: red"></font>
		    </li>
		    <li><label>商品小类别</label>
			    <cite>
				    <input name="state" type="radio" value="0" checked="checked" />正常&nbsp;&nbsp;&nbsp;&nbsp;
				    <input name="state" type="radio" value="1" />热门产品
				    <input name="state" type="radio" value="2" />为你推荐
				    <input name="state" type="radio" value="3" />新品
				    <input name="state" type="radio" value="4" />小米明星单品
			    </cite>
		    </li>
		    <li><label>型号</label><input name="version" type="text" class="dfinput" /></li>
		    
		    <li><label>生产日期</label>
		    	<input class="Wdate dfinput"  style="width: 345px;height: 32px;line-height: 32px;" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" name="product_date" type="text" />
		    </li>
		    
		    <li><label>&nbsp;</label><input type="submit"  value="确认保存"/></li>
	    </ul>
    </form>
	</body>
</html>