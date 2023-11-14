<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gửi email</title>
</head>
<body>
<form action="mail" method="post" enctype="multipart/form-data">
	<h1>Gửi Email</h1>
	<mark>${message}</mark>
	From: <input type="email" name="emailFrom">
	<br>
	To: <input type="email" name="emailTo">
	<br>
	Subject: <input type="text" name="subject">
	<br>
	Nội dung email:
	<textarea rows="3" cols="30" name="contentEmail"></textarea>
	
	<hr>
	<button>Send</button>
</form>
</body>
</html>