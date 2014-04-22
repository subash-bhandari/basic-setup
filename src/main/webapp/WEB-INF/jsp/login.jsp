<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style type="text/css">
	td {
		padding: 10px;
	}
</style>
<c:if test="${param.error != null}">
	<span style="color: red">
		<spring:message code="login.error" />
	</span>
</c:if>
<form action="${pageContext.request.contextPath}/postlogin.do" method="POST">
	<table >
		<tr>
			<td>Login</td>
			<td><input type="text" name="username" /></td>			
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="password" /></td>
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
</form>