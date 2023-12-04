<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${userLogin==null}">
		<div id="login__sidebar" class="mb-3 text-white">
			<div class="card shadow-2-strong"
				style="border-radius: 1rem; background-color: #474545; color: #fff;">
				<div class="card-body p-2 text-center">
					<h3 class="mb-4">Sign in</h3>
					<form
						action="${pageContext.request.contextPath}/user-controller/side-bar-sign-in"
						method="post">
						<div class="row">
							<div class="col-md-12 mb-4">
								<div class="form-outline">
									<label class="form-label" for="signInUsername">Username</label>
									<input type="text" id="signInUsername" name="username"
										value="${usernameC}" class="form-control" required>
								</div>
							</div>
							<div class="col-md-12 mb-4">
								<div class="form-outline mb-4">
									<label class="form-label" for="signInPass">Password</label> <input
										type="password" id="signInPass" class="form-control"
										name="password" value="${passwordC}" required>
								</div>
							</div>
						</div>
						<div class="form-check d-flex justify-content-center mb-4">
							<input class="form-check-input me-2" type="checkbox"
								id="rememberPasswordCheckBoxSignInForm" name="remember" checked />
							<label class="form-check-label"
								for="rememberPasswordCheckBoxSignInForm"> Remember
								Password? </label>
						</div>
						<button class="btn btn-primary btn-block mb-4" id="signInButton">Sign
							in</button>
					</form>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<h4>Welcom to my website</h4>
		<button class="btn btn-outline-success mb-3" data-bs-toggle="collapse"
			data-bs-target="#userInfoCard">More Information</button>
		<div class="collapse m-3" id="userInfoCard">
			<div class="card card-body bg-info">
				<h5>Your Information</h5>
				<p>Your fullname: ${userLogin.fullName}</p>
				<p>Your role: ${userLogin.admin?"Admin":"Customer"}</p>
				<a type="button" class="text-primary" href="${pageContext.request.contextPath}/user-controller/sign-out"> Sign out </a>				
			</div>
		</div>
	</c:otherwise>
</c:choose>