<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
</head>
<body>
	<form action="file" method="post" enctype="multipart/form-data">
		<input type="file" name="upload" />
		<button>Submit</button>
	</form>
</body>
</html>