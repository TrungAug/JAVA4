<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="form_lab4_bai2">
	<div class="row justify-content-center">
		<div class="col-lg-8">
			<form action="users" method="post">
				<div class="card bg-info text-white">
					<div class="card-header">
						<div class="card-text">
							<h2>User Editor</h2>
						</div>
					</div>
					<div class="card-body">
						<h2>${message}</h2>
						<div class="form-outline mb-4">
							<label class="form-label" for="userNameControlInput">Username:</label>
							<input type="text" id="userNameControlInput"
								class="form-control form-control-lg" name="username"
								value="${form.username}" />
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="passwordControlInput">Password:</label>
							<input type="password" id="passwordControlInput"
								class="form-control form-control-lg" name="password"
								value="${form.password}" />
						</div>
						<div class="form-check d-flex justify-content-start mb-4">
							<input class="form-check-input" type="checkbox" value="${form.remember ? 'checked' : ''}"
								id="rememberMeCheck" name="remeber"
								${form.remember ? 'checked' : ''} /> <label
								class="form-check-label" for="rememberMeCheck"> Remember
								password </label>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn btn-primary">Create</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>