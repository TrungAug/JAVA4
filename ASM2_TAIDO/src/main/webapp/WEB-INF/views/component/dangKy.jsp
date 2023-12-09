<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<style>
   
  .background-radial-gradient {
    background-image: url("https://c.wallhere.com/photos/19/c6/anime_Tokyo_Ghoul_Kaneki_Ken-30562.jpg!d");
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
 






    <!-- Section: Design Block -->
<section class="background-radial-gradient overflow-hidden">
  

  <div class="container px-4   px-md-5 text-center text-lg-start my-5  d-flex justify-content-center  ">
    <div class="row col-12 col-md-8 col-lg-6 col-xl-5 align-items-center mb-5">


      <div class="col-lg-12 mb-5 mb-lg-0 position-relative">
        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

        <div class="card bg-glass ">
          <div class="card-body px-4 py-5 px-md-5">
            <form action="${pageContext.request.contextPath}/signUp" method="post" name="formDangKy">
              <!-- 2 column grid layout with text inputs for the first and last names -->
              <div class="row">
				<div class="form-outline  mb-4">
                  	  
                  <h3 class="form-label text-danger" for="form3Example1">${infor}</h3>
                </div>
                <div class="form-outline  mb-4">
                  	    <input type="text" id="form3Example01" name="id" class="form-control"
                     required />
                  <label class="form-label" for="form3Example01">user name</label>
                </div>
                
                <div class="form-outline  mb-4">
                  	    <input type="text" id="form3Example02" name="fullname" class="form-control"
                    required />
                  <label class="form-label" for="form3Example02">Full name</label>
                </div>


              </div>

              <!-- Email input -->
              <div class="form-outline mb-4">
                
                <input type="email" id="form3Example33" name="email" class="form-control" required />
				<label class="form-label" for="form3Example33">Email address</label>

              </div>

              <!-- Password input -->
                <div class="form-outline mb-4">
                <input type="password" id="form3Example4" name="password" class="form-control"
                   required />
                <label class="form-label" for="form3Example4">Password</label>
              </div>


				 <div class="form-check">
                <input class="form-check-input" type="radio" name="admin" value="true" id="adminCheck1">
                <label class="form-check-label" for="adminCheck1" >
                 Admin
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="admin" value="false" id="adminCheck2"    >
                <label class="form-check-label" for="adminCheck2" >
                User
                </label>
              </div>

               

              <!-- Submit button -->

              <!-- <button type="submit" class="btn btn-primary mb-4 me-auto">
                Sign up
              </button> -->
              <div class="form-outline mb-4 d-flex justify-content-center">
                <button class="btn btn-outline-light btn-lg  "  type="submit">Đăng ký</button>
              </div>
              <!-- Register buttons -->
              <div class="text-center">
                <a href="<c:url value="/log_in"/>" class="text-white-50 fw-bold  d-flex justify-content-center">Quay trở lại đăng
                  nhập:</a>
                <!-- <button type="button" class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-facebook-f"></i>
                </button>

                <button type="button" class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-google"></i>
                </button>

                <button type="button" class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-twitter"></i>
                </button>

                <button type="button" class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-github"></i>
                </button> -->
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->


   