<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Manager</title>
</head>
<body>
<c:url var="url" value="/account" />
<form action="${isUpdate? url.concat('/update'): url.concat('/create')}" method="post">
	<label for="accUsername">Username</label>
	<input name="username" id="accUsername"  ${user==null? "":"value=".concat(user.username)} required><br>
	
	<label for="accPassword">Password</label>
	<input type="password" name="password" id="accPassword" ${user==null? "":"value=".concat(user.password)} required><br>
	
	<label for="accFullname">Fullname</label>
	<input  name="fullname" id="accFullname" ${user==null? "":"value=".concat(user.fullname)} required><br>
	
	<label for="accAdmin">Admin</label>
	<input type="checkbox" name="admin" id="accAdmin" ${user==null&&user.admin?"checked":""} ><br>
	<button>${isUpdate? "Update":"Create"}</button>
</form>

<table border="1">
<tr>
	<th>User Name</th>
	<th>Full Name</th>
	<th>Created Date</th>
	<th>Admin</th>
	<th></th>
</tr>
<c:forEach var="user" items="${userList }">
<tr>
	<td>${user.username}</td>
	<td>${user.fullname}</td>
	<td>${user.createDate}</td>
	<td>${user.admin}</td>
	<td>
		<a href="${url}/delete?username=${user.username}">Delete</a>
		<a href="${url}/update?username=${user.username}">Update</a>
	</td>
</tr>

</c:forEach>

</table>


</body>
</html>