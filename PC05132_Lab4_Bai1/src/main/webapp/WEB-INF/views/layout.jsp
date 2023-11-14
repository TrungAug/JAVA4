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
		<header>
			<%@ include file="menu.jsp"%>
		</header>
		<main class="main">
			<%@ include file="slidercarouse.jsp"%>
			<div class="row">
				<div class="col-lg-9 col-md-9 col-sm-12" id="productsContainer">
					<jsp:include page="items.jsp">
						<jsp:param name="name" value="namesp" />
						<jsp:param name="image" value="imgsp" />
					</jsp:include>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12"
					id="sidebar-login-n-categories">
					<%@ include file="sidebarlogin.jsp"%>
					<%@ include file="category.jsp"%>

				</div>
			</div>
		</main>
		<footer style="background-color: #000; color: #fff;"
			class="text-center text-lg-start">
			<!-- Section: Social media -->
			<section
				class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
				<!-- Left -->
				<div class="me-5 d-none d-lg-block">
					<span>Get connected with us on social networks:</span>
				</div>
				<!-- Left -->

				<!-- Right -->
				<div>
					<a href="" class="me-4 text-reset"> <i class="bi bi-facebook"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="bi bi-twitter"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="bi bi-google"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="bi bi-instagram"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="bi bi-linkedin"></i>
					</a> <a href="" class="me-4 text-reset"> <i class="bi bi-github"></i>
					</a>
				</div>
				<!-- Right -->
			</section>
			<!-- Section: Social media -->

			<!-- Section: Links  -->
			<section class="">
				<div class="container text-center text-md-start mt-5">
					<!-- Grid row -->
					<div class="row mt-3">
						<!-- Grid column -->
						<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
							<!-- Content -->
							<h6 class="text-uppercase fw-bold mb-4">
								<i class="bi bi-buildings"></i>Our technology drives the world
							</h6>
							<p>Hankook Tire offers the following three global tyre
								brands: 'Hankook', a leading premium brand for the domestic and
								overseas markets, 'Laufenn', a global brand that appeals to the
								world, and 'Kingstar', a brand tailored to the specific needs of
								each region, thereby providing the ultimate driving experience
								to its customers.</p>
						</div>
						<!-- Grid column -->

						<!-- Grid column -->
						<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
							<!-- Links -->
							<h6 class="text-uppercase fw-bold mb-4">Tyres by Vehicle</h6>
							<p>
								<a href="#!" class="text-reset">Electric Vehicle</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Passenger Car</a>
							</p>
							<p>
								<a href="#!" class="text-reset">SUV/4WD</a>
							</p>
							<p>
								<a href="#!" class="text-reset">VAN/Light Truck</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Truck & Bus</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Competition Tyres</a>
							</p>
						</div>
						<!-- Grid column -->

						<!-- Grid column -->
						<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
							<!-- Links -->
							<h6 class="text-uppercase fw-bold mb-4">Tyres by Brand</h6>
							<p>
								<a href="#!" class="text-reset">iON</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Ventus</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Dynapro</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Kinergy</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Vantra</a>
							</p>
							<p>
								<a href="#!" class="text-reset">Smart</a>
							</p>
						</div>
						<!-- Grid column -->

						<!-- Grid column -->
						<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
							<!-- Links -->
							<h6 class="text-uppercase fw-bold mb-4">Contact</h6>
							<p>
								<i class="bi bi-house-add-fill"></i> Can Tho City
							</p>
							<p>
								<i class="bi bi-envelope-at-fill"></i>
							</p>
							<p>
								<i class="bi bi-telephone-inbound-fill"></i> +(84) 969 281 254
							</p>
						</div>
						<!-- Grid column -->
					</div>
					<!-- Grid row -->
				</div>
			</section>
			<!-- Section: Links  -->

			<!-- Copyright -->
			<div class="text-center p-4"
				style="background-color: rgba(0, 0, 0, 0.05);">
				© 2021 Copyright: <a class="text-reset fw-bold" href="#">HanKook.com</a>
			</div>
			<!-- Copyright -->
		</footer>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>