<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
	
 <c:set var="uri" value="${pageContext.request.contextPath}" scope="request"></c:set>
	
	

<style>
body {
	height: 200vh;
}

img {
	height: 150px;
}
</style>





<div class="container bg-dark " data-bs-theme="dark">
	<div class="row">
		<div class="col-lg-10 mt-3">

			<div class="card d-flex flex-column">
				<a href="#"> <img src="${form.poster}"
					class="card-img-top img-thumbnail" alt="...">
				</a>
				<div class="card-header">
					<h3 class="card-title">${form.title }</h3>
				</div>
				<div class="card-body">


					<div class="description">${form.description}</div>
					<div class="d-flex justify-content-end ">
						<button class="btn btn-primary me-1" type="button">Yêu
							thích</button>
						<a href="share.jsp">
							<button class="btn btn-primary ms-1" type="button">Chia
								sẻ</button>
						</a>
					</div>
				</div>
				<div class="card-footer">

					<div
						class="d-flex justify-content-center align-items-center mt-auto">
						<a href="${uri}/xemNgay/index/${form.id}">
							<button class="btn btn-danger col-12 "
								 type="button">
								<h3>Xem Ngay</h3>
							</button>

						</a>
 

					</div>
				</div>
			</div>


		</div>


		<!-- ///////////////////////////////////////////// -->
		<div class="col-lg-2 bg-dark">
			<div class="col-12 d-flex justify-content-center  ">
				<div class="title-right text-light">
					<h4 style="color: #e70303;">Xem Tiếp</h4>
				</div>
			</div>

			<c:forEach var="item" items="${items}">

				<div class="col-12">
					<div class="card  ">
						<a href="ASM_GD2_JAVA4_PC03980/chiTietPage/index/${item.id}"> <img
							src="${item.poster}" class="card-img-top " alt="...">
						</a>

						<div class="card-body">
							<h5 class="card-title">${item.title}</h5>

							<a href="${uri }/chiTietPage/index/${item.id}"
								class="d-flex justify-content-center align-items-center mt-auto">
								<button class="btn btn-primary col-6 p-2  "
									 type="button">
									XEM</button>

							</a>
						</div>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>

</div>

















