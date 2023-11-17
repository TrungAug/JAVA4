<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Java4</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>

<body class="d-flex flex-column justify-content-between" style="height: 100vh;">
    <div class="container-fluid">
        <header>
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <div class="myui-header__logo ">
                        <a class="home" href="/index.html" target="_self">
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
                                <a class="navbar-brand" href="/index.html">Home</a>
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
                                            <a class="nav-link" href="/templates/promotion.html">Promotion</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="/templates/help.html">Help &
                                                Support</a>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" role="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Account
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="/templates/updateaccout.html">Update
                                                        Account</a></li>
                                                <li><a class="dropdown-item" href="/templates/forgetpass.html">Forget
                                                        Password</a></li>
                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                                <li><a class="dropdown-item" href="/templates/signin.html">Sign in</a>
                                                </li>
                                                <li><a class="dropdown-item" href="/templates/signup.html">Sign up</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <!-- Nếu đăng nhập thành công và user là khách hàng thì hiển thị menu -->
                                        <li class="nav-item">
                                            <a class="nav-link" href="/templates/favorite.html">My Favorites</a>
                                        </li>
                                        <!-- Nếu đăng nhập thành công và user là admin thì hiển thị menu -->
                                        <li class="nav-item">
                                            <a class="nav-link" href="/templates/editor.html">Editor</a>
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
        <main class="main">
            <section>
                <h1>FAVORITE PRODUCT LIST</h1>
            </section>
            <div class="row">
                <div class="col-lg-9 col-md-9 col-sm-12" id="productsContainer">
                    <div class="box-content mt-3">
                        <div class="row">
                            <div class="col-lg-3 col-md-4 col-sm-12 mb-3">
                                <div class="card d-flex flex-column h-100">
                                    <a href="#">
                                        <img src="https://asset.hankooktire.com/content/dam/hankooktire/eu/product/tire_list/suv/IH01A_normal.png"
                                            alt="" class="card-img-top img-thumbnail" data-bs-toggle="tooltip"
                                            data-bs-placement="right">
                                    </a>
                                    <div class="card-body">
                                        <h5 class="card-title">iON evo AS SUV</h5>
                                        <p class="card-text font_caption_lg desc">EVolutionised to perform and last</p>
                                    </div>
                                    <div class="card-footer d-flex align-items-center">
                                        <div class="me-4">
                                            <a href="" class="text-reset text-decoration-none">
                                                <i class="bi bi-suit-heart"></i>
                                                <span>2.099</span>
                                            </a>
                                        </div>
                                        <div class="me-4">
                                            <a href="" class="text-reset text-decoration-none">
                                                <i class="bi bi-share"></i>
                                                <span>1.099</span>
                                            </a>
                                        </div>
                                        <div class="me-4">
                                            <a href="" class="text-reset text-decoration-none">
                                                <i class="bi bi-cart-check"></i>
                                                <span>7.099</span>
                                            </a>
                                        </div>
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
                <div class="col-lg-3 col-md-3 col-sm-12" id="sidebar-login-n-categories">
                    <div id="login__sidebar" class="mb-3 text-white">
                        <div class="card shadow-2-strong"
                            style="border-radius: 1rem;background-color: #474545;color: #fff;">
                            <div class="card-body p-2 text-center">
                                <h3 class="mb-4">Sign in</h3>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="typeEmailX-2">Email</label>
                                    <input type="email" id="typeEmailX-2" class="form-control form-control-lg"
                                        placeholder="example@email.com" />
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="typePasswordX-2">Password</label>
                                    <input type="password" id="typePasswordX-2" class="form-control form-control-lg" />
                                </div>

                                <!-- Checkbox -->
                                <div class="form-check d-flex justify-content-start mb-4">
                                    <input class="form-check-input" type="checkbox" value="" id="form1Example3" />
                                    <label class="form-check-label" for="form1Example3"> Remember password </label>
                                </div>

                                <button class="btn btn-lg btn-block" style="background-color: #0f0b0b;"
                                    type="button">Login</button>
                            </div>
                        </div>
                    </div>
                    <div id="accordion__sidebar" class="mb-3 text-black">
                        <div class="accordion" id="accordionPanelsHanKook">
                            <div class="accordion-item">
                                <h2 class="accordion-header">
                                    <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#accordionTyreVehicle" aria-expanded="true"
                                        aria-controls="accordionTyreVehicle">
                                        By Vehicle
                                    </button>
                                </h2>
                                <div id="accordionTyreVehicle" class="accordion-collapse collapse show"
                                    data-bs-parent="#accordionPanelsHanKook">
                                    <ul class="list-group">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Electric Vehicle
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Passenger Car
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            SUV/4WD
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            VAN/Light Truck
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Truck & Bus
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Competition Tyres
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#accordionTyreSeason" aria-expanded="false"
                                        aria-controls="accordionTyreSeason">
                                        By Season
                                    </button>
                                </h2>
                                <div id="accordionTyreSeason" class="accordion-collapse collapse"
                                    data-bs-parent="#accordionPanelsHanKook">
                                    <ul class="list-group">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            All Season
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Summer
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#accordionTyreProductFamily" aria-expanded="false"
                                        aria-controls="accordionTyreProductFamily">
                                        By Product Family
                                    </button>
                                </h2>
                                <div id="accordionTyreProductFamily" class="accordion-collapse collapse"
                                    data-bs-parent="#accordionPanelsHanKook">
                                    <ul class="list-group">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Our Brands
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            iON
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Ventus
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Dynapro
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Kinergy
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Vantra
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Smart
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>        
        </main>
        <footer style="background-color: #000; color: #fff;" class="text-center text-lg-start">
            <!-- Section: Social media -->
            <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
                <!-- Left -->
                <div class="me-5 d-none d-lg-block">
                    <span>Get connected with us on social networks:</span>
                </div>
                <!-- Left -->

                <!-- Right -->
                <div>
                    <a href="" class="me-4 text-reset">
                        <i class="bi bi-facebook"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="bi bi-twitter"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="bi bi-google"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="bi bi-instagram"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="bi bi-linkedin"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="bi bi-github"></i>
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
                            <p>
                                Hankook Tire offers the following three global tyre brands: 'Hankook', a leading premium
                                brand for the domestic and overseas markets, 'Laufenn', a global brand that appeals to
                                the world, and 'Kingstar', a brand tailored to the specific needs of each region,
                                thereby providing the ultimate driving experience to its customers.
                            </p>
                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                            <!-- Links -->
                            <h6 class="text-uppercase fw-bold mb-4">
                                Tyres by Vehicle
                            </h6>
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
                            <h6 class="text-uppercase fw-bold mb-4">
                                Tyres by Brand
                            </h6>
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
                            <p><i class="bi bi-house-add-fill"></i> Can Tho City</p>
                            <p>
                                <i class="bi bi-envelope-at-fill"></i>
                            </p>
                            <p><i class="bi bi-telephone-inbound-fill"></i> +(84) 969 281 254</p>
                        </div>
                        <!-- Grid column -->
                    </div>
                    <!-- Grid row -->
                </div>
            </section>
            <!-- Section: Links  -->

            <!-- Copyright -->
            <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
                © 2021 Copyright:
                <a class="text-reset fw-bold" href="#">HanKook.com</a>
            </div>
            <!-- Copyright -->
        </footer>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>