
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Login Form</title>
<link rel="stylesheet" href='static/css/style.css'>
</head>
<body>
	<section class="container">
		<div class="login">
			<h1>Login</h1>
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="POST">
				<c:if test="${param.error != null}">
					<div>
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div>
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
				<div>
					<label for="username"> <i></i></label> <input type="text"
						id="username" name="ssoId" placeholder="Enter Username" required>
				</div>
				<div>
					<label for="password"><i></i></label> <input type="password"
						id="password" name="password" placeholder="Enter Password"
						required>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<p class="submit">
					<input type="submit" name="commit" value="Login">
				</p>
			</form>
		</div>
	</section>
</body>
</html>