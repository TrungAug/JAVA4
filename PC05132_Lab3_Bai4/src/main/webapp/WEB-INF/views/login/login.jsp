<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LOGIN COOKIES</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="card bg-info">
					<div class="card-heard">
						<div class="card-title">
							<mark>${message}</mark>
						</div>
					</div>
					<div class="card-body">
						<form action="login" method="post" name="loginForm">
							<div class="mb-3">
								<label for="usernameInput" class="form-label">Username:</label>
								<input class="form-control" id="usernameInput" name="username"
									value="${usernameCookie}"><br>
							</div>
							<div class="mb-3">
								<label for="passwordInput" class="form-label">Password:</label>
								<input class="form-control" id="passwordInput" name="password"
									type="password" value="${passwordCookie}"><br>
							</div>
							<div class="mb-3 form-check">
								<input class="form-check-input" name="remember" type="checkbox">Remember
								me?
							</div>
							<hr>
							<button class="btn btn-primary">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>

</html>