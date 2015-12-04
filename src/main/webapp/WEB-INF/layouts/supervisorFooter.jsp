<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${PURL}/static/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${PURL}/static/H-ui/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="${PURL}/static/H-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="${PURL}/static/H-ui/js/H-ui.admin.js"></script> 
<script type="text/javascript">
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
</script> 