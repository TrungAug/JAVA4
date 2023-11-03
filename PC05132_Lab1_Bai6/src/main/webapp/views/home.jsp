<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello My JSP File</h1>
	<form action="./home" method="post">
		<label>Chieu Dai</label>
		<input type="number" name="chieuDai"/> 
		<label>Chieu Rong</label> 
		<input type="number" name="chieuRong"/>
		<button name="loai" value="chuvi">Chu Vi</button>
		<button name="loai" value="dientich">Dien Tich</button>
	</form>
	<div>
		<p>Dài: ${dai}</p>
		<p>Dài: ${rong}</p>
		<p>Kết quả: ${ketqua}</p>
	</div>
</body>
</html>