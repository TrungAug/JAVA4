<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Administration</title>
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
	<%@ include file="/WEB-INF/views/component/header.jsp"%>
	<div class="container-fluid">

		<main class="main">
			<section class="m-3">
				<h1 style="color: #999;">Website User Management</h1>
			</section>
			<section>
				<h3 class="text-primary" id="messageInfo">${message}</h3>
			</section>
			<div class="row mt-5">
				<ul class="nav nav-tabs" id="editUser" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="form-tab" data-bs-toggle="tab"
							data-bs-target="#form-tab-pane" type="button" role="tab"
							aria-controls="form-tab-pane" aria-selected="true">
							<i class="bi bi-pencil-square"></i> Update User
						</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="list-tab" data-bs-toggle="tab"
							data-bs-target="#list-tab-pane" role="tab"
							aria-controls="list-tab-pane" aria-selected="false">
							<i class="bi bi-list-check"></i> List User
						</button>
					</li>
				</ul>
				<div class="tab-content" id="editUserTabContent">
					<div class="tab-pane fade show active" id="form-tab-pane"
						role="tabpanel" aria-labelledby="form-tab" tabindex="0">
						<div class="card">
							<div class="card-header align-items-center text-white"
								style="background-color: #727070;">Update User Infomation
							</div>
							<div class="card-body text-center">
								<c:url var="url" value="/admin"></c:url>
								<form action="${url}/editor-user">
									<div class="row">
										<div class="col-lg-6">
											<div class="form-outline mb-3">
												<label class="form-label" for="editUserModalUsername">Username</label>
												<input type="text" id="editUserModalUsername" name="idUs"
													value="${form.idUs}" class="form-control" required>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-outline mb-4">
												<label class="form-label" for="editUserModalPass">Password</label>
												<input type="password" id="editUserModalPass"
													class="form-control" name="passWord"
													value="${form.passWord}" required>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-outline mb-4">
												<label class="form-label" for="editUserModalFullname">Fullname</label>
												<input type="text" id="editUserModalFullname"
													name="fullName" value="${form.fullName}"
													class="form-control" required>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-outline mb-4">
												<label class="form-label" for="editUserModalEmail">Email
													Address</label> <input type="email" id="editUserModalEmail"
													class="form-control" name="email" value="${form.email}"
													required>
											</div>
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="editUserModalEmail">Birthday</label>
											<input type="date" id="registerModalDate"
												class="form-control" name="birthDay"
												value="${form.birthDay}" required>
										</div>

										<div class="col-lg-12 d-flex flex-row justify-content-center">
											<div class="form-check m-4">
												<input class="form-check-input" type="radio" name="admin"
													value="true" id="flexCheckDefaultAdmin"
													${form.admin?'checked':''}> <label
													class="form-check-label" for="flexCheckDefaultAdmin">
													Admin </label>
											</div>
											<div class="form-check m-4">
												<input class="form-check-input" type="radio" name="admin"
													value="false" id="flexCheckDefaultUser"
													${form.admin?'':'checked'}> <label
													class="form-check-label" for="flexCheckDefaultUser">
													User </label>
											</div>
										</div>
									</div>
									<div class="d-flex justify-content-end">
										<button formaction="${url}/create" class="btn btn-primary m-2">Create</button>
										<button formaction="${url}/update" class="btn btn-primary m-2">Update</button>
										<button formaction="${url}/delete" class="btn btn-primary m-2">Delete</button>
										<button formaction="${url}/editor-user"
											class="btn btn-primary m-2">Reset</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="list-tab-pane" role="tabpanel"
						aria-labelledby="list-tab" tabindex="0">
						<div class="card">
							<div
								class="card-header d-flex justify-content-between align-items-center text-white"
								style="background-color: #727070;">List User</div>
							<div class="table-responsive">
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<th>Username</th>
											<th>Fullname</th>
											<th>Email</th>
											<th>Birthday</th>
											<th>Role</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${listUs}">
											<tr>
												<td>${item.idUs}</td>
												<td>${item.fullName}</td>
												<td>${item.email}</td>
												<td>${item.birthDay}</td>
												<td>${item.admin?"Admin":"User"}</td>
												<td><a href="${url}/edit/${item.idUs}"
													class="text-info"> Edit </a></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/component/footer.jsp"%>
	</div>
	<script>
		setTimeout(function() {
			document.getElementById('messageInfo').style.display = 'none';
		}, 3000);
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>