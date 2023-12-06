<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main class="main">
	<!-- Hiển thị slider -->
	<%@ include file="/WEB-INF/views/component/sliderCarouse.jsp"%>
	<div class="row main-product-and-sidebar">
		<div class="col-lg-9 col-md-9 col-sm-12" id="productsContainer">
			<!-- Hiển thị sản phẩm active -->
			<%@ include file="/WEB-INF/views/component/main-product.jsp"%>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-12"
			id="sidebar-login-n-categories">
			<!-- Đăng nhập thành công thì ẩn #login__sidebar, thay vào đó là #infoMember__sidebar -->
			<%@ include file="/WEB-INF/views/component/sidebar-signin.jsp"%>
			<%@ include file="/WEB-INF/views/component/sidebar-accordion.jsp"%>
		</div>
	</div>
	<div
		class="row m-5 subscribe-now d-flex flex-column justify-content-center text-center">
		<div class="col mb-4">
			<h1>Subscribe Now</h1>
		</div>
		<div class="col mb-4">
			<h4>Receive the latest news from Hankook Tire & Technology</h4>
		</div>
		<div class="col mb-4 d-flex justify-content-center">
			<div class="input-group mb-3 position-relative w-50">
				<span class="input-group-text" id="email-informed-label">Your-email@example.com</span>
				<input type="text" class="form-control" id="email-informed"
					aria-describedby="email-informed-label">
				<div
					class="icon-accepted-inform position-absolute top-50 translate-middle-y end-0">
					<a href="#"> <i class="bi bi-arrow-right-circle-fill"
						style="font-size: 2rem;"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="row m-5 post-introduce-hankook">
		<div class="title-post">
			<h1>Press Releases</h1>
		</div>
		<div id="sliderCarousePost" class="carousel slide mb-3"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#sliderCarousePost"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#sliderCarousePost"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#sliderCarousePost"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active" data-bs-interval="3000">
					<div class="row prods-post mt-3">
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_20231108_2.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_2022_0816.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_2022_0816.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item" data-bs-interval="3000">
					<div class="row prods-post mt-3">
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_20231108_2.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_2022_0816.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_2022_0816.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item" data-bs-interval="3000">
					<div class="row prods-post mt-3">
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_20231108_2.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_2022_0816.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="box-img mb-3">
										<img
											src="https://asset.hankooktire.com/content/dam/hankooktire/au/main/press-release/news_home_2022_0816.jpg"
											class="img-thumbnail w-100" alt="...">
									</div>
									<div class="card-text mb-3" style="color: #999;">Type của
										post</div>
									<div class="card-title">Tiêu đề của bài viết</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#sliderCarousePost" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#sliderCarousePost" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
</main>