<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ESTL表达式页面</title>
</head>
<body>
<%
String strings [] = {"a","b","c"};
List list = new ArrayList ();
list.add("a");
pageContext.setAttribute("strings", strings);
pageContext.setAttribute("list", list);

%>

${fn:contains(list,"a") }<br>
${fn:length(strings) }
</body>
</html>