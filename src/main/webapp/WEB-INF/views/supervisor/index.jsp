<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="PURL" value="${pageContext.request.contextPath}"/> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="${PURL}/static/H-ui/favicon.ico" >
<LINK rel="Shortcut Icon" href="${PURL}/static/H-ui/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${PURL}/static/H-ui/lib/html5.js"></script>
<script type="text/javascript" src="${PURL}/static/H-ui/lib/respond.min.js"></script>
<script type="text/javascript" src="${PURL}/static/H-ui/lib/PIE_IE678.js"></script>
<![endif]-->
<link href="${PURL}/static/H-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${PURL}/static/H-ui/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="${PURL}/static/H-ui/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<link href="${PURL}/static/H-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="${PURL}/static/H-ui/css/style.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>系统后台管理</title>
</head>
<body>
	<%@ include file="/WEB-INF/layouts/supervisorHeader.jsp"%>
	<%@ include file="/WEB-INF/layouts/supervisorMenu.jsp"%>
	<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em></li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display:none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="${PURL}/supervisor/home"></iframe>
			</div>
		</div>
	</section>	
	<%@ include file="/WEB-INF/layouts/supervisorFooter.jsp"%>
</body>
</html>