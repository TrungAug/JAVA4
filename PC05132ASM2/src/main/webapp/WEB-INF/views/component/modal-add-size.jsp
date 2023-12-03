<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="editorAddSizeProductModal" tabindex="-1"
	aria-labelledby="editorAddSizeProductModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-info"
					id="editorAddSizeProductModalLabel">Thêm Size Sản Phẩm</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body row d-flex justify-content-center">
				<c:url var="url" value="/admin"></c:url>
				<form action="${url}/add-size-product" method="post">
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<div class="input-group mb-5">
								<span class="input-group-text"
									id="editorPage-addSizeForm-productId-id">Product id</span> <input
									type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="editorPage-addSizeForm-productId-id"
									name="idPro" value="${showP.idPro}">
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div class="input-group mb-5">
								<span class="input-group-text"
									id="editorPage-addSizeForm-size-id">Size</span> <input
									type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="editorPage-addSizeForm-size-id" name="sizeName">
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div class="input-group mb-5">
								<span class="input-group-text"
									id="editorPage-addSizeForm-width-id">Width</span> <input
									type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="editorPage-addSizeForm-width-id" name="width">
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div class="input-group mb-5">
								<span class="input-group-text"
									id="editorPage-addSizeForm-profile-id">Profile</span> <input
									type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="editorPage-addSizeForm-profile-id"
									name="profile">
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div class="input-group mb-5">
								<span class="input-group-text"
									id="editorPage-addSizeForm-rim-id">Rim</span> <input
									type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="editorPage-addSizeForm-rim-id"
									name="rim">
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div class="input-group mb-5">
								<span class="input-group-text"
									id="editorPage-addSizeForm-diameter-id">Diameter</span> <input
									type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="editorPage-addSizeForm-diameter-id"
									name="diameter">
							</div>
						</div>
					</div>
					<div class="row mt-5 d-flex justify-content-end">
						<button class="btn btn-primary m-2">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>