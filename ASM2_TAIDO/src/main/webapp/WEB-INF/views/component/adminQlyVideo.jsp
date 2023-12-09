<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <c:set var="uri" value="${pageContext.request.contextPath}" scope="request"></c:set>
	
    <div class="container">
        <div class="row">
            <!-- Tabs navs -->
            <ul class="nav nav-tabs mb-3" id="ex1" role="tablist">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" id="ex1-tab-1" data-bs-toggle="tab" href="#ex1-tabs-1" role="tab"
                        aria-controls="ex1-tabs-1" aria-selected="true">
                        <!-- Tab 1 -->
                        Chỉnh Sửa


                    </a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="ex1-tab-2" data-bs-toggle="tab" href="#ex1-tabs-2" role="tab"
                        aria-controls="ex1-tabs-2" aria-selected="false">
                        <!-- Tab 2 -->
                        Danh Sách
                    </a>
                </li>

            </ul>
            <!-- Tabs navs -->

            <!-- Tabs content -->
            <div class="tab-content" id="ex1-content">
                <form action="${uri}/admin" method="post"  class="tab-pane fade show active" id="ex1-tabs-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                    <!-- Tab 1 content -->
                    <div class="card " ng-controller="profileMang ">

                        <div class="card-body ">
                            <div class="row ">
                                <!-- 0 -->

                                <div class="col-lg-2 col-sm-12 mb-3">
                                    <img src="${form.poster}" class="img-thumbnail" alt="...">

                                </div>
                                <div class="col-lg-10 col-sm-12">

                                    <div class="row  d-flex justify-content-center">
                                        <div class="col-lg-12">
                                           
                                                <div class="form-group mb-3">
                                                    <label for="">ID Youtube ?</label>
                                                    <input type="text" name="id"  value="${form.id}" class="form-control">
                                                  
                                                </div>

                                                <div class="form-group mb-3">
                                                    <label for="">Video Title</label>
                                                    <input type="text" name="title"  value="${form.title}" class="form-control">
                                                  
                                                </div>
                                                <div class="form-group mb-3">
                                                    <label for="">Poster</label>
                                                     <input type="text" name="poster"  value="${form.poster}" class="form-control">
                                                  
                                                </div>

                                                <div class="form-group mb-3">
                                                    <label for="">Views</label>
                                                     <input type="number" name="views"  value="${form.views}" class="form-control">
                                                  
                                                </div>
                                                
                                                <div class="form-group mb-3">
                                                    <label for="">Link Video</label>
                                                     <input type="text" name="genre"  value=" ${form.genre}" class="form-control">
                                                  
                                                </div>
                                                
                                            <div class="form-check">
										    <input ${form.active ? 'checked' : ''} value="true" class="form-check-input" type="radio" name="active" id="activeRadio">
										    <label class="form-check-label" for="activeRadio"> Active </label>
										</div>
										<div class="form-check">
										    <input ${form.active ? '' : 'checked'} value="false" class="form-check-input" type="radio" name="active" id="inactiveRadio">
										    <label class="form-check-label" for="inactiveRadio"> InActive </label>
										</div>
										

                                            
                                        </div>

                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <label for="">Mô tả</label>
                                    <textarea class="form-control" name="description" id="" cols="30" rows="10">${form.description}</textarea>
                                </div>
                            </div>

                            <!-- 1 -->



                                  <c:url var="url" value="/admin"/>

                        </div>
                         <div class="card-footer  d-flex justify-content-end">
                                           
									<button formaction="${url}/create"  type="submit" class="btn btn-danger me-2">Create</button>
									<button formaction="${url}/update"  type="submit" class="btn btn-danger me-2">Update</button>
									<button formaction="${url}/delete"  type="submit" class="btn btn-danger me-2">Delete</button>
									<button formaction="${url}"   type="submit" class="btn btn-danger me-2">reset</button>
									 </div>

                    </div>

                </form>





            </div>

            <!-- Tab 2 -->
            <div class="tab-pane fade" id="ex1-tabs-2" role="tabpanel" aria-labelledby="ex1-tab-2">

                <table class="table table-dark table-striped">
                    <thead>
                        <tr>
                            <th scope="col">ID Youtube</th>
                            <th scope="col">Tiêu Đề</th>
                            <th scope="col">Lượt Xem</th>
                            <th scope="col">Trạng thái</th>

                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${items}" >
                            <tr>
                                <th scope="row">${item.id }</th>
                                <td>${item.title}</td>
                                <td>${item.views}</td>                        
                                <td>${item.active?'Active':'inActive'} </td>
                                <td>
                                    <a href="${uri}/admin/edit/${item.id}">edit</a>
                                </td>
                            </tr>
                            </c:forEach>
                         
                    </tbody>
                     
                </table>
                <div class="col-lg-12 mt-3  d-flex justify-content-center  align-items-center ">
                    <ul>
                        <li class="btn btn-warning">|<</li>
                        <li class="btn btn-danger"><<</li>
                        <li class="btn btn-danger">>></li>
                        <li class="btn btn-warning">>|</li>
                        
                    </ul>
                    <!-- <a href="#" class="btn btn-success col-lg-1 p-2 me-1 "> First </a>
                    <a href="#" class="btn btn-success col-lg-1 p-2 me-1"> Prev </a>
                    <a href="#" class="btn btn-success col-lg-1 p-2 me-1"> Next </a>
                    <a href="#" class="btn btn-success col-lg-1 p-2 me-1"> Last </a> -->


                </div>
            </div>

        </div>
        <!-- Tabs content -->
    </div>
     
 