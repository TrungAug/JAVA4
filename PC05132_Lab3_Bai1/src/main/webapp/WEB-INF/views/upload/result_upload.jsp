<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KẾT QUẢ UPLOAD</title>
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
                            <h1>KẾT QUẢ UPLOAD</h1>
                        </div>
                    </div>
                    <div class="card-body">
                        <h2>1. Hình: ${img.name}</h2>
                        <img src="./files/${img.name}" class="img-thumbnail" height="100">
                        <h2>2. Tài liệu: ${doc.name}</h2>
                        <a href="./files/${doc.name}">Tải về</a>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>

</html>