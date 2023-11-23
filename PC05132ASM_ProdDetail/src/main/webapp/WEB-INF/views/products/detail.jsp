<%@page import="jakarta.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="java.util.List"%>
<%@ page import="pc05132.lab4.bai4.entity.Item"%>

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
	<h1><span>Detail of: </span> ${i.name}</h1>
	<div class="box-content mt-3">

		<div class="row">
			
				<div class="col-lg-3 col-md-4 col-sm-12 mb-3">
					<div class="card d-flex flex-column h-100">
						<a href="#"> <img src="${i.image}" alt=""
							class="card-img-top img-thumbnail" data-bs-toggle="tooltip"
							data-bs-placement="right">
						</a>
						<div class="card-body">
							<h5 class="card-title">${i.name}</h5>

						</div>
						<div class="card-footer d-flex flex-column align-items-center">
							<div class="me-4">
								<a href="" class="text-reset text-decoration-none"> <i
									class="bi bi-suit-heart"></i> <span>Giá gốc: </span> <span><strike>${i.price}</strike></span>
								</a>
							</div>
							<div class="me-4">
								<a href="" class="text-reset text-decoration-none"> <i
									class="bi bi-share"></i> <span>Giá mới: </span> <span> <c:set
											var="newprice" value="${i.price*(1-i.discount)}" /> <fmt:formatNumber
											value="${newprice}" />
								</span>
								</a>
							</div>
							<div class="me-4">
								<a href="" class="text-reset text-decoration-none"> <i
									class="bi bi-cart-check"></i> <span>Mức giá: </span> <span>
										<c:choose>
											<c:when test="${newprice < 10}">Giá thấp</c:when>
											<c:when test="${newprice > 100}">Giá cao</c:when>
											<c:otherwise>Bình thường</c:otherwise>
										</c:choose>
								</span>
								</a>
							</div>
							<div class="me-4">
								<a href="" class="text-reset text-decoration-none"> <i
									class="bi bi-clock-history"></i> <span>Ngày: </span> <span>
										<fmt:formatDate value="${i.date}" pattern="dd/MM/yyyy" />
								</span>
								</a>
							</div>
						</div>
					</div>
				</div>
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