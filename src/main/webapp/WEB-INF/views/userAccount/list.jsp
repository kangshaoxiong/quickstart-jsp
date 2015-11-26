<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/userAccount/list">
	<input type="text" name="qp_username" value="${username }" />
	<input type="hidden" name="qp_sortBy" value="username"/>
	<input type="hidden" name="qp_sortType" value="desc"/>
	
	<input type="submit" value="查询"/>
</form>
<table >
	<thead >
		<tr >
			<th >
				ID
            </th>
			<th >
				账号
            </th>
			<th >
				昵称
            </th>
			<th >
				手机
            </th>
        </tr>
    </thead>
	<tbody >
		<c:forEach var="u" items="${page.result }">
			<tr><td>${u.id }</td><td>${u.username }</td><td>${u.nickname }</td><td>${u.mobile }</td></tr>
		</c:forEach>
    </tbody>
</table>
<!-- 分页 -->
<tags:pagination page="${page}"/>
</body>
</html>