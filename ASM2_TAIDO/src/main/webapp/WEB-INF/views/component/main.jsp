<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
   
 <c:set var="uri" value="${pageContext.request.contextPath}" scope="request"></c:set>

       <div class="main bg-dark " data-bs-theme="dark">
        <div class="container">
        
            <div id="carouselMainSlide" class="carousel slide  mb-3" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="2000">
        
                        <img src="https://s199.imacdn.com/vg/2023/10/15/e32641f33487f998_2b1d3f948372a608_38325216973670791118684.jpg"
                            class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="1500">
                        <img src="https://s199.imacdn.com/vg/2023/10/15/7bac44895edb79c9_807067c3c7a31730_180643916973690093118684.jpg"
                            class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="1500">
                        <img src="https://cdn.wallpapersafari.com/34/29/8NpjeV.jpg"
                            class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="1500">
                        <img src="https://i.pinimg.com/originals/44/19/79/4419795d7faf541dd2d70c8c82273154.jpg"
                            class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="1500">
                        <img src="https://static0.gamerantimages.com/wordpress/wp-content/uploads/2022/02/Cover-Art-For-The-Eminence-In-Shadow.jpg"
                            class="d-block w-100" alt="...">
                    </div>
        
        
                    <button class="carousel-control-prev"  type="button" data-bs-target="#carouselMainSlide"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselMainSlide"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
        
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselMainSlide" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselMainSlide" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselMainSlide" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                            <button type="button" data-bs-target="#carouselMainSlide" data-bs-slide-to="3"
                            aria-label="Slide 4"></button>
                            <button type="button" data-bs-target="#carouselMainSlide" data-bs-slide-to="4"
                            aria-label="Slide 5"></button>
                        <!-- <button type="button" data-bs-target="#carouselMainSlide" data-bs-slide-to="2" aria-label="Slide 3"></button> -->
                    </div>
                </div>
            </div>
           
           
            <div class="row">





<c:forEach var="item" items="${items}">
                <div class="col-lg-4 mt-3">
                    <div class="card d-flex flex-column" style="height: 350px;">
                        <a href="${uri }/chiTietPage/index/${item.id}">
                            <img src="${item.poster}" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <h5 class="card-title">${item.title}</h5>

                            <div class="d-flex justify-content-center  align-items-center ">
                                <!-- Trong main.jsp -->
			  <button class="btn btn-primary col-6 p-2 me-1 add-favorite" type="button" data-id="${item.id}">Yêu thích</button>

                                <button class="btn btn-danger col-6 p-2 ms-1 " type="button">Chia sẻ</button>
                            </div>
                        </div>
                    </div>
                </div>
</c:forEach>
                



                <div class="col-lg-12 mt-3  d-flex justify-content-center  align-items-center ">
                    <ul>
                        <li class="btn btn-warning">Đầu</li>
                        <li class="btn btn-danger">1</li>
                        <li class="btn btn-danger">2</li>
                        <li class="btn btn-danger">3</li>
                        <li class="btn btn-danger">4</li>
                        <li class="btn btn-warning">Cuối</li>
                    </ul>
                    <!-- <a href="#" class="btn btn-success col-lg-1 p-2 me-1 "> First </a>
                    <a href="#" class="btn btn-success col-lg-1 p-2 me-1"> Prev </a>
                    <a href="#" class="btn btn-success col-lg-1 p-2 me-1"> Next </a>
                    <a href="#" class="btn btn-success col-lg-1 p-2 me-1"> Last </a> -->


                </div>

            </div>



        </div>


    </div>

 
<script>
    $(document).ready(function () {
        $(".add-favorite").on("click", function () {
            var videoId = $(this).data("id");

            $.ajax({
                type: "POST",
                url: "${uri}/favorite",
                data: {videoId: videoId},
                success: function (data) {
                    console.log(data);
                    alert("Đã thêm vào danh sách yêu thích!");
                },
                error: function () {
                    alert("Có lỗi xảy ra!");
                }
            });
        });
    });
</script>




   