<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>THÔNG TIN NHÂN VIÊN</title>
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
                            <h4>ĐĂNG KÝ THÔNG TIN</h4>
                        </div>
                    </div>
                    <div class="card-body">
                        <form action="staffform" method="post" enctype="multipart/form-data">
                            <label for="fullnameInput" class="form-label">Họ và Tên :</label>
                            <input type="text" class="form-control" id="fullnameInput" name="fullname">
                            <br>
                            <label for="imgInput" class="form-label">Hình ảnh:</label>
                            <input type="file" class="form-control" id="imgInput" name="photo_file">
                            <br>
                            <label for="birthdayInput" class="form-label">Ngày sinh:</label>
                            <input type="date" class="form-control" id="birthdayInput" name="birthday">
                            <br>
                            <label for="QuocTichInput" class="form-label">Quốc tịnh:</label>
                            <select name="country" class="form-select" id="QuocTichInput">
                                <option value="VN">Việt Nam</option>
                                <option value="US">United States</option>
                            </select>
                            <br>

                            <label class="form-label">Giới tính:</label>
                            <input name="gender" type="radio" value="true">Nam
                            <input name="gender" type="radio" value="false">Nữ
                            <br>
                            <label for="marriedInput" class="form-label">Tình trạng hôn nhân:</label>
                            <input class="form-check-label" id="marriedInput" name="married" type="checkbox"> Đã có gia
                            đình?
                            <br>
                            <label class="form-label">Sở thích:</label>
                            <input class="form-check-label" name="hobbies" type="checkbox" value="R"> Đọc sách
                            <input class="form-check-label" name="hobbies" type="checkbox" value="T"> Du lịch
                            <input class="form-check-label" name="hobbies" type="checkbox" value="M"> Âm nhạc
                            <input class="form-check-label" name="hobbies" type="checkbox" value="O"> Khác
                            <br>

                            <label for="notesInput" class="form-label">Ghi chú:</label>
                            <textarea class="form-control" id="notesInput" name="notes" rows="3" cols="30"></textarea>
                            <hr>
                            <button class="btn btn-primary">Thêm mới</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>

</html>