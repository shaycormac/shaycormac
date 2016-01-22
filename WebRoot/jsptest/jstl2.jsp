<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL标签库</title>
</head>

<body>
<%
pageContext.setAttribute("name", "如花");

%>

<c:out value="${name}"></c:out>
<c:out value="<script type='text/javascript'>alert(' 错误！！');</script>" escapeXml="false"></c:out>
<c:out value="hellowolrd" default="unknown"></c:out><br>

<!-- c:set标签 -->
<!--var属性：将value属性计算表达式得到的结果，保存在该变量名称中。
	value属性：指定被计算的表达式。
	scope属性：var属性指定的变量所使用的范围（JSP域范围）。
	target属性：要设置属性的对象。必须是JavaBean对象（对应的属性有setter方法）或者java.util.Map对象。
	property属性：要设置的target对象的属性名称。
 -->
<c:set var="name2" value="小贩" scope="session"></c:set>
<c:out value="${name2}"></c:out>

<jsp:useBean id="person" class="cn.fang.entity.PersonBean" scope="session" ></jsp:useBean>
<c:set target="${person}" property="score" value="99.5"></c:set>
<c:out value="${person.score}"></c:out>



<!-- c:remove标签，用于移除域中特定对象的名称 -->
<%
pageContext.setAttribute("input", "画画");
session.setAttribute("input", "houhou");
request.setAttribute("input", "houhou");
application.setAttribute("input", "houhou");

%>

<c:remove var="input"  />
<c:out value="${input}" default="傻逼了" escapeXml="false" ></c:out>



<!-- c:foreach 迭代重点 -->
<%
List<String> list = new ArrayList<>();
list.add("as");
list.add("af");
list.add("ak");
List<String> list2 = new ArrayList<>();
list2.add("bb");
list2.add("bf");
list2.add("bk");
application.setAttribute("listdd", list);

Map<String,List> map= new HashMap<>();
map.put("1", list);
map.put("2", list2);
request.setAttribute("hahamap", map);
%>

<c:forEach items="${listdd}" var="cc">
${cc}
</c:forEach>
<br>
<c:forEach items="${hahamap}" var="entry">
<!--${entry.key}==${entry.value}<br>  -->

<c:forEach items="${entry.value}" var="hehe"> 
${hehe}<br>

</c:forEach>

</c:forEach>




</body>
</html>