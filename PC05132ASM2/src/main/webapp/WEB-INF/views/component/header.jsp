<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" role="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Tyres
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="#">Electric Vehicle</a></li>
                                                <li><a class="dropdown-item" href="#">Passenger Car</a></li>
                                                <li><a class="dropdown-item" href="#">SUV/4WD</a></li>
                                                <li><a class="dropdown-item" href="#">VAN/Light Truck</a></li>
                                                <li><a class="dropdown-item" href="#">Truck & Bus</a></li>
                                                <li><a class="dropdown-item" href="#">Competition Tyres</a></li>
                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                                            </ul>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/promotion">Promotion</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/help">Help &
                                                Support</a>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" role="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Account
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user-controller/update-account">Update
                                                        Account</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user-controller/forget-pass">Forget
                                                        Password</a></li>
                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user-controller/sign-in">Sign in</a>
                                                </li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user-controller/sign-up">Sign up</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <!-- Nếu đăng nhập thành công và user là khách hàng thì hiển thị menu -->
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/favorite">My Favorites</a>
                                        </li>
                                        <!-- Nếu đăng nhập thành công và user là admin thì hiển thị menu -->
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/editor">Editor</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/editoruser">Editor User</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="myui-header__search">
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </header>