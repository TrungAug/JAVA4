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
        <%@ include file="/WEB-INF/views/component/header-admin.jsp" %>
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
                    <p class="text-danger" id="messageInfoProd">${message}</p>
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
                                            Delete product
                                        </a>
                                    </div>
                                    <div class="col">
                                        <a type="button" href="${url}/create-edit" class="text-info" data-bs-toggle="modal"
                                            data-bs-target="#editorEditProductModal">
                                            Edit product
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
	<%@ include file="/WEB-INF/views/component/modal-change-product.jsp"%>
    <!-- Modal Trang Editor cho nút Edit Product--> 
	<%@ include file="/WEB-INF/views/component/modal-edit-product.jsp"%>
    <!-- Modal Trang Editor cho nút AddSize-->
	<%@ include file="/WEB-INF/views/component/modal-add-size.jsp"%>
    <!-- Modal Trang Editor cho nút EditSize-->
    <%@ include file="/WEB-INF/views/component/modal-edit-size.jsp"%>
    <!-- Modal Trang Editor cho nút AddProduct-->
	<%@ include file="/WEB-INF/views/component/modal-add-product.jsp"%>
	
	<script>
		setTimeout(function() {
			document.getElementById('messageInfoProd').style.display = 'none';
		}, 4000);
	</script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>