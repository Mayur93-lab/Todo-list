<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>


	<div class="container">
		<%@include file="navbar.jsp"%>

	</div>
	<h1 align="center">Please Add your Note Details</h1>

	<!-- this is add form -->

	<div class="container">
		<form action="Save_Note_Servlet" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> 
				<input  name="title" required type="text" 
					class="form-control" id="title" aria-describedby="emailHelp"
					placeholder="Enter Here">
			</div>

			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea  name="content" required id="content" 
				placeholder="Enter your content here"
				class="form-control"
				style="height:300px;"></textarea>
					
			</div>
			
			<div class="container text-center">
			<button type="submit" class="btn btn-primary">Add</button>
			</div>
		</form>
	</div>

</body>
</html>