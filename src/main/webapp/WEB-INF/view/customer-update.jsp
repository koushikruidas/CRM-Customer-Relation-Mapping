<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM- Customer Relationship Mapping</h2>
		</div>
		<div id="container">
			<h3>Save Customer</h3>
			<form:form action="saveCustomer" modelAttribute="customer-update"
				method="POST">
				<form:hidden path="id"/>
				<table>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName" name="firstName"/>
						<form:errors
								path="firstName" cssClass="error" />
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName" name="lastName"/> 
							<form:errors
								path="lastName" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email" name="email"/>
						<form:errors
								path="email" cssClass="error" />
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>