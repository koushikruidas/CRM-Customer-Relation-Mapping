<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
<title>Search Result</title>
</head>
<body>
	<form:form modelAttribute="result">
		<div id="wrapper">
		<div id="header">
			<h2>CRM- Customer Relationship Mapping</h2>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<c:forEach var="tempCustomer" items="${result }">
						<c:url var="updateLink" value="/customer/updateCustomer">
							<c:param name="customerId" value="${tempCustomer.id }" />
						</c:url>

						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.id }" />
						</c:url>
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName }</td>
							<td>${tempCustomer.email }</td>
							<td><a href="${updateLink }">Update</a> | <a
								href="${deleteLink }">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	</form:form>
</body>
</html>