<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/static/css/css.css">
<title><sitemesh:title/></title>
<sitemesh:head/>
</head>
<body>
	<%@ include file="/WEB-INF/layouts/frontHeader.jsp"%>
	
		<sitemesh:body/>
	
	<%@ include file="/WEB-INF/layouts/frontFooter.jsp"%>
</body>
</html>