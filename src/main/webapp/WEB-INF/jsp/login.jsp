<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
	td {
		padding: 10px;
	}
</style>
<form:form method="POST" modelAttribute="login">
	<table >
		<tr>
			<td>Login</td>
			<td><form:input path="loginId" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right">				
				<input type="submit" name="login" value="Login" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<a href="${pageContext.request.contextPath}/forgotpassword.do">Forgot password?</a>
			</td>
		</tr>
	</table>
</form:form>