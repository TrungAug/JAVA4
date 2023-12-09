<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<style>
    .background-radial {
     background-image: url("https://cdn.wallpapersafari.com/34/29/8NpjeV.jpg");
     background-repeat:no-repeat ;
     background-size: cover;
     height: 100vh;
     
   }
    
 
    
 </style>

    <div class="container-fruid background-radial d-flex justify-content-center align-items-center">

        <div class="row">
            <div class="col-lg-12 ">
                <div class="card text-center bg-dark text-light" style="width: 300px;">
                    <div class="card-header h5 text-white bg-danger"  >Quên mật
                        khẩu!!
                    </div>
                    <form action="" name="formforget">
                        <div class="card-body px-5" >
    
                            <p class="card-text py-2">
                                Vui lòng nhập địa chỉ Email bạn đã đăng ký
                            </p>
                            <div class="form-outline"> <small ng-show="formforget.email.$invalid" class=" text-danger" >nhập Email</small>
                                <input type="email" id="typeEmail" name="email" ng-model="email" class="form-control my-3" required />
                                <label class="form-label" for="typeEmail">Nhập Email</label>
                                
                            </div>
                            <div class="form-outline">
                                <div class="form-outline"> <small ng-show="formforget.password.$invalid" class=" text-danger" >nhập mật khẩu đã quên</small>
                            <input type="password" name="password" ng-model="password" id="typeEmail" class="form-control my-3" required />
                            <label class="form-label" for="typeEmail">Nhập Password bạn đã quên!</label>
    
                        </div>
                        <button ng-click="quenMatKhau()" type="button" class="btn btn-primary w-100" style="background-color: #212529 !important;">Reset
                            password</button>
                    </form>
                    <div class="d-flex justify-content-between mt-4">
                        <a href="dangNhap.jsp" class="text-danger  fw-bold">Đăng nhập</a>
                        <a href="dangKy.jsp" class="text-danger fw-bold">Đăng ký</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

    
 
