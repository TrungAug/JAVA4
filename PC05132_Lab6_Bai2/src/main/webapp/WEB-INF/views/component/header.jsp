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
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <div class="myui-header__logo ">
                        <a class="home" href="${pageContext.request.contextPath}/home" target="_self">
                            <img class="logo"
                                src="https://asset.hankooktire.com/content/dam/hankooktire/local/img/main/main-key-visual/pc/logo.svg"
                                alt="Hankook Tire">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-12 d-flex">
                    <div class="myui-header__navbar">
                        <nav class="navbar navbar-expand-lg bg-body-tertiary">
                            <div class="container-fluid">
                                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
                                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                        
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/find/user-id">Find By User Id</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/find/keyword">Find By Keyword</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/find/video-id">Find By Video Id</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/find/favorite-or-not">Find By Favorite Or Not</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/find/report">Report</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
	
	
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>