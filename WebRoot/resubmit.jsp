<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>防止表单重复提交</title>
<script type="text/javascript">

function resubmit() 
{
	//得到表单对象
	var oform =document.getElementsByName("myform")[0];
	oform.submit();
	alert("first");
	//模拟重复提交
	oform.submit();
	alert("second");
	
}

</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/AvoidReSubmitServlet" method="post" name="myform">
请输入：<input type="text" name="username"><br>
<input type="button" onclick="resubmit()" value="提交">


</form>
</body>
</html>