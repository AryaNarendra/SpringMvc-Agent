<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Agents List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Agent ID</th>
			<th>Agent Name</th>
			<th>City</th>
			<th>Gender</th>
			<th>Marital Status</th>
			<th>Annual Premium</th>
			<th>Edit</th>
			<th>Delete</th>
			</tr>

		<c:forEach var="agent" items="${list}">
				<tr>
			<td>
				${agent.agentId}
			</td>
			<td>
				${agent.name}
			</td>
			<td>
				${agent.city}
			</td>
			<td>
				${agent.gender}
			</td>
			<td>
				${agent.maritalStatus}
			</td>
			<td>
				${agent.annualPremium}
			</td>
			 <td><a href="editAgent/${agent.agentId}">Edit</a></td>
  			  <td><a href="deleteAgent/${agent.agentId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="agentForm">Add New Agent</a>
</body>
</html>