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
<c:url var="url" value="/login"/>
<h3>${param.mess}</h3>
<form action="${url}" method="post">

<label for="UsernameId">Username</label>
<input id="UsernameId" name="username" required><br>

<hr>

<label for="Password">Password</label>
<input type="password" id="Password" name="pasword" required><br>


<button>Login</button>
</form>
</body>
</html>