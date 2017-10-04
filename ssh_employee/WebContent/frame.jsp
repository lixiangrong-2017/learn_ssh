<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
</head>
<frameset rows="90,*" framespacing="0px" frameborder="no">
	<frame name="top" src="<%=basePath%>frame/top.jsp" scrolling="yes">
	<frameset id="main" cols="150,*" framespacing="0px" frameborder="no">
		<frameset row="30,*,40" framespacing="0px" frameborder="no">
			<frame src="<%=basePath%>frame/left.jsp"> 
		</frameset>
	<frame name="right" src="<%=basePath%>frame/right.jsp">
	</frameset>
</frameset>
</html>