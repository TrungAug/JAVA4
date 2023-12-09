<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.container-fruid {
	background-image:
		url("https://static0.gamerantimages.com/wordpress/wp-content/uploads/2022/02/Cover-Art-For-The-Eminence-In-Shadow.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	height: 100vh;
}
</style>


<form action="./profile" method="post" class="container-fruid">

	<div class="container align-items-center " style="padding-top: 10rem;">

		<div class="row  d-flex justify-content-center">
			<div class="col-lg-8 ">
				<div class="card " >
					<h4
						class="card-header bg-dark text-light d-flex justify-content-center  fw-bold ">
						${infor}</h4>

					<div class="card-body container">
						<div class="row">
							<div class="col-lg-6">
								<div class="mb-3">
									<label for="id">Tên Tài Khoản</label> <input type="text"
										id="account"  name="id"  value="${account.id}" class="form-control">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="mb-3">
									<label for="pass">Mật Khẩu</label> <input type="password"
										id="pass"  name="password" value="${account.password}" class="form-control">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="mb-3">
									<label for="fullname">Họ và Tên</label> <input type="text"
										id="fullname" name="fullname"  value="${account.fullname}" class="form-control">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="mb-3">
									<label for="email">Địa chỉ Email</label> <input type="email"
										id="email" name="email"  value="${account.email}" class="form-control">
								</div>
							</div>

						</div>


					</div>
					<div class="card-footer ">
						<button type="submit" class="btn btn-danger col-lg-12 fw-bold">Cập
							Nhật</button>
					</div>
				</div>

			</div>
		</div>

	</div>

</form>

