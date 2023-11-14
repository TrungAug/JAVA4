<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table_lab4_bai2">
	<div class="row justify-content-center">
		<div class="col-lg-8">
			<div class="card">
				<div class="card-header">
					<div class="card-title">
						<h3>User List</h3>
					</div>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table align-middle table-dark table-hover">
							<thead>
								<tr>
									<th>Username</th>
									<th>Password</th>
									<th>Remember?</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">
								<c:forEach var="item" items="${items}">
									<tr>
										<td>${item.username}</td>
										<td>${item.password}</td>
										<td>${item.remember?'Yes':'No'}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>