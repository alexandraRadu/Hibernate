<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Users </span>
			</div>
			<table class="table table-hover">
				<sql:setDataSource var="myDS" driver="org.postgresql.Driver"
					url="jdbc:postgresql://localhost:5432/proiect" user="postgres"
					password="superuser" />
				<sql:query var="listUsers" dataSource="${myDS}">
        SELECT * FROM app_user;
    </sql:query>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Username</th>
						<th width="100"></th>
						<th width="100"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listUsers.rows}" var="user">
						<tr>
							<td>${user.first_Name}</td>
							<td>${user.last_Name}</td>
							<td>${user.email}</td>
							<td>${user.sso_Id}</td>
							<td><a href="<c:url value='/edit-user-${user.sso_Id}' />"
								class="btn btn-success 
 
custom-width">edit</a></td>
							<td><a href="<c:url value='/delete-user-${user.sso_Id}' />"
								class="btn btn-danger 
 
custom-width">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>