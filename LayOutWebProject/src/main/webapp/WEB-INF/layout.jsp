<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.lang}" scope="session"/>
	<fmt:setBundle basename="layout/message"/>
	<header>

		<nav>
			<a href="<c:url value="/home"/>">
				<fmt:message key="home" />
			</a> 
			<a	href="<c:url value="about" />">
				<fmt:message key="about" />
			</a> 
			<a href="<c:url  value="/contact" />">
				<fmt:message key="contact" />
			</a>
		</nav>
		<ul>
			<li>
				<a href="?lang=en">English</a>
				<a href="?lang=vi">Việt Nam</a>
			</li>
		</ul>
	</header>
	<div>
		<jsp:include page="${view}"/>
	</div>
	<footer>
		<h2>FPT Polytechic</h2>
	</footer>
</body>
</html>