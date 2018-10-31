<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var flag = false;
	window.onload = function(){
		var username = document.getElementById("username");		
		username.onblur = function(){
			
			var xmlHttpRequest = createXmlHttpRequest();
			
			xmlHttpRequest.onreadystatechange = function(){
				if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
					var span = document.getElementById("span");
					var value = xmlHttpRequest.responseText;
					if(value=="1"){
						span.innerHTML = "<font style='color:red'>用户名已经存在!</font>";
					}else{
						span.innerHTML = "<font style='color:green'>恭喜，用户名可用!</font>";
						flag = true;
					}
				}
			}
			xmlHttpRequest.open("GET","UserServlet?action=checkNameExits&username="+username.value,true);
			xmlHttpRequest.send();
			
		}
	}
	/* 
	3.	创建 XMLHttpRequest 对象的语法：
		a)	variable=new XMLHttpRequest();
		b)	老版本的 Internet Explorer （IE5 和 IE6）使用 ActiveX 对象：
		c)	variable=new ActiveXObject("Microsoft.XMLHTTP");

		
	*/
	var xmlHttpRequest;
	function createXmlHttpRequest(){
		if(window.XMLHttpRequest){
			xmlHttpRequest = new XMLHttpRequest();
		}else{
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		return xmlHttpRequest;
	}
	
	function check(){
		return flag;
	}
	
</script>
</head>
<body>
<form action="UserServlet?action=regist" method="post" onsubmit="return check()">
	username:<input type="text" name="username" id="username"/><span id="span"></span><br/>
	password:<input type="password" name="password"/><br/>
	<input type="submit" value="注册"/>
</form>
</body>
</html>