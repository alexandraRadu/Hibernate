<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
<!--  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>-->
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
</head>

<body>

	<section class="container">
		<div class="login">
			<h1>Registration Form</h1>
			<form:form method="POST" modelAttribute="user">
				<form:input type="hidden" path="id" id="id" />

				<div>
				<label>First Name</label></br>
					<form:input type="text" path="firstName" id="firstName"
						placeholder="Enter First Name" />
					<div>
						<form:errors path="firstName" />
					</div>
				</div>

				<div>
				<label>Last Name</label></br>
					<form:input type="text" path="lastName" id="lastName"
						placeholder="Enter Last Name" />
					<div>
						<form:errors path="lastName" />
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="ssoId">SSO ID</label>
						<div class="col-md-7">
							<c:choose>
								<c:when test="${edit}">
									<form:input type="text" path="ssoId" id="ssoId" placeholder="Enter Username" 
										class="form-control 
 
input-sm" disabled="true" />
								</c:when>
								<c:otherwise>
									<form:input type="text" path="ssoId" id="ssoId" placeholder="Enter Username" 
										class="form-control 
 
input-sm" />
									<div class="has-error">
										<form:errors path="ssoId" class="help-inline" />
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div>
				<label>Password</label></br>
					<form:input type="password" path="password" id="password"
						placeholder="Enter Password" />
					<div>
						<form:errors path="password" />
					</div>
				</div>

				<div>
				<label>Email</label></br>
					<form:input type="text" path="email" id="email"
						placeholder="Enter Email" />
					<div>
						<form:errors path="email" class="help-inline" />
					</div>
				</div>

				<div>
					<label for="userProfiles">Roles</label>
					<div>
						<form:select path="userProfiles" items="${roles}" multiple="true"
							itemValue="id" itemLabel="type" />
						<div>
							<form:errors path="userProfiles" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-actions floatRight">
						<c:choose>
							<c:when test="${edit}">
							</br>
								<input type="submit" value="Update"
									class="btn btn-primary btn-sm" /> or <a
									href="<c:url value='/userslist' />">Cancel</a>
							</c:when>
							<c:otherwise>
							</br>
								<input type="submit" value="Register"> or <a
									href="<c:url value='/login' />">Cancel</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</form:form>
		</div>
	</section>
</body>
</html>