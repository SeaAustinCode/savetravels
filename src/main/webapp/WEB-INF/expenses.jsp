<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels index page</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
		<tr>
				<td>Expense</td>
				<td>Vendor</td>
				<td>Amount</td>
				<td>Actions</td>
		</tr>
		</thead>
		<c:forEach items="${allexpenses }" var="expenseinfo">
			<tbody>
					<ul><a href="/expenses/${expenseinfo.id}/show">${expenseinfo.name}</a></ul>
					<ul><c:out value="${expenseinfo.vendor }" /></ul>
					<ul><c:out value="${expenseinfo.amount }"></c:out></ul>
					<ul><a href="/expenses/${expenseinfo.id}/edit">Edit</a>
					<form action="/delete/expenses/${expenseinfo.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
					</form>
			</tbody>
		</c:forEach>
		</tbody>
	</table>
	<form:form action="/expenses" method="post" modelAttribute="expense">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
			<form:errors path="vendor" />
			<form:input path="vendor" />
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<form:errors path="amount" />
			<form:input path="amount" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description" />
			<form:input path="description" />
		</p>
		<input type="submit" value="submit" />
	</form:form>
</body>
</html>