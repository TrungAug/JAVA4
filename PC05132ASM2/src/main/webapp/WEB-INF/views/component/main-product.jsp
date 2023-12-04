<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box-content mt-3">
	<div class="row">
		<!-- Lặp sản phẩm -->
		<c:forEach var="p" items="${listPActive}">
			<div class="col-lg-3 col-md-4 col-sm-12 mb-3">
				<div class="card d-flex flex-column h-100">
					<a href="${pageContext.request.contextPath}/product/product-detail?id=${p.idPro}"> 
					<img
						src="${p.images[0].getImgSrc()}"
						class="card-img-top img-thumbnail" data-bs-toggle="tooltip"
						data-bs-placement="right" title="Click to see more details">
					</a>
					<div class="card-body">
						<h5 class="card-title">${p.prodName}</h5>
						<p class="card-text font_caption_lg desc">${p.description}</p>
					</div>
					<div
						class="card-footer d-flex align-items-center justify-content-end">
						<div class="me-4">
							<a href="" class="text-reset text-decoration-none"> <i
								class="bi bi-suit-heart"></i>
								 <span>${LikeDAO.getInstance().countLikesByProductId(p.idPro)}</span>
							</a>
						</div>
						<div class="me-4">
							<a href="${pageContext.request.contextPath}/share"
								class="text-reset text-decoration-none"> <i
								class="bi bi-share"></i>
								 <span>1.099</span>
							</a>
						</div>
						
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<nav aria-label="Page navigation example" id="paginationF99">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="">First</a></li>
			<li class="page-item"><a class="page-link" href="">Previous</a></li>
			<li class="page-item"><a class="page-link" href="">Next</a></li>
			<li class="page-item"><a class="page-link" href="">Last</a></li>
		</ul>
	</nav>
</div>