<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Details</title>
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
		<main class="main mt-1 mb-1">
			<div class="row">
				<div class="col-lg-8 col-md-8-col-sm-12">
					<div id="sliderCarouseDetailProduct" class="carousel slide mb-3"
						data-bs-ride="carousel">
						<div class="carousel-indicators">
							<button type="button"
								data-bs-target="#sliderCarouseDetailProduct"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide 1"></button>
							<button type="button"
								data-bs-target="#sliderCarouseDetailProduct"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button"
								data-bs-target="#sliderCarouseDetailProduct"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
						</div>
						<div class="carousel-inner">
							<c:forEach var="i" items="${images}">
								<div class="carousel-item active" data-bs-interval="3000">
									<img src="${i.getImgSrc()}" class="d-block w-100" alt="...">
								</div>
							</c:forEach>
							
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#sliderCarouseDetailProduct" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#sliderCarouseDetailProduct" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12">
					<div class="name__product mb-4">
						<h2 style="color: #999;">${product.prodName}</h2>
					</div>
					<div class="description__product mb-4">
						<h3>${product.description}</h3>
					</div>
					<div class="mb-4">
						<a class="btn btn-info">Where to buy</a>
					</div>
					<!-- onclick="localWhereToBuyUsInit();" -->
					<div id="accordion__size__detail__product" class="mb-4 text-black">
						<div class="accordion"
							id="accordionPanelsHanKookSizeDetailProduct">
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button fw-bold fs-4" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#accordionTyreVehicleSize"
										aria-expanded="true" aria-controls="accordionTyreVehicleSize">
										Spec</button>
								</h2>
								<div id="accordionTyreVehicleSize"
									class="accordion-collapse collapse"
									data-bs-parent="#accordionPanelsHanKookSizeDetailProduct">
									<ul class="list-group">
										<li
											class="list-group-item d-flex justify-content-between align-items-center">
											<div id="accordion__size__detail__product__subsize"
												class="mb-3 text-black">
												<div class="accordion"
													id="accordionPanelsHanKookSizeDetailProductSubSize">
													<div class="accordion-item">
														<h2 class="accordion-header">
															<c:forEach var="s" items="${sizes}">
																<button class="accordion-button fw-bold" type="button"
																	data-bs-toggle="collapse"
																	data-bs-target="#accordionTyreVehicleSubSize${s.id}"
																	aria-expanded="true"
																	aria-controls="accordionTyreVehicleSubSize${s.id}">
																	${s.sizeName}</button>
														</h2>
														<div id="accordionTyreVehicleSubSize${s.id}"
															class="accordion-collapse collapse"
															data-bs-parent="#accordionPanelsHanKookSizeDetailProductSubSize">
															<ul class="list-group">
																<li
																	class="list-group-item d-flex justify-content-between align-items-center">
																	<span class="dt">Width: </span> <span class="dd">${s.width}</span>
																</li>
																<li
																	class="list-group-item d-flex justify-content-between align-items-center">
																	<span class="dt">Profile: </span> <span class="dd">${s.profile}</span>
																</li>
																<li
																	class="list-group-item d-flex justify-content-between align-items-center">
																	<span class="dt">Rim: </span> <span class="dd">${s.rim}</span>
																</li>
																<li
																	class="list-group-item d-flex justify-content-between align-items-center">
																	<span class="dt">Diameter: </span> <span class="dd">${s.diameter}</span>
																</li>
															</ul>
														</div>
														</c:forEach>
													</div>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/component/footer.jsp"%>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>