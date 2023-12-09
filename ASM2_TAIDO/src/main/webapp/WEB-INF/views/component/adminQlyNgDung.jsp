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
    <c:url var="url" value="/adminQlyNgDung"/>
                <!-- Tabs content -->
                <div class="tab-content" id="ex1-content">
                    <div class="tab-pane fade show active" id="ex1-tabs-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                        <!-- Tab 1 content -->
                        <div class="container align-items-center " >
                            <div class="row  d-flex justify-content-center">
                                <div class="col-lg-8 ">
                                    <form action="${uri}/adminQlyNgDung/index" method="post" class="card " ng-controller="calculateController"  >
                                       	
                                	<h1 class="  text-danger m-auto">${message}</h1>
                                        <div class="card-body container">
                                            <div class="row">
                                                <div class="col-lg-6">
                                                    <div class="mb-3">
                                                        <label for="">Tên Tài Khoản</label>
                                                         
                                                        <input type="text" name="id"  value="${form.id}" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <div class="mb-3">
                                                        <label for="">Mật Khẩu</label>
                                                        <input type="password" name="password" value="${form.password }" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <div class="mb-3">
                                                        <label for="">Họ và Tên</label>
                                                        <input type="text" name="fullname"  value="${form.fullname }" class="form-control" >
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <div class="mb-3">
                                                        <label for="">Địa chỉ Email</label>
                                                        <input type="email" name="email"  value="${form.email}" class="form-control" >
                                                    </div>
                                                </div>
                                                <div class="form-check">
													<input ${form.admin?'checked':''} value="true"
														class="form-check-input" type="radio" name="admin" id="">
													<label class="form-check-label" for=""> Admin </label>
												</div>
												<div class="form-check">
													<input ${form.admin?'':'checked'} value="false"
														class="form-check-input" type="radio" name="admin" id="">
													<label class="form-check-label" for=""> User </label>
												</div>
                                
                                            </div>
                                
                                           
                                        </div>
                                        <div class="card-footer  d-flex justify-content-end">
                                           
									<button formaction="${url}/create"  type="submit" class="btn btn-danger me-2">Create</button>
									<button formaction="${url}/update"  type="submit" class="btn btn-danger me-2">Update</button>
									<button formaction="${url}/delete"  type="submit" class="btn btn-danger me-2">Delete</button>
									<button formaction="${url}/index"   type="submit" class="btn btn-danger me-2">reset</button>
									 </div>
									 </form>
                                    </div>
                    
                                
                            </div>
                            
                        </div>
    
                    </div>
    
    
    
    
    
                </div>
    
                <!-- Tab 2 -->
                <div class="tab-pane fade" id="ex1-tabs-2" role="tabpanel" aria-labelledby="ex1-tab-2">
    
                    <table class="table table-dark table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Tên Tài Khoản</th>
                                <th scope="col">Mật Khẩu</th>
                                <th scope="col">Họ và Tên</th>
                                <th scope="col">Địa chỉ Email</th>
                                <th scope="col">Vai trò</th>
    							<th></th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="item" items="${items}" >
                            <tr>
                                <th scope="row">${item.id }</th>
                                <td>${item.password }</td>
                                <td>${item.fullname }</td>
                                <td>${item.email }</td>
                                <td>${item.admin?'admin':'user'} </td>
                                <td>
                                    <a href="${uri}/adminQlyNgDung/edit/${item.id}">edit</a>
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


  