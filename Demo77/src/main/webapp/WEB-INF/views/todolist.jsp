<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<c:set var="uri" value="${pageContext.request.contextPath}"
	scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${uri}/css/bootstrap.min.css" rel="stylesheet">
<script src="${uri}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<form action="${uri}/todo/add" method="post">

		<input name="title" placeholder="Title" required><br>
		<textarea rows="5" cols="5" name="description"
			placeholder="Description"></textarea>
		<br>
		<button>Add</button>

	</form>

	<div>
		<p>Size: ${todo_list==null?0:todo_list.size()}</p>

	</div>
	<div>
		<c:forEach var="item" items="${todo_list}">
			<jsp:include page="_item.jsp">
				<jsp:param value="${item.title}" name="title" />
				<jsp:param value="${item.description}" name="description" />
			</jsp:include>

		</c:forEach>

	</div>
</body>
</html>