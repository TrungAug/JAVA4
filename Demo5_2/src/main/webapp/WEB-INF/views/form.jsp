<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Radio Form</title>
</head>
<body>
<form action="love" method="post">
	<label>Họ tên:</label>
	<input type="text"  name="fullname"/>
	<br>
	<label>Giới tính:</label>
	<input type="radio"  name="gender" value="Male"/>
	<label>Male</label>
	<input type="radio"  name="gender" value="Female"/>
	<label>Female</label>
	<br>
	<input type="checkbox"  name="married" value="yes"/>
	<label>Đã kết hôn</label>
	<br>
	<label>Sở thích</label>
	<input type="checkbox"  name="hobby" value="RB"/>
	<label>Đọc sách</label>
	<input type="checkbox"  name="hobby" value="PVG"/>
	<label>Chơi game</label>
	<input type="checkbox"  name="hobby" value="LTM"/>
	<label>Nghe nhạc</label>
	<br>
	<button>Xác nhận</button>
</form>
</body>
</html>