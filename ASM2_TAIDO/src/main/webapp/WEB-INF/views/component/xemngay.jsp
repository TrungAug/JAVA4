<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
   
 <c:set var="uri" value="${pageContext.request.contextPath}" scope="request"></c:set>
<style>
.container-fruid {
	height: 100vh;
}

.col-right {
	height: 300px; 
}

.card-img {
	max-width: 200px;
	height: 150px;
	overflow: hidden;
}
.card-img > img{
	width:100%;
}

.card>a:hover {
	background-color: rgb(243, 242, 242);
	color: black !important;
}

.card-img:hover {
	width: 205px;
}
</style>


<div class="container-fruid bg-dark">
	<div class="container">
		<div class="row ">
			<div class="col-lg-8 ">
				<div class="card bg-dark text-light ">
					<div class="embed-responsive embed-responsive-21by9"
						style="height: 600px;">
						<iframe width="100%" height="100%"
							src="${form.genre }"
							title="YouTube video player" frameborder="0"
							allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
							allowfullscreen></iframe>


					</div>
					<div class="card-body">
						<h4 class="card-title">${form.title }</h4>
						<p class="card-text">
						<div class="d-flex justify-content-between  align-items-center ">
							<div class="views ">${form.views} Lượt xem</div>
							<div class="div">
								<button class="btn btn-danger p-2 me-1 " type="button">Yêu
									thích</button>
								<button class="btn btn-primary p-2 ms-1 " type="button">Chia
									sẻ</button>
							</div>
						</div>
						</p>
					</div>
				</div>





				<!-- COMMENTtttttttttttttttttttttttttttttttttttttt -->
				<div class="comment mt-3">

					<section class=" text-light py-3" style="background-color: #aaa;">
						<div class="px-3 pb-3 text-dark fw-bold">bình luận</div>
						<div class="container text-dark">
							<div class="row d-flex justify-content-left">
								<div class="col-md-10 col-lg-12 ">
									<div class="card mb-3">

										<div class="card-body">
											<div class="d-flex flex-start">
												<img class="rounded-circle shadow-1-strong me-3"
													src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(26).webp"
													alt="avatar" width="40" height="40" />
												<div class="w-100">
													<div
														class="d-flex justify-content-between align-items-center mb-3">
														<h6 class="text-primary fw-bold mb-0">
															lara_stewart <span class="text-dark ms-2">Yehhhhh,
																Tập này hay quá</span>
														</h6>
														<p class="mb-0">2 ngày trước</p>
													</div>
													<div
														class="d-flex justify-content-between align-items-center">
														<p class="small mb-0" style="color: #aaa;">

															<a href="#!" class="link-grey">thích</a> • <a href="#!"
																class="link-grey">dịch</a>
														</p>
														<div class="d-flex flex-row">
															<i class="fas fa-star text-warning me-2"></i> <i
																class="far fa-check-circle" style="color: #aaa;"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="card mb-3">
										<div class="card-body">
											<div class="d-flex flex-start">
												<img class="rounded-circle shadow-1-strong me-3"
													src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(21).webp"
													alt="avatar" width="40" height="40" />
												<div class="w-100">
													<div
														class="d-flex justify-content-between align-items-center mb-3">
														<h6 class="text-primary fw-bold mb-0">
															the_sylvester_cat <span class="text-dark ms-2">Sukuna
																chém như chém chuối Mohoraga (o.O)</span>
														</h6>
														<p class="mb-0">3 ngày trước</p>
													</div>
													<div
														class="d-flex justify-content-between align-items-center">
														<p class="small mb-0" style="color: #aaa;">
															<a href="#!" class="link-grey">thích</a> • <a href="#!"
																class="link-grey">dịch</a>
														</p>
														<div class="d-flex flex-row">
															<i class="far fa-check-circle text-primary"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="card mb-3">
										<div class="card-body">
											<div class="d-flex flex-start">
												<img class="rounded-circle shadow-1-strong me-3"
													src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(20).webp"
													alt="avatar" width="40" height="40" />
												<div class="w-100">
													<div
														class="d-flex justify-content-between align-items-center mb-3">
														<h6 class="text-primary fw-bold mb-0">
															mindyy_def <span class="text-dark ms-2"> Tại
																saoooooooooo Daddyyyy </span>
														</h6>
														<p class="mb-0">3 ngày trước</p>
													</div>
													<div
														class="d-flex justify-content-between align-items-center">
														<p class="small mb-0" style="color: #aaa;">
															<a href="#!" class="link-grey">thích</a> • <a href="#!"
																class="link-grey">dịch</a>
														</p>
														<div class="d-flex flex-row">
															<i class="fas fa-user-plus" style="color: #aaa;"></i> <i
																class="far fa-star mx-2" style="color: #aaa;"></i> <i
																class="far fa-check-circle text-primary"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="card mb-3">
										<div class="card-body">
											<div class="d-flex flex-start">
												<img class="rounded-circle shadow-1-strong me-3"
													src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(14).webp"
													alt="avatar" width="40" height="40" />
												<div class="w-100">
													<div
														class="d-flex justify-content-between align-items-center mb-3">
														<h6 class="text-primary fw-bold mb-0">
															t_anya <span class="text-dark ms-2"><span
																class="text-primary">@macky_lones</span> <span
																class="text-primary">@rashida_jones</span> Cảm ơn </span>
														</h6>
														<p class="mb-0">4 ngày trước</p>
													</div>
													<div
														class="d-flex justify-content-between align-items-center">
														<p class="small mb-0" style="color: #aaa;">
															<a href="#!" class="link-grey">thích</a> • <a href="#!"
																class="link-grey">dịch</a>
														</p>
														<div class="d-flex flex-row">
															<i class="far fa-check-circle text-primary"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>


			</div>








			<div class="col-lg-4 col-right ">
				<c:forEach var="item" items="${items}">
					<div class="col-12 mt-2">
						<div class="card bg-dark text-light">
							<a href="${uri }/chiTietPage/index/${item.id}"
								style="text-decoration: none;" class="text-light">
								<div class="card-body d-flex justify-content-between">
									<img src="${item.poster}" class="card-img" alt="">
									<div class="div m-2">
										<h5 class="card-title">${item.title }</h5>
										<br>
										<p>${item.views} lượt xem</p>
									</div>

								</div>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>

</div>




