<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stuying Cookie</title>
</head>
<body>
	<form action="user" method="post">
		<input name="name" placeholder="Name" required> <input
			name="date" placeholder="Date" required>
		<button>Submit</button>
	</form>
	<div>
		<p>User: ${nameIp}</p>
		<p>Date: ${dateIp}</p>
		<p>Cookie: ${cookie_nameShow}</p>
	</div>

</body>
</html>