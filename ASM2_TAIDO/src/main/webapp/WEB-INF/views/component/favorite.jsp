<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
   
 <c:set var="uri" value="${pageContext.request.contextPath}" scope="request"></c:set>

       <div class="main bg-dark " data-bs-theme="dark">
        <div class="container">
        
           
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
                                <button class="btn btn-primary col-6 p-2 me-1 " type="button">Bỏ yêu thích</button>
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





   