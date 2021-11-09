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
<title>Show Details</title>
</head>
<body>

</body>
	<h1>
	${tvs.title}
	</h1>
	<h3>
	${tvs.network}
	</h3>
	<div>
		<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
			<tr>
				<td>
					<c:out value="${user.user}"/>
				</td>
				<td>
					<c:out value="${user.rating}"/>
				</td>
		   </tr>
			</c:forEach>
		</tbody>
	
		</table>  
	</div>
	<div>
	<form:form method="POST" action="/add/rate/${tvs.tv_show_id}" modelAttribute="rate">
					<div>
					<form:label path="rating"> Leave a Rating: </form:label>
					<form:input  type="number" path="rating" />
				</div>
				<div>
					<input type="submit" >
				</div>
	</form:form>
	</div>
	<div>
		
		<a href="/">Home</a>
	</div>
</body>
</html>