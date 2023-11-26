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
            <section class="m-3">
                <h1 style="color: #999;">Website User Management</h1>
            </section>
            <div class="row mt-5">
                <ul class="nav nav-tabs" id="editUser" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="form-tab" data-bs-toggle="tab"
                            data-bs-target="#form-tab-pane" type="button" role="tab" aria-controls="form-tab-pane"
                            aria-selected="true">
                            <i class="bi bi-pencil-square"></i>
                            Update User
                        </button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="list-tab" data-bs-toggle="tab" data-bs-target="#list-tab-pane"
                            type="button" role="tab" aria-controls="list-tab-pane" aria-selected="false">
                            <i class="bi bi-list-check"></i>
                            List User
                        </button>
                    </li>
                </ul>
                <div class="tab-content" id="editUserTabContent">
                    <div class="tab-pane fade show active" id="form-tab-pane" role="tabpanel" aria-labelledby="form-tab"
                        tabindex="0">
                        <div class="card">
                            <div class="card-header align-items-center text-white" style="background-color: #727070;">
                                Update User Infomation
                            </div>
                            <div class="card-body">
                                <form action="">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-outline mb-3">
                                                <label class="form-label" for="editUserModalUsername">Username</label>
                                                <input type="text" id="editUserModalUsername"
                                                    name="editUserInputUsername" class="form-control" required>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="editUserModalPass">Password</label>
                                                <input type="password" id="editUserModalPass" minlength="8"
                                                    class="form-control" name="editUserInputPass" required>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="editUserModalFullname">Fullname</label>
                                                <input type="text" id="editUserModalFullname"
                                                    name="editUserInputFullname" class="form-control" required>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="editUserModalEmail">Email
                                                    Address</label>
                                                <input type="email" id="editUserModalEmail" class="form-control"
                                                    name="editUserInputEmail" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-end">
                                        <button class="btn btn-primary">Update</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="list-tab-pane" role="tabpanel" aria-labelledby="list-tab"
                        tabindex="0">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between align-items-center text-white"
                                style="background-color: #727070;">
                                List User
                                <button class="btn btn-primary">Thêm mới</button>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>Username</th>
                                            <th>Password</th>
                                            <th>Fullname</th>
                                            <th>Email</th>
                                            <th>Role</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>TeoNV</td>
                                            <td>123456</td>
                                            <td>Nguyễn Văn Tèo</td>
                                            <td>teonv@gmail.com</td>
                                            <td>Admin</td>
                                            <td>
                                                <a type="button" class="text-info">
                                                    Edit
                                                </a>
                                                <a class="m-2 text-danger" href="">Delete</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="d-flex justify-content-end">
                                    <a href="#" type="button" class="text-decoration-none m-2"><i
                                            class="bi bi-chevron-bar-left" style="font-size: 2rem;"></i></a>
                                    <a href="#" type="button" class="text-decoration-none m-2"><i
                                            class="bi bi-chevron-compact-left" style="font-size: 2rem;"></i></a>
                                    <a href="#" type="button" class="text-decoration-none m-2"><i
                                            class="bi bi-chevron-compact-right" style="font-size: 2rem;"></i></a>
                                    <a href="#" type="button" class="text-decoration-none m-2"><i
                                            class="bi bi-chevron-bar-right" style="font-size: 2rem;"></i></a>
                                </div>
                            </div>
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
                    <h5 class="modal-title text-info" id="editorEditProductModalLabel">Chỉnh sửa thông tin sản phẩm</h5>
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