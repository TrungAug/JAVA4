<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="editorEditProductModal" tabindex="-1"
	aria-labelledby="editorEditProductModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-info" id="editorEditProductModalLabel">Cập nhật
					sản phẩm</h5>

				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body row d-flex justify-content-center">
				<c:url var="url" value="/admin"></c:url>
				<form action="${url}/update-product" method="post"
					enctype="multipart/form-data">
					<div class="row mb-4">
						<div class="col-md-6">
							<div class="input-group mb-3">
								<span class="input-group-text" id="inputGroup-sizing-idPro">Product
									ID</span> <input type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default" value="${formEditProd.idPro}" name="idPro"
									required="required" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="input-group mb-3">
								<span class="input-group-text" id="inputGroup-sizing-prodName">Product
									Name</span> <input type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default" value="${formEditProd.prodName}" name="prodName" />
							</div>
						</div>
					</div>
					<div class="row mb-4">
						<p>Tyre Type:</p>
						<c:forEach var="t" items="${Tyres}">
							<div class="col-lg-2 col-md-4 col-sm-6 m-2">
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="${t.idTyre}" id="${t.idTyre}" name="tyre"> <label
										class="form-check-label" for="flexCheckDefault">
										${t.nameTyre} </label>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row mb-4">
						<div class="form-floating">
							<textarea class="form-control"
								placeholder="Leave a description here"
								id="floatingProdDescription" value="${formEditProd.description}" name="description" ></textarea>
							<label for="floatingProdDescription">Description</label>
						</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-4">
							<div class="input-group mb-3">
								<input type="file" class="form-control" id="inputGroupFile01"
									name="photo_file1">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group mb-3">
								<input type="file" class="form-control" id="inputGroupFile02"
									name="photo_file2">
							</div>
						</div>
						<div class="col-md-4">
							<div class="input-group mb-3">
								<input type="file" class="form-control" id="inputGroupFile03"
									name="photo_file3">
							</div>
						</div>
						<div class="col text-danger">(*) Choose File Image: Leave
							empty if no change</div>
					</div>
					<div class="row mb-4">
						<p>Publish:</p>
						<div class="col-lg-12 d-flex flex-row justify-content-center">
							<div class="form-check m-4">
								<input class="form-check-input" type="radio" name="active"
									value="true" id="flexCheckDefaultActive"
									${formEditProd.active?'checked':''}> <label
									class="form-check-label" for="flexCheckDefaultActive">
									Active </label>
							</div>
							<div class="form-check m-4">
								<input class="form-check-input" type="radio" name="active"
									value="false" id="flexCheckDefaultInactive"
									${formEditProd.active?'':'checked'}> <label
									class="form-check-label" for="flexCheckDefaultInactive">
									Inactive </label>
							</div>
						</div>
					</div>
					<div class="row mt-5 d-flex justify-content-end">
						<button formaction="${url}/update-product"
							class="btn btn-primary">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>