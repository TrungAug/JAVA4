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

<body class="d-flex flex-column justify-content-between"
	style="height: 100vh;">
	<div class="container-fluid">
		<%@ include file="/WEB-INF/views/component/header-admin.jsp"%>

		<main class="main">
			<div id="sliderCarouse" class="carousel slide mb-3"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#sliderCarouse"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#sliderCarouse"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#sliderCarouse"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active" data-bs-interval="3000">
						<video class="img-fluid" autoplay loop muted>
							<source
								src="https://asset.hankooktire.com/content/dam/hankooktire/global/video/main/LC_uk_en_iON_2_1920_970_1209.mp4"
								type="video/mp4" />
						</video>
					</div>
					<div class="carousel-item" data-bs-interval="3000">
						<video class="img-fluid" autoplay loop muted>
							<source
								src="https://asset.hankooktire.com/content/dam/hankooktire/global/video/main/LC_febrandfilm_1920_970_230418.mp4"
								type="video/mp4" />
						</video>
					</div>
					<div class="carousel-item" data-bs-interval="3000">
						<video class="img-fluid" autoplay loop muted>
							<source
								src="https://asset.hankooktire.com/content/dam/hankooktire/global/video/main/LC_kinergy_1920_970_230523.mp4"
								type="video/mp4" />
						</video>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#sliderCarouse" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#sliderCarouse" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
			<div class="row main-product-and-sidebar">
				<div class="col-lg-9 col-md-9 col-sm-12" id="productsContainer">
					<div class="box-content mt-3">
						<div class="row">
							<!-- Lặp sản phẩm -->
							<div class="col-lg-3 col-md-4 col-sm-12 mb-3">
								<div class="card d-flex flex-column h-100">
									<a href="/templates/productdetail.html"> <img
										src="https://asset.hankooktire.com/content/dam/hankooktire/eu/product/tire_list/suv/IH01A_normal.png"
										class="card-img-top img-thumbnail" data-bs-toggle="tooltip"
										data-bs-placement="right" title="Click to see more details">
									</a>
									<div class="card-body">
										<h5 class="card-title">iON evo AS SUV</h5>
										<p class="card-text font_caption_lg desc">EVolutionised to
											perform and last</p>
									</div>
									<div
										class="card-footer d-flex align-items-center justify-content-end">
										<div class="me-4">
											<a href="" class="text-reset text-decoration-none"> <i
												class="bi bi-suit-heart"></i> <span>2.099</span>
											</a>
										</div>
										<div class="me-4">
											<a href="${pageContext.request.contextPath}/share" class="text-reset text-decoration-none"> <i
												class="bi bi-share"></i> <span>1.099</span>
											</a>
										</div>
										<!-- <div class="me-4">
                                            <a href="" class="text-reset text-decoration-none">
                                                <i class="bi bi-cart-check"></i>
                                                <span>7.099</span>
                                            </a>
                                        </div> -->
									</div>
								</div>
							</div>
						</div>
						<nav aria-label="Page navigation example" id="paginationF99">
							<ul class="pagination justify-content-center">
								<li class="page-item"><a class="page-link" href="">First</a></li>
								<li class="page-item"><a class="page-link" href="">Previous</a></li>
								<li class="page-item"><a class="page-link" href="">Next</a>
								</li>
								<li class="page-item"><a class="page-link" href="">Last</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12"
					id="sidebar-login-n-categories">
					<!-- Đăng nhập thành công thì ẩn #login__sidebar, thay vào đó là #infoMember__sidebar -->
					<div id="login__sidebar" class="mb-3 text-white">
						<div class="card shadow-2-strong"
							style="border-radius: 1rem; background-color: #474545; color: #fff;">
							<div class="card-body p-2 text-center">
								<h3 class="mb-4">Sign in</h3>
								<div class="form-outline mb-4">
									<label class="form-label" for="typeEmailX-2">Email</label> <input
										type="email" id="typeEmailX-2"
										class="form-control form-control-lg"
										placeholder="example@email.com" />
								</div>

								<div class="form-outline mb-4">
									<label class="form-label" for="typePasswordX-2">Password</label>
									<input type="password" id="typePasswordX-2"
										class="form-control form-control-lg" />
								</div>

								<!-- Checkbox -->
								<div class="form-check d-flex justify-content-start mb-4">
									<input class="form-check-input" type="checkbox" value=""
										id="form1Example3" /> <label class="form-check-label"
										for="form1Example3"> Remember password </label>
								</div>

								<button class="btn btn-lg btn-block"
									style="background-color: #0f0b0b;" type="button">Login</button>
							</div>
						</div>
					</div>
					<div id="accordion__sidebar" class="mb-3 text-black">
						<div class="accordion" id="accordionPanelsHanKook">
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#accordionTyreVehicle" aria-expanded="true"
										aria-controls="accordionTyreVehicle">By Vehicle</button>
								</h2>
								<div id="accordionTyreVehicle"
									class="accordion-collapse collapse show"
									data-bs-parent="#accordionPanelsHanKook">
									<ul class="list-group">
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Electric Vehicle</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Passenger Car</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											SUV/4WD</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											VAN/Light Truck</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Truck & Bus</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Competition Tyres</li>
									</ul>
								</div>
							</div>
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#accordionTyreSeason" aria-expanded="false"
										aria-controls="accordionTyreSeason">By Season</button>
								</h2>
								<div id="accordionTyreSeason"
									class="accordion-collapse collapse"
									data-bs-parent="#accordionPanelsHanKook">
									<ul class="list-group">
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											All Season</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Summer</li>
									</ul>
								</div>
							</div>
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#accordionTyreProductFamily"
										aria-expanded="false"
										aria-controls="accordionTyreProductFamily">By Product
										Family</button>
								</h2>
								<div id="accordionTyreProductFamily"
									class="accordion-collapse collapse"
									data-bs-parent="#accordionPanelsHanKook">
									<ul class="list-group">
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Our Brands</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											iON</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Ventus</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Dynapro</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Kinergy</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Vantra</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											Smart</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
											<div class="card-text mb-3" style="color: #999;">Type
												của post</div>
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
		<%@ include file="/WEB-INF/views/component/footer.jsp" %>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>