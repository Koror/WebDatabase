<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list of users</title>
</head>
<body>
<h1>Web Database</h1>
	<table border=1>
		<thead>
			<tr>
				<th>Nickname</th>
				<th>Email</th>
				<th>Registration date</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.nickname}"/></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.dateReg}"/></td>
				<td><a href="backend?action=edit&userId=<c:out value="${user.id}"/>">Edit</a></td>
				<td><a href="backend?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="backend?action=insert">Add User</a></p>
</body>
</html>