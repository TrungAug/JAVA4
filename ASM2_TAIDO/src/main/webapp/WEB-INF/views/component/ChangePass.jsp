<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
  <c:url var="url" value="/changePass" />
 
 <c:set var="uri" value="${pageContext.request.contextPath}" scope="request"></c:set>
<style>
   
  .background-radial-gradient {
    background-image: url("https://rare-gallery.com/uploads/posts/905491-Son-Goku-anime-saiyan-Dragon-Ball-Z-digital-art.jpg");
    background-repeat:no-repeat ;
    background-size: cover;
    height: 100vh;
  }


 
  .bg-glass {
    color: white;
    background-color: #212529 !important;
    backdrop-filter: saturate(200%) blur(25px);
  }
</style>
</head>
<body>







    <!-- Section: Design Block -->
<section class="background-radial-gradient overflow-hidden">
  

  <div class="container px-4   px-md-5 text-center text-lg-start my-5  d-flex justify-content-center  ">
    <div class="row col-12 col-md-8 col-lg-6 col-xl-5 align-items-center mb-5">


      <div class="col-lg-12 mb-5 mb-lg-0 position-relative ">
         

        <div class="card bg-glass  ">
            <div class="card-header bg-danger text-light d-flex justify-content-center  fw-bold ">
                <div class="card-title  my-2">
                    <h4>${infor }</h4>
                </div>
            </div>
          <div class="card-body px-4 py-5 px-md-5">
            <form action="${url}" method ="post">
              <!-- 2 column grid layout with text inputs for the first and last names -->
              <div class="row">

                <div class="form-outline  mb-4">                
                
                  <input type="text" id="form3Example1" name="id"  value="${account.id}" class="form-control"
                     required />              
                    <label class="form-label" for="form3Example1">Tên tài khoản</label>
                </div>


              </div>
 

              <!-- Password input -->
            
              <div class="form-outline mb-4">
                <input type="password" id="form3Example4" name="password"   class="form-control"
                   required />
                <label class="form-label" for="form3Example4">Mật khẩu hiện tại</label>
              </div>

              
              <div class="form-outline mb-4">
                <input type="password" id="form3Example4" name="password1" class="form-control"
                   required />
                <label class="form-label" for="form3Example4">Mật khẩu thay đổi</label>
              </div>
              
              <div class="form-outline mb-4">
                <input type="password" id="form3Example4" name="password2" class="form-control"
                 required />
                <label class="form-label" for="form3Example4">Xác nhận mật khẩu thay đổi</label>
              </div>

              <!-- Checkbox -->
              <div class="form-check d-flex justify-content-center mb-4">
                <input class="form-check-input me-2" type="checkbox" value="" id="form2Example33" checked />
                <label class="form-check-label" for="form2Example33">
                  Nhớ mật khẩu
                </label>
              </div>

              <!-- Submit button -->

              <!-- <button type="submit" class="btn btn-primary mb-4 me-auto">
                Sign up
              </button> -->
              <div class="form-outline mb-4 d-flex justify-content-center">
                <button   class="btn btn-outline-light btn-lg  " type="submit">Đổi mật khẩu</button>
              </div>
              <!-- Register buttons -->
              <div class="text-center">
                <a href=" <c:url value="/home"/>" class="text-white-50 fw-bold  d-flex justify-content-center">Quay lại trang chủ</a>
                 
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->


    


