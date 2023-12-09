<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!--  
<a href="<c:url   value="/home"  />"    >
				<fmt:message key = "home" />
					</a>
					
			<a href="<c:url    value="/about"  />"  >
				<fmt:message key = "about" /> 	
					</a>
					
			<a href="<c:url    value="/contact"  />" >
				<fmt:message key = "contact" />
					</a>
 -->
 
 
 
     <nav class="navbar navbar-expand-lg border-bottom border-body bg-dark " data-bs-theme="dark">
        <div class="container">
            <!-- <a class="navbar-brand" href="#">Navbar</a> -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#PrimaryMenu"
                aria-controls="PrimaryMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse mt-lg-0 mt-md-3 mt-sm-2  " id="PrimaryMenu">
                <ul class="navbar-nav ">
                    <li class="nav-item">
 
					 
                        <a class="bean nav-link active border border-danger border-2 rounded-2 bg-danger fw-bold" aria-current="page" href="<c:url value="/home"/>">
                            <i class="bi bi-house"></i> <fmt:message key = "home" />    	</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="<c:url value="/favorite"/>"  >
                            <i class="bi bi-grid-3x3-gap-fill"></i>   <fmt:message key = "favorite" /></a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Tài Khoản 
                        </a>
                        <ul class="dropdown-menu ">
                     <c:if test="${  empty account}">
                                <li><a class="dropdown-item " href="<c:url value="/log_in"/>"> <fmt:message key = "logIn" />  </a>

                                              </li>
                                              </c:if>    

                            <li><a class="dropdown-item "  
                                    href="<c:url value="/foget"/>"> <fmt:message key = "foget" />   </a>

                            </li>
                    <c:if test="${ empty account}">         
                        <li><a class="dropdown-item"  
                                    href="<c:url value="/signUp"/>">  <fmt:message key = "signUp" />  </a></li>
  </c:if>   
                           
                            <c:if test="${not  empty account}">    
                           
                            <li>
                          
                           
                            <a class="dropdown-item " 
                                    href="<c:url value="/signOut"/>">  <fmt:message key = "signOut" />  </a>

                            </li>
                             </c:if> 
                          
                            <li><a class="dropdown-item "  
                                    href="<c:url value="/changePass"/>">  <fmt:message key = "changePass" /> </a>

                            </li>
                            <li><a class="dropdown-item " 
                                
                                    href="<c:url value="/profile"/>">  <fmt:message key = "profile" /> </a>

                            </li>
                            
                             
                              
                              
                        </ul>
                    </li>
                </ul>
                <ul class="navbar-nav me-left">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            Tìm Kiếm</a>
                    </li>
                    <li class="nav-item">

                        <input type="search" name="" id="search" class="form-control" placeholder="Tìm kiếm">
                    </li>
                    

                </ul>
                
            </div>
        </div>
    </nav>


 