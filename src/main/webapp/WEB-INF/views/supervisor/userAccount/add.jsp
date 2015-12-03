<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
</head>
<body>
 	<form:form modelAttribute="userAccountValid" action="/userAccount/save" method="post"> 
 		<form:errors path="*" ></form:errors>
		<table >
			<tr >
				<td >
					账号：
                </td>
				<td >
					<form:input path="username"/>
					<form:errors path="username" />
                </td>
            </tr>
			<tr >
				<td >
					昵称：
                </td>
				<td >
					<form:input path="nickname"/>
					<form:errors path="nickname" />
                </td>
            </tr>
			<tr >
				<td >
					手机：
                </td>
				<td >
					<form:input path="mobile"/>
					<form:errors path="mobile" />
                </td>
            </tr>
            <tr >
				<td >
					密码：
                </td>
				<td >
					<form:input path="plainPassword"/>
					<form:errors path="plainPassword" />
                </td>
            </tr>
			<tr >
				<td colspan="2">
					<input type="submit" value="提交" />
                </td>
            </tr>
        </table>
   </form:form>
</body>
</html>