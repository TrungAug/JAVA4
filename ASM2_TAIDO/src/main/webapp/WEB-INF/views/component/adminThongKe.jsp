<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="container">
        <div class="row">
            <!-- Tabs navs -->
            <ul class="nav nav-tabs mb-3" id="ex1" role="tablist">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" id="ex1-tab-1" data-bs-toggle="tab" href="#ex1-tabs-1" role="tab"
                        aria-controls="ex1-tabs-1" aria-selected="true">Yêu Thích</a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="ex1-tab-2" data-bs-toggle="tab" href="#ex1-tabs-2" role="tab"
                        aria-controls="ex1-tabs-2" aria-selected="false">Người Yêu Thích</a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="ex1-tab-3" data-bs-toggle="tab" href="#ex1-tabs-3" role="tab"
                        aria-controls="ex1-tabs-3" aria-selected="false">Chia sẽ Bạn Bè</a>
                </li>
            </ul>
            <!-- Tabs navs -->

            <!-- Tabs content -->
            <div class="tab-content" id="ex1-content">
                <div class="tab-pane fade show active" id="ex1-tabs-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                    <table class="table">
                        <!-- Tab1 -->
                        <thead>
                            <tr>
                                <th scope="col">Tiêu Đề</th>
                                <th scope="col">Số Lượt Thích</th>
                                <th scope="col">Mới Nhất</th>
                                <th scope="col">Cũ Nhất</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Jujust No Kaisen</th>
                                <td>100</td>
                                <td>12/12/2023</td>
                                <td>10/08/2020</td>
                            </tr>
                            <tr>
                                <th scope="row">Jujust No Kaisen</th>
                                <td>100</td>
                                <td>12/12/2023</td>
                                <td>10/08/2020</td>
                            </tr>
                            <tr>
                                <th scope="row">Jujust No Kaisen</th>
                                <td>100</td>
                                <td>12/12/2023</td>
                                <td>10/08/2020</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="col-lg-12 mt-3  d-flex justify-content-center  align-items-center ">
                        <ul>
                            <li class="btn btn-warning">|<</li>
                            <li class="btn btn-danger"><<</li>
                            <li class="btn btn-danger">>></li>
                            <li class="btn btn-warning">>|</li>
                            
                        </ul>
                    </div>

                </div>
                <div class="tab-pane fade" id="ex1-tabs-2" role="tabpanel" aria-labelledby="ex1-tab-2">
         
                        <div class="Look_title" >
                            <div class="row">
                                <div class="col-12">
                                    <input type="search" name="" id="search" class="form-control  border border-danger" placeholder="Tên Phim">
                                </div>
                             
                            </div>                           
                        </div>                 
                    <table class="table">
                        <!-- tab2 -->
                        <thead>
                            <tr>
                                <th scope="col">Tên Tài Khoản</th>
                                <th scope="col">Tên Người Dùng</th>
                                <th scope="col">Email</th>
                                <th scope="col">Ngày Yêu Thích</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">TaiCm</th>
                                <td>Bean</td>
                                <td>bb@gmail.com</td>
                                <td>10/10/2022</td>
                            </tr>
                            <tr>
                                <th scope="row">TaiCm</th>
                                <td>Bean</td>
                                <td>bb@gmail.com</td>
                                <td>10/10/2022</td>
                            </tr>
                            </tr>
                            <tr>
                                <th scope="row">TaiCm</th>
                                <td>Bean</td>
                                <td>bb@gmail.com</td>
                                <td>10/10/2022</td>
                            </tr>
                            </tr>
                        </tbody>
                    </table>
                    <div class="col-lg-12 mt-3  d-flex justify-content-center  align-items-center ">
                        <ul>
                            <li class="btn btn-warning">|<</li>
                            <li class="btn btn-danger"><<</li>
                            <li class="btn btn-danger">>></li>
                            <li class="btn btn-warning">>|</li>
                            
                        </ul>
                    </div>

                </div>
                <div class="tab-pane fade" id="ex1-tabs-3" role="tabpanel" aria-labelledby="ex1-tab-3">
                    <div class="Look_title" >
                        <div class="row">
                            <div class="col-12">
                                <input type="search" name="" id="search" class="form-control  border border-danger" placeholder="Tên Phim">
                            </div>
                         
                        </div>
                       
    

                    </div>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Tên Người Gửi</th>
                                <th scope="col">Email Người Gửi</th>
                                <th scope="col">Email Người Nhận</th>
                                <th scope="col">Ngày Gửi</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">ĐÔN KI HÔ TÊ</th>
                                <td>BB@gmail.com</td>
                                <td>OCD@gmail.com</td>
                                <td>20/11/2022</td>
                            </tr>
                            <tr>
                                <tr>
                                    <th scope="row">ĐÔN KI HÔ TÊ</th>
                                    <td>BB@gmail.com</td>
                                    <td>OCD@gmail.com</td>
                                    <td>20/11/2022</td>
                                </tr>
                            </tr>
                            <tr>
                                <tr>
                                    <th scope="row">ĐÔN KI HÔ TÊ</th>
                                    <td>BB@gmail.com</td>
                                    <td>OCD@gmail.com</td>
                                    <td>20/11/2022</td>
                                </tr>
                            </tr>
                        </tbody>
                    </table>
                    <div class="col-lg-12 mt-3  d-flex justify-content-center  align-items-center ">
                        <ul>
                            <li class="btn btn-warning">|<</li>
                            <li class="btn btn-danger"><<</li>
                            <li class="btn btn-danger">>></li>
                            <li class="btn btn-warning">>|</li>
                            
                        </ul>
                    </div>

                </div>
            </div>
            <!-- Tabs content -->
        </div>
    </div>

  