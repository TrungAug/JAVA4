<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
 
 
    <nav class=" navbar navbar-expand-lg bg-dark border-bottom border-body " data-bs-theme=" dark">
        <div class="container">
            <!-- <a class="navbar-brand" href="#">Navbar</a> -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#PrimaryMenu"
                aria-controls="PrimaryMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="PrimaryMenu">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item border border-warning">

                        <a class="nav-link active  text-warning" aria-current="page" href="<c:url value="/admin"/> ">
                            <i class="bi bi-house"></i>  <fmt:message key = "admin" />  </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/admin"/>">
                            <i class="bi bi-grid-3x3-gap-fill"></i> Videos</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/adminQlyNgDung/index"/>">
                            <i class="bi bi-telephone-fill"></i> Người dùng</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/adminThongKe"/>">Báo Cáo</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/home"/>">Trang người dùng</a>
                    </li>
 
                </ul>

                <ul class="navbar-nav me-left">


                </ul>
            </div>
        </div>
    </nav>

 