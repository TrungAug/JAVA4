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
        <%@ include file="/WEB-INF/views/component/header.jsp" %>
        <main class="main">
            <div class="row d-flex justify-content-between align-items-center">
                <div class="col">
                    <h1 style="color: #999;">Website Administration</h1>
                </div>
                <div class="col text-end">
                    <a type="button" class="text-info" data-bs-toggle="modal"
                        data-bs-target="#editorAddProductModal">
                        Add Product
                    </a>
                </div>
            </div>     
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
        <%@ include file="/WEB-INF/views/component/footer.jsp" %>
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
    
    <!-- Modal Trang Editor cho nút Add Product-->
    <div class="modal fade" id="editorAddProductModal" tabindex="-1" aria-labelledby="editorAddProductModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-info" id="editorAddProductModalLabel">Thêm sản phẩm mới</h5>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>