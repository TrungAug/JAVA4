<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="url" value="/user" />
	<form action="${url}/favorites" method="post">
		<input name="videoId" placeholder="Video ID" required>
		<button>Search</button>

	</form>


	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Admin</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password }</td>
				<td>${user.email}</td>
				<td>${user.admin?"Admin":"User" }</td>
			</tr>
		</c:forEach>


	</table>


</body>
</html>