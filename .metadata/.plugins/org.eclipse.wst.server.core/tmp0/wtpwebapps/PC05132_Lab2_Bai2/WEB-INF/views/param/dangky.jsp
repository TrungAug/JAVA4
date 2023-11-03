<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Đăng Ký</title>
</head>
<body>
	<form action="dangky" method="post">
		Tên đăng nhập: <input name="username"><br> Mật khẩu: <input
			name="password" type="password"><br> Giới tính: <input
			name="gender" type="radio" value="true">Nam <input
			name="gender" type="radio" value="false">Nữ<br> <input
			name="married" type="checkbox">Đã có gia đình?<br> Quốc
		tịch: <select name="country">
			<option value="VN">Việt Nam</option>
			<option value="US">United States</option>
		</select><br> Ghi chú:
		<textarea name="notes" rows="3" cols="30"></textarea>
		<hr>
		<button>Đăng ký</button>
	</form>
</body>
</html>