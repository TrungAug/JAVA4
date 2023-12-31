<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<body class="d-flex flex-column justify-content-between">
	<div class="container-fluid">
		<%@ include file="/WEB-INF/views/component/header.jsp"%>
		<main class="main mt-1 mb-1"
			style="background-image: url('https://asset.hankooktire.com/content/dam/hankooktire/common/media/AU/en/2023/11/news_img_2023_1101_1.jpg');">
			<div class="container py-5">
				<div class="row justify-content-center">
					<div class="col-lg-12">
						<div class="card w-50 mx-auto my-5"
							style="background: rgba(24, 23, 23, 0.8); backdrop-filter: blur(30px); color: #fff;">
							<div class="card-body p-5 text-center">
								<mark id="messageInfoForgetPassword">${mess}</mark>
								<h2 class="fw-bold mb-4" style="color: #0d6efd;">
									<strong>FORGOT PASSWORD</strong>
								</h2>
								<form name="formForget" action="../user-controller/forget-pass"
									method="post">
									<div class="row">
										<div class="col-md-12 mb-4">
											<div class="form-outline">
												<label class="form-label" for="forgotPasswordUsername">Username</label>
												<input type="text" id="forgotPasswordUsername"
													name="username" class="form-control" required>
											</div>
										</div>
										<div class="col-md-12 mb-4">
											<div class="form-outline mb-4">
												<label class="form-label" for="forgotPasswordEmail">Email
													Address</label> <input type="email" id="forgotPasswordEmail"
													class="form-control" name="email" required>
											</div>
										</div>
									</div>
									<button class="btn btn-primary btn-block mb-4"
										id="registerButton">Retrieve</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/component/footer.jsp"%>
	</div>
	<script>
		setTimeout(
				function() {
					document.getElementById('messageInfoForgetPassword').style.display = 'none';
				}, 2000);
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>