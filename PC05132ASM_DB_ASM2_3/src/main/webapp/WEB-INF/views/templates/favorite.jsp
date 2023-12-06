<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Favorite</title>
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
		<%@ include file="/WEB-INF/views/component/header.jsp"%>
		<main class="main">
			<section>
				<h1>FAVORITE PRODUCT LIST</h1>
			</section>
			<div class="row">
				<div class="col-lg-9 col-md-9 col-sm-12" id="productsContainer">
					<div class="box-content mt-3">
						<div class="row">
							<!-- Lặp sản phẩm -->
							<c:forEach var="p" items="${listFavorite}">
								<div class="col-lg-3 col-md-4 col-sm-12 mb-3">
									<div class="card d-flex flex-column h-100">
										<a
											href="${pageContext.request.contextPath}/product/product-detail?id=${p.idPro}">
											<img src="${p.images[0].getImgSrc()}"
											class="card-img-top img-thumbnail" data-bs-toggle="tooltip"
											data-bs-placement="right" title="Click to see more details">
										</a>
										<div class="card-body">
											<h5 class="card-title">${p.prodName}</h5>
											<p class="card-text font_caption_lg desc">${p.description}</p>
										</div>
										<div
											class="card-footer d-flex align-items-center justify-content-end">
											<div class="me-4">
												<a
													href="${pageContext.request.contextPath}/home/index?action=doLike&idLike=${p.idPro}&userLike=${userLogin.idUs}"
													class="text-reset text-decoration-none"> <c:choose>
														<c:when test="${countLike % 2 != 0 && countLike!=0}">
															<i class="bi bi-suit-heart-fill"></i>
														</c:when>
														<c:otherwise>
															<i class="bi bi-suit-heart"></i>
														</c:otherwise>
													</c:choose> <span>${p.likes.size()}</span> <input type="hidden"
													name="like${p.idPro}" />
												</a>
											</div>
											<div class="me-4">
												<a id="likeLink"
													href="${pageContext.request.contextPath}/share?action=doShare&idShare=${p.idPro}&user=${userLogin.idUs}"
													class="text-reset text-decoration-none"> <i
													class="bi bi-share"></i> <span>${p.shares.size()}</span> <input
													type="hidden" name="share${p.idPro}">
												</a>
											</div>

										</div>
									</div>
								</div>
							</c:forEach>
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
					<%@ include file="/WEB-INF/views/component/sidebar-signin.jsp"%>
					<%@ include file="/WEB-INF/views/component/sidebar-accordion.jsp"%>
				</div>
			</div>
		</main>
		<%@ include file="/WEB-INF/views/component/footer.jsp"%>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>