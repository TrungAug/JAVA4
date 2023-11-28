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
					<form action="../find/favorite-or-not" method="post"
						id="filterForm">
						<div class="card bg-info text-white">
							<div class="card-header">
								<div class="card-title">
									<h1>Hiển thị tất cả các video không có hoặc có yêu thích</h1>
								</div>
							</div>
							<div class="card-body d-flex flex-row">
								<h3>${message}</h3>
								<label class="form-label p-3">Lọc theo:</label>
								<div class="favorite p-3">
									<input class="form-check-input" type="radio" name="favorite"
										value="true" id="favoriteRadio">Favorite
								</div>
								<div class="not-favorite p-3">
									<input class="form-check-input" type="radio" name="favorite"
										value="false" id="notFavoriteRadio">Not Favorite
								</div>
								<button class="btn btn-success" id="submitButton">Hiển
									thị danh sách</button>
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
							<div class="table-responsive">
								<table id="videoTable"
									class="table align-middle table-dark table-hover">
									<thead>
										<tr>
											<th scope="col">Id</th>
											<th scope="col">Title</th>
											<th scope="col">Views</th>
											<th scope="col">Active</th>
										</tr>
									</thead>
									<tbody class="table-group-divider">
										<c:forEach var="vd" items="${myList}">
											<tr>
												<td>${vd.id}</td>
												<td>${vd.title}</td>
												<td>${vd.views}</td>
												<td>${vd.active?'Active':'No active'}</td>
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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>