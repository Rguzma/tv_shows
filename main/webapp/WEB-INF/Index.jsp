<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>Login and registration</title>

	</head>
	<body>
	
	<h1>
		Login and registration
	</h1>
		<form:form class="user-form" method="POST" action="register/user" modelAttribute="newuser">
			<fieldset>
				<legend>
					Register a new user
				</legend>


				<div>
					<form:label path="user"> User Name: </form:label>
					<form:input class="form-control" type="text" path="user" name="user" />
				</div>
				<div>
					<form:label path="email"> Email: </form:label>
					<form:input class="form-control" type="text" path="email" name="email" />
				</div>
				<div>
					<form:label path="password"> Password: </form:label>
					<form:input class="form-control" type="password" path="password" name="password" />
				</div>
				<div>
					<form:label path="passwordConfirmation"> Password confirmation: </form:label>
					<form:input class="form-control" type="password" path="passwordConfirmation" name="passwordConfirmation" />
				</div>
				<div>
					<button type="submit">
						Register
					</button>
				</div>
				<div class="errorMessage">
					<c:out value="${errorMessage}"></c:out>
				</div>
			</fieldset>
		</form:form>
		<form:form method="POST" action="/validate/user" modelAttribute="login">
			<fieldset>
				<legend>
					Login
				</legend>
				<div>
					<form:label path="email"> Email: </form:label>
					<form:input type="text" path="email" name="email" />
				</div>
				<div>
					<form:label path="password"> Password: </form:label>
					<form:input type="password" path="password" name="password" />
				</div>
				<div>
					<button type="submit">
						Login
					</button>
				</div>
				<div>
					<c:out value="${loginErrorMessage}"></c:out>
				</div>
			</fieldset>
		</form:form>

	</body>
</html>