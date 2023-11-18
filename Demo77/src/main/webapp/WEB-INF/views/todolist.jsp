<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/todo/add" method="post">

<input name="title" placeholder="Title" required><br>
		<textarea rows="5" cols="5" name="description"
			placeholder="Description"></textarea>
		<br>
		<button>Add</button>
		
	</form>

<div>
<p>Size: ${todo_list==null?0:todo_list.size()}</p>

</div>
</body>
</html>