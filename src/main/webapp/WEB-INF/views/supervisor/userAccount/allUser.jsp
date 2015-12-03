<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户</title>
</head>
<body>
<div title="首页" data-options="iconCls:'icon-pencil',closable:true" style="padding:10px">
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
		<c:forEach var="u" items="${all }">
			<tr><td>${u.id }</td><td>${u.username }</td><td>${u.nickname }</td><td>${u.mobile }</td></tr>
		</c:forEach>
    </tbody>
</table>
</div>
</body>
</html>