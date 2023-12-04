<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="editorChangeProductModal" tabindex="-1"
	aria-labelledby="editorChangeProductModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="editorChangeProductModalLabel">Danh
					sách sản phẩm</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
			<c:url var="url" value="/admin"></c:url>
				<form action="${url}/change-product" method="post">

					<div class="row">
						<c:forEach var="p" items="${showAllProduct}" varStatus="loop">
							<div class="col-lg-3 col-md-4 col-sm-6 mb-3">
								
								<a class="btn btn-info" href="${url}/editor-product?index=${loop.index}">${p.prodName}</a>
							</div>
						</c:forEach>
					</div>

				</form>

			</div>
		</div>
	</div>
</div>