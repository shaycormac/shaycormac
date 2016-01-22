<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢饮光临！！</h1>
<%
String value=request.getParameter("username");
String value1= new String(value.getBytes("ISO-8859-1"),"utf-8");
String value2=request.getParameter("pass");
System.out.println(value+"=="+value2);
%>
<h2><%=value %></h2>
<h2><%=value2 %></h2>
</body>
</html>