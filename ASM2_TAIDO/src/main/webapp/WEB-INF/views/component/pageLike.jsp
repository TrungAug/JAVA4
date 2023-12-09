<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">

<style>
    img {
            height: 240px;
        }
        .col-lg-4 {
            height: 370px;
        }
         
    .card-title {
        overflow: hidden;
        text-overflow: ellipsis; /* Để hiển thị dấu ba chấm khi tiêu đề bị cắt ngắn */
        white-space: nowrap;
    }

</style>
</head>
<body class="bg-dark text-light">
  <nav class="navbar navbar-expand-lg border-bottom border-body bg-dark " data-bs-theme="dark">
    <div class="container">
        <!-- <a class="navbar-brand" href="#">Navbar</a> -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#PrimaryMenu"
            aria-controls="PrimaryMenu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse mt-lg-0 mt-md-3 mt-sm-2  " id="PrimaryMenu">
            <ul class="navbar-nav ">
                <li class="nav-item">

                    <a class="bean nav-link active border border-danger border-2 rounded-2 bg-danger fw-bold" aria-current="page" href="index.jsp">
                        <i class="bi bi-house"></i> BeanWibu</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="pageLike.jsp">
                        <i class="bi bi-grid-3x3-gap-fill"></i> Sở Thích</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        Tài Khoản
                    </a>
                    <ul class="dropdown-menu ">
                        <li><a class="dropdown-item " href="dangNhap.jsp">Đăng nhập</a>

                        </li>

                        <li><a class="dropdown-item "  
                                href="quenMatKhau.jsp">Quên mật khẩu </a>

                        </li>
                        <li><a class="dropdown-item"  
                                href="dangKy.jsp">Đăng ký</a></li>

                        <li><a class="dropdown-item " 
                                href="#">Đăng xuất</a>

                        </li>
                        <li><a class="dropdown-item "  
                                href="doiMatKhau.jsp">Đổi mật khẩu</a>

                        </li>
                        <li><a class="dropdown-item " 
                            
                                href="profile.jsp">Hồ sơ</a>

                        </li>
                    </ul>
                </li>
            </ul>
            <ul class="navbar-nav me-left">
                <li class="nav-item">
                    <a class="nav-link active" href="#">
                        Tìm Kiếm</a>
                </li>
                <li class="nav-item">

                    <input type="search" name="" id="search" class="form-control" placeholder="Tìm kiếm">
                </li>

            </ul>
            
        </div>
    </div>
</nav>



    <div class="main h-300 bg-dark " data-bs-theme="dark" >
        <div class="container ">
            <div class="row ">
    
                  <div class="col-lg-4 mt-3 ">
                    <div class="card " >
                      <a href="#">
                        <img src="./assets/images/9.webp"
                          class="card-img-top" alt="...">
                      </a>
                      <div class="card-body">
                        <h5 class="card-title">Chúa tể bóng tối</h5>
                
                        <div class="d-flex justify-content-center  align-items-center ">
                          <button class="btn btn-primary col-6 p-2 me-1 " type="button">Bỏ Yêu thích</button>
                          <button class="btn btn-danger col-6 p-2 ms-1 " type="button">Chia sẻ</button>
                        </div>
                      </div>
                    </div>
                  </div>
    
                  <div class="col-lg-4 mt-3">
                    <div class="card">
                      <a href="#">
                        <img src="./assets/images/10.jpg"
                          class="card-img-top" alt="...">
                      </a>
                      <div class="card-body">
                        <h5 class="card-title">Khiên hiệp sĩ</h5>
                
                        <div class="d-flex justify-content-center  align-items-center ">
                          <button class="btn btn-primary col-6 p-2 me-1 " type="button"> Bỏ Yêu thích</button>
                          <button class="btn btn-danger col-6 p-2 ms-1 " type="button">Chia sẻ</button>
                        </div>
                      </div>
                    </div>
                  </div>
    
                  <div class="col-lg-4 mt-3">
                    <div class="card">
                      <a href="#">
                        <img src="./assets/images/2.jpg"
                          class="card-img-top" alt="...">
                      </a>
                      <div class="card-body">
                        <h5 class="card-title">Chú thuật hồi chiến p2</h5>
                
                        <div class="d-flex justify-content-center  align-items-center ">
                        <button class="btn btn-primary col-6 p-2 me-1 " type="button">Bỏ Yêu thích</button>
                          <button class="btn btn-danger col-6 p-2 ms-1 " type="button">Chia sẻ</button>
                        </div>
                      </div>
                    </div>
                  </div>
    
                  
                 
                  
    
               
    
            </div>
            
            
    
        </div>
    
    
    </div>



    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>