<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="com.my.quickstart.base.Page" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
int current =  page.getPageNum();
request.setAttribute("current", current);
%>
<div id="fy" class="fy">
    <div>
		<span><a href="?pageNum=1&${searchParams}">首页</a></span>
		<% if(page.isHasPreviousPage()){ %>
			<span class="fy_on"><a  href="?pageNum=${current-1}&${searchParams}">&lt;</a></span>
		<%}else { %>
			<span class="fy_on disabled"><a  href="#">&lt;</a></span>
		<%} %>
		<c:forEach var="i" items="${page.getNavigatepageNums() }">
            <c:choose>
                <c:when test="${i == current}">
                	<span class="fy_on disabled"><a class="fy_out" href="#">${i}</a></span>
                </c:when>
                <c:otherwise>
                	<span class="fy_on"><a  href="?pageNum=${i}&${searchParams}">${i}</a></span>
                </c:otherwise>
            </c:choose>
        </c:forEach>
		<%if(page.isHasNextPage()){ %>
			<span class="fy_on"><a  href="?pageNum=${current+1}&${searchParams}">&gt;</a></span>
		<%} else{ %>
			<span class="fy_on disabled"><a  href="#">&gt;</a></span>
		<%} %>
		<span><a href="?pageNum=${page.getLastPage()}&${searchParams}">尾页</a></span>
		<span>共${page.getLastPage() }页</span>
		<span>共${page.getTotal() }条记录</span>
		<span>/</span>
		<span>转到：
		<select id="page_to_select" name="type" class="filter_name_two_select"> 
		<c:forEach var="i" items="${page.getNavigatepageNums() }">
            <c:choose>
                <c:when test="${i == current}">
                	<option selected="selected">第${i }页</option> 
                </c:when>
                <c:otherwise>
                	<option value="${i }">第${i }页</option> 
                </c:otherwise>
            </c:choose>
        </c:forEach>
		</select>
		</span>
	</div>			
</div>
<script type="text/javascript">
$(function(){
	$("#page_to_select").change(function(){
		window.location.href="?pageNum="+$(this).val()+"&${searchParams}";
	});
});
</script>


