<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UPLOAD HÌNH ẢNH, TÀI LIỆU</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12">
                <div class="card bg-info">
                    <div class="card-heard">
                        <div class="card-title">
                            <h1>UPLOAD HÌNH ẢNH, TÀI LIỆU</h1>
                        </div>
                    </div>
                    <div class="card-body">
                        <form action="upload" method="post" enctype="multipart/form-data">
                            <label for="imgInput" class="form-label">Hình ảnh: </label>
                            <input class="form-control" id="imgInput" type="file" name="photo_file">
                            <br>
                            <label for="docInput" class="form-label">Tài Liệu: </label>
                            <input class="form-control" id="docInput" type="file" name="doc_file">
                            <hr>
                            <button class="btn btn-primary">Upload</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>

</html>