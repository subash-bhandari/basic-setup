<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
	td {
		padding: 10px;
	}
</style>

<form:form method="POST" modelAttribute="signup">
	<form:errors path="*" cssClass="errorMsg" />
	<table >
		<tr>
			<td>Username</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Display Name</td>
			<td><form:input path="displayName" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right">				
				<input type="submit" name="signup" value="Signup" />
			</td>
		</tr>		
	</table>
</form:form>