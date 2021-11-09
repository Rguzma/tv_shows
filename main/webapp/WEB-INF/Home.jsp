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
<title>Home</title>
</head>
<body>

</body>
	<h1>
	List of TvShows
	</h1>
	<div>
		<table>
		<thead>
			<tr>
				<th>Show</th>
				<th>Network</th>
				<th>Avg Rating</th>
			</tr>
		</thead>
		<tbody><c:forEach items="${tvShows}" var="tvs">
			<tr>
				<td>
					<a href="/details/show/${tvs.tvShow_id}">
						<c:out value="${tvs.title}"/>
					</a>
					
				</td>
				<td>
					<c:out value="${tvs.network}"/>
				</td>
		
				<td>
					<c:out value="${tvs.rating}"/>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	
		</table>  
	</div>
	<div>
		<a href="/create/show">Add a show</a>
		<a href="/">Home</a>
	</div>
</body>
</html>