<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<c:if test="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION!=null}">
	<h3><font color="red">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</font></h3>
</c:if>
<form action="/supervisor/login" method="POST">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<table>
		<thead>
			<tr><th>账号</th><th>密码</th><th>&nbsp;</th></tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" name="username" value="admin"/></td>
				<td><input type="password" name="password" value="123456"/></td>
				<td><input type="submit" value="登录"/></td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>