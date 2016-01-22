<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 	page指令设置的属性只能出现一次，除import属性以外。--%>
<%--	pageEncoding属性：指明当前JSP页面使用的编码格式。pageEncoding属性的值要与JSP页面的真实编码保持一致，所谓真实编码，也就是你在属性里面的设置。否则会出现乱码。 --%>
<%--isErrorPage 指定该页面是否为错误处理页面。如果为true，则该JSP内置Exception对象，可直接使用，否则没有。默认为false --%>
<%-- pageEncoding属性与contentType属性只设置其中一个属性时，另一个属性的默认与设置的相同。如果两个属性都不设置的话，两个属性的默认值都为“ISO-8859-1”。一般情况下，至少设置其中一个。--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--	contentType属性：在JSP页面编译成Servlet文件时，对应response.setContentType()方法。 --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--不要忘记这个功能，自动刷新 <meta http-equiv="refresh" content="3;url=https://www.baidu.com"> -->
<title>标签库</title>
</head>
<body>
<%
String flag = request.getParameter("flag");
String p ="";
if(flag.equals("true"))
{
	p="login.jsp";
	
	}else
	{
	p="logout.jsp";	
	}
%>
<jsp:include page="<%=p %>"></jsp:include>
</body>
</html>