<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="accordion__sidebar" class="mb-3 text-black">
	<div class="accordion" id="accordionPanelsHanKook">
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button" type="button"
					data-bs-toggle="collapse" data-bs-target="#accordionTyreVehicle"
					aria-expanded="true" aria-controls="accordionTyreVehicle">By
					Vehicle</button>
			</h2>
			<div id="accordionTyreVehicle"
				class="accordion-collapse collapse show"
				data-bs-parent="#accordionPanelsHanKook">
				<ul class="list-group">
					<c:forEach var="t" items="${listTyre}">					
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a class="text-decoration-none" href="${pageContext.request.contextPath}/home/index?idTyres=${t.idTyre}">
								${t.nameTyre}
							</a>
						</li>					
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button collapsed" type="button"
					data-bs-toggle="collapse" data-bs-target="#accordionTyreSeason"
					aria-expanded="false" aria-controls="accordionTyreSeason">By
					Season</button>
			</h2>
			<div id="accordionTyreSeason" class="accordion-collapse collapse"
				data-bs-parent="#accordionPanelsHanKook">
				<ul class="list-group">
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						All Season</li>
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						Summer</li>
				</ul>
			</div>
		</div>
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button collapsed" type="button"
					data-bs-toggle="collapse"
					data-bs-target="#accordionTyreProductFamily" aria-expanded="false"
					aria-controls="accordionTyreProductFamily">By Product
					Family</button>
			</h2>
			<div id="accordionTyreProductFamily"
				class="accordion-collapse collapse"
				data-bs-parent="#accordionPanelsHanKook">
				<ul class="list-group">
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						Our Brands</li>
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						iON</li>
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						Ventus</li>
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						Dynapro</li>
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						Kinergy</li>
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						Vantra</li>
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						Smart</li>
				</ul>
			</div>
		</div>
	</div>
</div>