<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div class="row">
		<div class="col-lg-4 col-md-4 col-sm-12">
			<div class="myui-header__logo ">
				<a class="home" href="${pageContext.request.contextPath}/home/index"
					target="_self"> <img class="logo"
					src="https://asset.hankooktire.com/content/dam/hankooktire/local/img/main/main-key-visual/pc/logo.svg"
					alt="Hankook Tire">
				</a>
			</div>
		</div>
		<div class="col-lg-8 col-md-8 col-sm-12 d-flex">
			<div class="myui-header__navbar">
				<nav class="navbar navbar-expand-lg bg-body-tertiary">
					<div class="container-fluid">
						<a class="navbar-brand"
							href="${pageContext.request.contextPath}/home/index">Home</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> Tyres </a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="#">Electric
												Vehicle</a></li>
										<li><a class="dropdown-item" href="#">Passenger Car</a></li>
										<li><a class="dropdown-item" href="#">SUV/4WD</a></li>
										<li><a class="dropdown-item" href="#">VAN/Light Truck</a></li>
										<li><a class="dropdown-item" href="#">Truck & Bus</a></li>
										<li><a class="dropdown-item" href="#">Competition
												Tyres</a></li>
										<li>
											<hr class="dropdown-divider">
										</li>
										<li><a class="dropdown-item" href="#">Something else
												here</a></li>
									</ul></li>
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/home/promotion">Promotion</a>
								</li>
								<li class="nav-item"><a class="nav-link"
									aria-current="page"
									href="${pageContext.request.contextPath}/home/help">Help &
										Support</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> Account </a>
									<ul class="dropdown-menu">
										<c:choose>
											<c:when test="${userLogin == null}">
												<li><a class="dropdown-item"
													href="${pageContext.request.contextPath}/user-controller/sign-in">Sign
														in</a></li>
												<li><a class="dropdown-item"
													href="${pageContext.request.contextPath}/user-controller/sign-up">Sign
														up</a></li>

											</c:when>
											<c:otherwise>
												<li><a class="dropdown-item"
													href="${pageContext.request.contextPath}/user-controller/update-account">Update
														Account</a></li>
												<li><a class="dropdown-item"
													href="${pageContext.request.contextPath}/user-controller/forget-pass">Forget
														Password</a></li>
												<li>
													<hr class="dropdown-divider">
												</li>
												<li><a class="dropdown-item"
													href="${pageContext.request.contextPath}/user-controller/sign-out">Sign
														out</a></li>
											</c:otherwise>

										</c:choose>


									</ul></li>
								<c:choose>
									<c:when test="${userLogin != null}">
										<c:choose>
											<c:when test="${userLogin.admin == true}">
												<li class="nav-item"><a class="nav-link"
													href="${pageContext.request.contextPath}/admin/editor-product">Editor
														Product</a></li>
												<li class="nav-item"><a class="nav-link"
													href="${pageContext.request.contextPath}/admin/editor-user">Editor
														User</a></li>
											</c:when>
											<c:otherwise>
												<li class="nav-item"><a class="nav-link"
													href="${pageContext.request.contextPath}/home/favorite">My
														Favorites</a></li>
											</c:otherwise>
										</c:choose>
									</c:when>
								</c:choose>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>
	
</header>