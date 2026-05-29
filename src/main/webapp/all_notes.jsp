<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes: Notes Taker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1 align="center" class="text-upperclass">All Notes</h1>

		<%
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from Note");
		List<Note> list = q.list();
		for (Note note : list) {
		%>
		<div class="card mt-3" >
			<img src="img/noteicon.png" style="max-width:100px" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title"><%=note.getTitle() %></h5>
				<p class="card-text"><%=note.getContent()  %></p>
				<p style="color: blue">Last Update: <%=note.getAddedDate() %> </p>
				<a href="edit.jsp?note_id=<%=note.getId() %>" class="btn btn-success">Update</a>
				<a href="DeleteServlet?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
				
			</div>
		</div>


		<%
		}

		s.close();
		%>
	</div>
</body>
</html>