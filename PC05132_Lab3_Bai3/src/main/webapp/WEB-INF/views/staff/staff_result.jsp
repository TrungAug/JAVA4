<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12">
                <div class="card bg-success">
                    <div class="card-heard">
                        <div class="card-title">
                            <h1>KẾT QUẢ ĐĂNG KÝ</h1>
                        </div>
                    </div>
                    <div class="card-body">
                        <ul>
                            <li>Họ và tên: <b>${newbean.fullname}</b></li>
                            <li>Hình ảnh: <b>${newbean.photo}</b></li>
                            <li><img src="./files/${newbean.photo}" height="100"></li>
                            <li>Ngày sinh: <b>${newbean.birthday}</b></li>
                            <li>Giới tính: <b>${newbean.gender?"Nam":"Nữ"}</b></li>
                            <li>Quốc tịch: <b>${newbean.country}</b></li>
                            <li>TT Hôn nhân: <b>${newbean.married?"Đã kết hôn":"Độc thân"}</b></li>
                            <li>Sở thích: <b>${newbean.hobbies}</b></li>
                            <li>Ghi chú: <b>${newbean.notes}</b></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>

</html>