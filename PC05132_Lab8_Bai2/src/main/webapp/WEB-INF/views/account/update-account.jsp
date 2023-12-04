<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main class="main mt-1 mb-1"
	style="background-image: url('https://asset.hankooktire.com/content/dam/hankooktire/local/img/tires/tires-kv/search-by-season/t_kv_112_3_Summer.jpg');">
	<div class="container py-5">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="card"
					style="background: rgba(24, 23, 23, 0.8); backdrop-filter: blur(30px); color: #fff;">
					<div class="card-body p-5 text-center">
						<mark id="messageInfoEditProfile">${mess}</mark>
						<h2 class="fw-bold mb-4" style="color: #0d6efd;">
							<strong>Edit Profile</strong> <strong
								style="color: rgb(231, 16, 16);">!!!</strong>
						</h2>
						<form name="formEditProfile"
							action="../user-controller/update-account" method="post">
							<input name="actionUser" type="hidden" value="update-account">
							<div class="row">
								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<label class="form-label" for="editProfileFullname">Fullname</label>
										<input type="text" id="editProfileFullname" name="fullName"
											value="${editAcc.fullName}" class="form-control" required>
									</div>
								</div>
								<div class="col-md-6 mb-4">
									<div class="form-outline">
										<label class="form-label" for="editProfileUsername">Username</label>
										<input type="text" id="editProfileUsername" name="idUs"
											value="${editAcc.idUs}" class="form-control" required>
									</div>
								</div>

								<div class="col-md-6 mb-4">
									<div class="form-outline mb-4">
										<label class="form-label" for="editProfileEmail">Email
											Address</label> <input type="email" id="editProfileEmail"
											class="form-control" name="email" value="${editAcc.email}"
											required>
									</div>
								</div>
								<div class="col-md-6 mb-4">
									<div class="form-outline mb-4">
										<label class="form-label" for="editProfilePass">Password</label>
										<input type="password" id="editProfilePass"
											class="form-control" name="passWord"
											value="${editAcc.passWord}" required>
									</div>
								</div>
							</div>
							<div class="form-outline mb-4">
								<label class="form-label" for="editProfileDate">Birthday</label>
								<input type="date" id="editProfileDate" class="form-control"
									name="birthDay" value="${editAcc.birthDay}" required>
							</div>
							<div class="form-check d-flex justify-content-center mb-4">
								<input class="form-check-input me-2" type="checkbox"
									id="editProfileRole" name="admin" /> <label
									class="form-check-label" for="editProfileRole"> Admin?
								</label>
							</div>
							<button type="submit" class="btn btn-primary btn-block mb-4"
								id="editProfileButton">Update</button>
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
				document.getElementById('messageInfoEditProfile').style.display = 'none';
			}, 4000);
</script>