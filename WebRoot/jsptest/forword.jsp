<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 转发标签，类似于转发请求 -->
<% System.out.println("forword.jsp页面启动"); %>
<jsp:forward page="include.jsp?flag=xx"></jsp:forward>
<!-- page后面跟着查询字符串，那个页面获得，判断，从而进入相应的欢迎页面或者推出页面 -->
<% System.out.println("forword.jsp页面结束");%>
</body>
</html>