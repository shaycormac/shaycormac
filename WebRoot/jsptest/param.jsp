<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--这个动作标签与jsp:include标签、jsp:forward标签配合使用，以键值对形式为其他标签提供参数内容。  -->
<jsp:forward page="login.jsp">
<jsp:param value="范" name="username"/>
<jsp:param value="123456" name="pass"/>
</jsp:forward>
</body>
</html>