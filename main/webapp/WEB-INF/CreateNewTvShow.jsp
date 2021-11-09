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
<title>New TvShow</title>
</head>
<body>

</body>
	<h1>
	New TvShows
	</h1>
	<div>
		<form:form method="POST" action="/create/show" modelAttribute="newTvShow">
			<fieldset>
				<legend>
					TvShow
				</legend>
				<div>
					<form:label path="title"> Title: </form:label>
					<form:input type="text" path="title" name="title" />
				</div>
				<div>
					<form:label path="network"> Network: </form:label>
					<form:input type="text" path="network" name="network" />
				</div>
				<div>
					<button type="submit">
						TvShow
					</button>
				</div>
				<div>
					<c:out value="${loginErrorMessage}"></c:out>
				</div>
			</fieldset>
		</form:form>
	</div>
	<div>
		<a href="/">Home</a>
	</div>
</body>
</html>