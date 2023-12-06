<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box-content mt-3">
	<div class="row">
		<!-- Lặp sản phẩm -->
		<c:forEach var="p" items="${listPActive}">
			<div class="col-lg-3 col-md-4 col-sm-12 mb-3">
				<div class="card d-flex flex-column h-100">
					<a
						href="${pageContext.request.contextPath}/product/product-detail?id=${p.idPro}">
						<img src="${p.images[0].getImgSrc()}"
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
							<a
								href="${pageContext.request.contextPath}/home/index?action=doLike&idLike=${p.idPro}&userLike=${userLogin.idUs}"
								class="text-reset text-decoration-none"> <c:choose>
									<c:when test="${countLike % 2 != 0 && countLike!=0}">
										<i class="bi bi-suit-heart-fill"></i>
									</c:when>
									<c:otherwise>
										<i class="bi bi-suit-heart"></i>
									</c:otherwise>
								</c:choose> <span>${p.likes.size()}</span> <input type="hidden"
								name="like${p.idPro}" />
							</a>
						</div>
						<div class="me-4">
							<a id="likeLink"
								href="${pageContext.request.contextPath}/share?action=doShare&idShare=${p.idPro}&user=${userLogin.idUs}"
								class="text-reset text-decoration-none"> <i
								class="bi bi-share"></i> <span>${p.shares.size()}</span> <input
								type="hidden" name="share${p.idPro}">
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
