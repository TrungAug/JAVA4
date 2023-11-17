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
            <section class="m-3">
                <h1 style="color: #999;">Website Administration</h1>
            </section>
            <div class="row mt-5">
                <div class="col-lg-4 col-md-4 col-sm-12" id="sidebar-login-n-categories">
                    <div id="editor_product" class="mb-3 text-white">
                        <div class="card shadow-2-strong" style="border-radius: 1rem;color: #999;">
                            <div class="card-body p-2 text-center">
                                <h3 class="mb-4">PRODUCT DETAILS</h3>
                                <table class="table table-danger text-start">
                                    <tbody>
                                        <tr>
                                            <th>Name: </th>
                                            <td>Mark</td>
                                        </tr>
                                        <tr>
                                            <th>Tyre:</th>
                                            <td>Jacob</td>
                                        </tr>
                                        <tr>
                                            <th>Description: </th>
                                            <td>@twitter</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="row">
                                    <!-- lặp hình trong dtb ra 3 hình -->
                                    <div class="col img-prod">
                                        <img src="https://asset.hankooktire.com/content/dam/hankooktire/eu/product/ion/ih01a/KV%20thumb(IH01)1.png"
                                            class="figure-img img-fluid rounded" alt="..."
                                            style="width: 150px;height: 150px;">
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                                <div class="row d-flex flex-row-reverse bd-highlight">
                                    <div class="col">
                                        <!-- Button trigger modal -->
                                        <a type="button" class="text-info" data-bs-toggle="modal"
                                            data-bs-target="#editorChangeProductModal">
                                            Change product
                                        </a>
                                    </div>
                                    <div class="col">
                                        <a type="button" class="text-info">
                                            Delete
                                        </a>
                                    </div>
                                    <div class="col">
                                        <a type="button" class="text-info" data-bs-toggle="modal"
                                            data-bs-target="#editorEditProductModal">
                                            Edit
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-12" id="productsContainer">
                    <div class="card shadow-2-strong" style="border-radius: 1rem;color: #999;">
                        <div class="card-header">
                            <div class="d-flex justify-content-between">
                                <div class="card-title">
                                    <h3 style="color: #999;">Avaliables Size</h3>
                                </div>
                                <div class="add__size">
                                    <a type="button" class="text-info" data-bs-toggle="modal"
                                        data-bs-target="#editorAddSizeProductModal">
                                        Add Size
                                    </a>
                                </div>
                            </div>

                        </div>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Size</th>
                                        <th scope="col">Width</th>
                                        <th scope="col">Profile</th>
                                        <th scope="col">Rim</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td></td>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td>@mdo</td>
                                        <td>@mdo</td>
                                        <td>
                                            <a class="m-2 text-info" href="">Delete Size</a>
                                            <a type="button" class="text-info" data-bs-toggle="modal"
                                                data-bs-target="#editorEditSizeProductModal">
                                                Edit Size
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
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

    <!-- Modal Trang Editor cho nút Change Product-->
    <div class="modal fade" id="editorChangeProductModal" tabindex="-1" aria-labelledby="editorChangeProductModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editorChangeProductModalLabel">Danh sách sản phẩm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-sm-6 mb-3">
                            <button class="btn btn-info">Dùng c:forEach đổ danh sách sản phẩm vào đây</button>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6 mb-3">
                            <button class="btn btn-info">Khi click vào button sẽ trả về id sản phẩm</button>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6 mb-3">
                            <button class="btn btn-info">Từ id Sản phẩm lấy sản phẩm set vào product details và bảng
                                Avaliables Size </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Trang Editor cho nút Edit Product-->
    <div class="modal fade" id="editorEditProductModal" tabindex="-1" aria-labelledby="editorEditProductModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-primary" id="editorEditProductModalLabel">Chỉnh sửa thông tin sản phẩm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body row d-flex justify-content-center">
                    <form action="">
                        <div class="row mb-4">
                            <div class="col-md-6">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Product ID</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="inputGroup-sizing-default">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Product Name</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="inputGroup-sizing-default">
                                </div>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <p>Tyre Type:</p>
                            <div class="col-lg-2 col-md-3 col-sm-4 m-2">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault">
                                        Lặp thực thể tyre ở đậy
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Leave a description here"
                                    id="floatingDescription"></textarea>
                                <label for="floatingDescription">Description</label>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="col-md-4">
                                <div class="input-group mb-3">
                                    <input type="file" class="form-control" id="inputGroupFile01">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group mb-3">
                                    <input type="file" class="form-control" id="inputGroupFile02">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group mb-3">
                                    <input type="file" class="form-control" id="inputGroupFile03">
                                </div>
                            </div>
                            <div class="col text-danger">
                                (*) Choose File Image: Leave empty if no change
                            </div>
                        </div>
                        <div class="row mb-4">
                            <p>Publish:</p>
                            <div class="col-lg-2 col-md-3 col-sm-4 m-2">
                                <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                                    <input type="radio" class="btn-check" name="chkPublish" id="chkActive"
                                        autocomplete="off" checked>
                                    <label class="btn btn-outline-primary" for="chkActive">Active</label>

                                    <input type="radio" class="btn-check" name="chkPublish" id="chkInactive"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="chkInactive">Inactive</label>
                                </div>
                            </div>

                        </div>
                        <div class="row mt-5 d-flex justify-content-end">
                            <button type="button" class="btn btn-primary">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Trang Editor cho nút AddSize-->
    <div class="modal fade" id="editorAddSizeProductModal" tabindex="-1"
        aria-labelledby="editorAddSizeProductModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-info" id="editorAddSizeProductModalLabel">Thêm Size Sản Phẩm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body row d-flex justify-content-center">
                    <form action="">
                        <div class="row">
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-addSizeForm-productId-id">Product
                                        id</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-addSizeForm-productId-id"
                                        name="editorPage-addSizeForm-productId">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-addSizeForm-size-id">Size</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-addSizeForm-size-id"
                                        name="editorPage-addSizeForm-size">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-addSizeForm-width-id">Width</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-addSizeForm-width-id"
                                        name="editorPage-addSizeForm-width">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-addSizeForm-profile-id">Profile</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-addSizeForm-profile-id"
                                        name="editorPage-addSizeForm-profile">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-addSizeForm-rim-id">Rim</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-addSizeForm-rim-id"
                                        name="editorPage-addSizeForm-rim">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-group mb-3 d-flex justify-content-end">
                                <button class="btn btn-outline-info" type="button">Reset</button>
                                <button class="btn btn-outline-info" type="button">Save</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Trang Editor cho nút EditSize-->
    <div class="modal fade" id="editorEditSizeProductModal" tabindex="-1"
        aria-labelledby="editorEditSizeProductModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-info" id="editorEditSizeProductModalLabel">Sửa Size Sản Phẩm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body row d-flex justify-content-center">
                    <form action="">
                        <div class="row">
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-EditSizeForm-productId-id">Product
                                        id</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-EditSizeForm-productId-id"
                                        name="editorPage-EditSizeForm-productId">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-EditSizeForm-size-id">Size</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-EditSizeForm-size-id"
                                        name="editorPage-EditSizeForm-size">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-EditSizeForm-width-id">Width</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-EditSizeForm-width-id"
                                        name="editorPage-EditSizeForm-width">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text"
                                        id="editorPage-EditSizeForm-profile-id">Profile</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-EditSizeForm-profile-id"
                                        name="editorPage-EditSizeForm-profile">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="input-group mb-5">
                                    <span class="input-group-text" id="editorPage-EditSizeForm-rim-id">Rim</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="editorPage-EditSizeForm-rim-id"
                                        name="editorPage-EditSizeForm-rim">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-group mb-3 d-flex justify-content-end">
                                <button class="btn btn-outline-info" type="button">Reset</button>
                                <button class="btn btn-outline-info" type="button">Save Changes</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>