<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
	td {
		padding: 10px;
	}
</style>

<table>
	<tr>
		<td>User Id</td>
		<td>Email</td>
		<td>Display Name</td>
		<td>Password</td>
	</tr>
	<c:forEach items="${users}" var="user">	
	<tr>
		<td>${user.userId}</td>		
		<td>${user.email}</td>		
		<td>${user.displayName}</td>
		<td>${user.password}</td>
	</tr>
	</c:forEach>
</table>
