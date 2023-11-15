<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<body>
	<div class="row justify-content-center">
		<div class="col-lg-8">
			<form action="mail" method="post" enctype="multipart/form-data">
				<div class="card text-white w-50 mx-auto my-5"
					style="background-color: #474545;">
					<div class="card-header">
						<div class="card-title">
							<h1>SEND EMAIL</h1>
						</div>
					</div>
					<div class="card-body">

						<mark>${message}</mark>
						<div class="form-outline mb-4">
							<label class="form-label" for="userNameControlInput">From:</label>
							<input type="email" id="emailFromControlInput"
								class="form-control form-control-lg" name="emailf" />
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="passwordControlInput">To:</label>
							<input type="email" id="emailToControlInput"
								class="form-control form-control-lg" name="emailt" />
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="passwordControlInput">Subject:</label>
							<input type="text" id="emailSubjectControlInput"
								class="form-control form-control-lg" name="subject" />
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="passwordControlInput">Body:</label>
							<textarea class="form-control form-control-lg" name="body"
								id="emailBodyControlInput" cols="30" rows="3"></textarea>
						</div>
						<div class="form-outline mb-4">
							<label for="fileInput" class="form-label">File đính kèm:</label>
                            <input type="file" class="form-control" id="fileInput" name="attach_file">
						</div>						
					</div>
					<div class="card-footer">
						<button class="btn btn-primary">Send</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>