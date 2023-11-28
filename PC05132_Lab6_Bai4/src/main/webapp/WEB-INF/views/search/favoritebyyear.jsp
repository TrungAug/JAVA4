<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Java4</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body class="d-flex flex-column justify-content-between"
	style="height: 100vh;">

	<div class="container-fluid">
		<%@ include file="/WEB-INF/views/component/header.jsp"%>
		<div class="form_lab6_bai2 m-3">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<form action="../find/favorite-by-year" method="post" id="filterForm">
						<div class="card bg-info text-white">
							<div class="card-header">
								<div class="card-title">
									<h1>Tổng hợp số lượt thích từng video</h1>
								</div>
							</div>
							<div class="card-body">
								<h3>${message}</h3>
								<select class="form-select form-select-lg mb-3"
									aria-label=".form-select-lg example" name="year" id="yearSelect">
									<option value="2023">2023</option>
									<option value="2022">2022</option>
									<option value="2021">2021</option>
									<option value="2020">2020</option>
								</select>
								<button class="btn btn-success">Xem danh sách</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="table_lab6_bai2">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card">
						<div class="card-header">
							<div class="card-title">
								<h3>Danh sách video ${mess}</h3>
							</div>
						</div>
						<div class="card-body">
							<div id="videoTable">
								<div class="table-responsive">
								<table class="table align-middle table-dark table-hover">
									<thead>
										<tr>
											<th scope="col">Id</th>
											<th scope="col">Favorite count</th>
											<th scope="col">Newest Date</th>
											<th scope="col">Oldest Date</th>
										</tr>
									</thead>
									<tbody class="table-group-divider">
										<c:forEach var="vd" items="${myListRP}">
											<tr>
												<td>${vd.group}</td>	
												<td>${vd.likes}</td>
												<td>${vd.newest}</td>
												<td>${vd.oldest}</td>
											</tr>

										</c:forEach>

									</tbody>
								</table>
							</div>
							
							
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>
	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>