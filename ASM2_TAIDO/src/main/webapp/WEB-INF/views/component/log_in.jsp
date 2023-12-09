<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
   .background-radial-gradient {
    background-image: url("https://i.pinimg.com/originals/c2/09/09/c209094526a6d5b3f6f9eef251697c22.jpg");
    background-repeat:no-repeat ;
     
    height: 100vh;
  }

   
</style>
 <c:url var="url" value="/log_in" />
	 
	<!-- 
	<form action="${url}" method =post> 
		<label  for="userName" > Username</label>
		<input id="userName" name="username" required >
		<br>
		<label  for="userPass" >Password</label>
		<input type="password" id="userPass" name="password" required >
		<br>
		<button>Login</button>
	</form>
     -->

  <form  action="${url}" method ="post" class="needs-validation background-radial-gradient mb-lg-0 position-relative  overflow-hidden" novalidate   >

   
    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
  <!-- style=" background: #6a11cb;
 background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
 background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))" -->
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card bg-dark text-white" style="border-radius: 1rem;">
            <div class="card-body p-5 text-center" name="card_body">
  
              <div class="mb-md-5 mt-md-4 pb-3">
  
                <h2 class="fw-bold mb-2 text-uppercase">${infor}</h2>
                <p class="text-white-50 mb-5">Vui lòng đăng nhập bằng User và Password!</p>
  
                <div class="form-outline form-white mb-4">
                    <span ng-show="card_body.txtEmail.$invalid">
                      <div  class="text-danger">	
                        * Vui lòng nhập đúng định dạng   *
                      </div> 
                    </span>
                  <input type="text" name="id" id="typeAccount"  class="form-control form-control-lg" required>
                  <label class="form-label" for="typeAccount">UserName</label>
                </div>
  
                <div class="form-outline form-white mb-4">
                  <span ng-show="card_body.txtPass.$invalid">
                    <div  class="text-danger">
                       Vui lòng nhập Password  *
                    </div> 
                  </span>
                  <input type="password" id="typePasswordX"  name="password" class="form-control form-control-lg" required />
                  <label class="form-label" for="typePasswordX">Password</label>
                </div>
  
                <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!quenMatKhau">Quên mật khẩu?</a></p>
  
                <button    class="btn btn-outline-light btn-lg px-5" type="submit" ">Đăng nhập</button>
   
  
              </div>
 
              <div>
                <p class="mb-0">Bạn chưa có tài khoản? <a href=" <c:url value="/signUp"/>" class="text-white-50 fw-bold">Đăng ký</a>
                </p>
              </div>
  
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
 
