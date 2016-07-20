<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>
	<!--  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>-->
	<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
</head>

<body>

 	<section class="container">
 		<div class = "login">
 	
 	<h1> Registration Form</h1>
 	
	<form:form method="POST" modelAttribute="user">

		<div>
			<div>
				<label>First Name</label>
				<div>
					<form:input type="text" path="firstName" id="firstName" placeholder="Enter First Name"/>
					<div>
						<form:errors path="firstName"/>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div>
				<label for="lastName">Last Name</label>
				<div>
					<form:input type="text" path="lastName" id="lastName" placeholder = "Enter Last Name" />
					<div>
						<form:errors path="lastName"/>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div>
				<label  for="ssoId">Username</label>
				<div>
					<form:input type="text" path="ssoId" id="ssoId" placeholder = "Enter Username" />
					<div>
						<form:errors path="ssoId"/>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div>
				<label  for="password">Password</label>
				<div>
					<form:input type="password" path="password" id="password" placeholder = "Enter Password" />
					<div>
						<form:errors path="password"/>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div>
				<label for="email">Email</label>
				<div>
					<form:input type="text" path="email" id="email" placeholder = "Enter Email" />
					<div>
						<form:errors path="email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		<div>
			<div>
				<label for="userProfiles">Roles</label>
				<div>
					<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" />
					<div>
						<form:errors path="userProfiles"/>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div>
			</br>
				<input type="submit" value="Register"> or <a href="<c:url value='/admin' />">Cancel</a>
			</div>
		</div>
	</form:form>
	</div>
	</section>
</body>
</html>