<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<header>
	<fmt:setLocale value="${sessionScope.lang}" scope="request" />
	<fmt:setBundle basename="global" scope="request" />
	<div class="row">
		<div class="col-lg-4 col-md-4 col-sm-12">
			<div class="myui-header__logo ">
				<a class="home" href="${pageContext.request.contextPath}/home"
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
							href="${pageContext.request.contextPath}/home/index"><fmt:message
								key="menu.home" /></a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">

								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/home/about"><fmt:message
											key="menu.about" /></a></li>
								<li class="nav-item"><a class="nav-link"
									aria-current="page"
									href="${pageContext.request.contextPath}/home/contact"><fmt:message
											key="menu.contact" /></a></li>
								<li class="nav-item"><a class="nav-link"
									aria-current="page" href="?lang=vi">Tiếng việt</a></li>
								<li class="nav-item"><a class="nav-link"
									aria-current="page" href="?lang=en">English</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<div class="myui-header__search">
		<form class="d-flex" role="search">
			<input class="form-control me-2" type="search" placeholder="Search"
				aria-label="Search">
			<button class="btn btn-outline-success" type="submit">Search</button>
		</form>
	</div>
</header>