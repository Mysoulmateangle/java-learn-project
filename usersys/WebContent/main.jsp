<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.zhou.bean.user"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>欢迎 <%=request.getParameter("username") %></h3>
		
		<table border="1">

			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>手机</th>
				
			</tr>
			<%
				//获取转发过来的 list<employee>
			List<user> list=(List<user>)request.getAttribute("list");
				if(list!=null){
			   for(user user:list){
					
			%>


			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getUsername()%></td>
				<td><%=user.getAge()%></td>
				<td><%=user.getSex()%></td>
				
				
			</tr>
			<%
				}
				}
			%>


		</table>
	</div>
</body>
</html>