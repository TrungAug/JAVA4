<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Java4</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>

<body class="d-flex flex-column justify-content-between">
	<div class="container-fluid">

		<main class="main mt-1 mb-1"
			style="background-image: url('https://asset.hankooktire.com/content/dam/hankooktire/common/media/AU/en/2023/11/news_img_20231108_2.jpg'); background-repeat: no-repeat; background-size: cover;">
			<div class="container py-5">
				<div class="row justify-content-center">
					<div class="col-lg-8">
						<div class="card"
							style="background: rgba(24, 23, 23, 0.8); backdrop-filter: blur(30px); color: #fff;">
							<div class="card-body p-5 text-center">
								<form>
									<c:choose>
										<c:when test="${empty userLogin}"> Welcome</c:when>
										<c:otherwise>
											Welcome ${userLogin.admin?"Admin":"Khách hàng"} ${userLogin.fullName} <br>
											<a href="${pageContext.request.contextPath}/account/sign-in">Đăng
												xuất</a> <br>
											<c:if test="${userLogin.admin }">
												<a href="${pageContext.request.contextPath}/account/admin">Đây là link Admin</a>
											</c:if>
										</c:otherwise>
									</c:choose>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</main>

	</div>
	<script>
		setTimeout(function() {
			document.getElementById('messageInfo').style.display = 'none';
		}, 2000);
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>