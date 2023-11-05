<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kết quả đăng ký</title>
</head>
<body>
	<h1>THÔNG TIN ĐĂNG KÝ CỦA BẠN</h1>
	<ul>
		<li>Tên đăng nhập: <b>${param.username}</b></li>
		<li>Mật khẩu: <b>${param.password}</b></li>
		<li>Giới tính: <b>${param.gender}</b></li>
		<li>Tình trạng hôn nhân: <b>${param.married}</b></li>
		<li>Quốc tịch: <b>${param.country}</b></li>
		<li>Ghi chú: <b>${param.notes}</b></li>
		<li>Sở thích:</li>
        <ul>
            <c:forEach items="${paramValues.hobbies}" var="hobby">
                <li><b>${hobby}</b></li>
            </c:forEach>
        </ul>		 
	</ul>
</body>
</html>