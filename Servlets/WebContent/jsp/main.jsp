<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>Welcome</title></head>
<body>
	<h3>Welcome</h3>	
	<hr/>
		${user}, hello!
	<hr/>
	
	<table border = "0">
		<tr>
			<td>Пользователь</td>
			<td>Пароль</td>
		</tr>
		<c:forEach items="${user}" var="user">
			<tr>
				<td>${user.userName} }</td>
				<td>${user.passPhrase}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="controller?command=logout">Logout</a>
</body></html>