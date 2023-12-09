<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
<style>
.line-clamp-2 {
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	overflow: hidden;
}

#carouselMainSlide img {
	height: 450px;
}

.button_footer {
	/* position: relative; */
	height: 350px;
}
/* .btn_left {
            position: absolute;
            bottom: 1rem;
            left: 1rem;
        }
        .btn_right {
            position: absolute;
            
            bottom: 1rem;
            right: 1rem;
        } */
img {
	height: 240px;
}

.col-lg-4 {
	height: 370px;
}

.card-title {
	overflow: hidden;
	text-overflow: ellipsis;
	/* Để hiển thị dấu ba chấm khi tiêu đề bị cắt ngắn */
	white-space: nowrap;
}

.bean {
	border: red solid 10x;
}

img:hover {
	cursor: pointer;
}
</style>
</head>
<body class="bg-dark " data-bs-theme="dark" >

	<fmt:setBundle basename="layout/message" />
	
 <!--<c:url var="imageUrl" value="/views/assets/images/8.jpg" />  -->



	<%@include file="/WEB-INF/views/component/header.jsp"%> 
 
	<div>
		<jsp:include page="${view}" />
	</div>











	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>