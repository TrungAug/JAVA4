<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>

<body class="d-flex flex-column justify-content-between">
	<div class="container-fluid">
		<%@ include file="/WEB-INF/views/component/header.jsp"%>
		<main class="main mt-1 mb-1"
			style="background-image: url('https://asset.hankooktire.com/content/dam/hankooktire/common/media/AU/en/2023/11/news_img_20231108_2.jpg'); background-repeat: no-repeat; background-size: cover;">
			<div class="container py-5">
				<div class="row justify-content-center">
					<div class="col-lg-8">
						<div class="card"
							style="background: rgba(24, 23, 23, 0.8); backdrop-filter: blur(30px); color: #fff;">
							<div class="card-body p-5 text-center">
								<mark id="messageInfo">${mess}</mark>
								<h2 class="fw-bold mb-4" style="color: #0d6efd;">
									<strong>REGISTRATION</strong> <strong
										style="color: rgb(231, 16, 16);">!!!</strong>
								</h2>
								<form name="formRegister" action="../user-controller/sign-up" method="post">
									<div class="row">
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<label class="form-label" for="registerModalFullname">Fullname</label>
												<input type="text" id="registerModalFullname"
													name="fullName" class="form-control" required>
											</div>
										</div>
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<label class="form-label" for="registerModalName">Username</label>
												<input type="text" id="registerModalName" name="idUs"
													class="form-control" required>
											</div>
										</div>
										<div class="col-md-6 mb-4">
											<div class="form-outline mb-4">
												<label class="form-label" for="registerModalEmail">Email
													Address</label> <input type="email" id="registerModalEmail"
													class="form-control" name="email" required>
											</div>
										</div>
										<div class="col-md-6 mb-4">
											<div class="form-outline mb-4">
												<label class="form-label" for="registerModalPass">Password</label>
												<input type="password" id="registerModalPass"
													class="form-control" name="passWord" required>
											</div>
										</div>
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="registerModalDate">Birdthday</label>
										<input type="date" id="registerModalDate" class="form-control"
											name="birthDay" required>
									</div>
									<div class="form-check d-flex justify-content-center mb-4">
										<input class="form-check-input me-2" type="checkbox" 
											id="registerModalPassCheckBox" name="admin" /> <label
											class="form-check-label" for="registerModalPassCheckBox">
											Admin? </label>
									</div>
									<button class="btn btn-primary btn-block mb-4"
										id="registerButton">Register</button>
								</form>
								<div class="mt-4">
									<p>Or register with:</p>
									<button type="button" class="btn btn-link btn-floating mx-1">
										<i class="bi bi-google"></i>
									</button>
									<button type="button" class="btn btn-link btn-floating mx-1">
										<i class="bi bi-facebook"></i>
									</button>
									<button type="button" class="btn btn-link btn-floating mx-1">
										<i class="bi bi-twitter"></i>
									</button>
									<button class="btn btn-link btn-floating mx-1">
										<i class="bi bi-instagram"></i>
									</button>
								</div>
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