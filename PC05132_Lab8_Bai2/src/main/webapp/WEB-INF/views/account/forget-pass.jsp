<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
										<input type="text" id="forgotPasswordUsername" name="username"
											class="form-control" required>
									</div>
								</div>
								<div class="col-md-12 mb-4">
									<div class="form-outline mb-4">
										<label class="form-label" for="forgotPasswordEmail">Email
											Address</label> <input type="email" id="forgotPasswordEmail"
											class="form-control" name="emailTo" required>
									</div>
								</div>
							</div>
							<button class="btn btn-primary btn-block mb-4"
								id="forgetPasswordButton">Retrieve</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
<script>
	setTimeout(
			function() {
				document.getElementById('messageInfoForgetPassword').style.display = 'none';
			}, 2000);
</script>
