<%@page import="jakarta.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Java4</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body>
	<h1>PRODUCT</h1>
	<div class="box-content mt-3">
		<div class="row">
			<c:forEach var="item" items="${itemss}" varStatus="loop">
				<div class="col-lg-3 col-md-4 col-sm-12 mb-3">
					<div class="card d-flex flex-column h-100">
						<form action="detail" method="post">
							<a
								type="button"
								href="${pageContext.request.contextPath}/detail?index=${loop.index}">
								<img src="${item.image}" alt=""
								class="card-img-top img-thumbnail" data-bs-toggle="tooltip"
								data-bs-placement="right">
							</a>
						</form>

						<div class="card-body">
							<h5 class="card-title">${item.name}</h5>

						</div>
						<div class="card-footer d-flex flex-column align-items-center">
							<div class="me-4">
								<span><strike>${item.price}</strike></span> <span> <c:set
										var="newprice" value="${item.price*(1-item.discount)}" /> <fmt:formatNumber
										value="${newprice}" />
								</span>

							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<nav aria-label="Page navigation example" id="paginationF99">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="">First</a></li>
				<li class="page-item"><a class="page-link" href="">Previous</a></li>
				<li class="page-item"><a class="page-link" href="">Next</a></li>
				<li class="page-item"><a class="page-link" href="">Last</a></li>
			</ul>
		</nav>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>