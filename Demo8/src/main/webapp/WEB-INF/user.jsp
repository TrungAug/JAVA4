<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<form action="user" method="post">
		<input name="name" placeholder="Name" required>
		<button>Add</button>
	</form>

	<div>
		<ul>
			<c:forEach items="${list}" var="item">
				<li>${item.id} <span>-</span>  ${item.name }</li>
			</c:forEach>
		</ul>

	</div>
</body>
</html>