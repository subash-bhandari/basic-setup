<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>	
	<style type="text/css">
		html {
			min-height: 100%;
			font-family: Monaco, Consolas, "Lucida Console", monospace;
			font-size: 10pt;
		}
		body {
		    margin: 0;	
		    /* can be treated like a fallback */
			background-color: #DfDfDf;
			
			/* will be "on top", if browser supports it */
			/*background-image: linear-gradient(	#bfbcc5, #0A0A0A); */
		}
		div .loginContainer a:link {color:#FFFFFF;}      /* unvisited link */
		div .loginContainer a:visited {color:#FFFFFF;}  /* visited link */
		div .loginContainer a:hover {color:#FFFFFF;}  /* mouse over link */
		div .loginContainer a:active {color:#FFFFFF;}  /* selected link */
		.topBar {
			height: 32px;
			background-color: #595959;
			color: #efefef;
		}
		.topBarLinks a:visited {
		    color: #E0E0E0;
		    display: inline-block;
		    font-size: 13px;
		    height: 24px;
		    padding: 10px 7px 0;
		    text-decoration: none;
		    vertical-align: top;
		}
		.topBarContainer {
			width: 980px;
			height: 34px;
			margin: 0 auto;
			padding-bottom: 15px !ie7;			
		}
		.loginContainer {
			text-align: right;
			padding-top: 5px;
			padding-right: 5px;
			width: 160px;
			float: right;
		}
		.container {		
			margin: 0;
			padding: 0;
			border: 0;
			background-color: #FFFFFF;
		}
		.header {
			width: 980px;
			height: 76px;
			margin: 0 auto;
			padding-bottom: 15px !ie7;
		}
		.headerLogo {
			width: 250px;
			float: left;
		}
		.headerMenu {
			float: left;
			padding: 10px 0 20px 5px;
			margin-top: 0px;
			width: 720px;
		}
		.content {
			width: 980px;
			margin: 0 auto;
		}
		.contentTitleContainer {
		}
		.contentBody {
			padding-top: 20px;
			padding-bottom: 50px;
		}
		.bottomBar {
			/*background-color: #336699;*/
			background-color: transparent;
			padding: 0;
		}
		.footer {
			width: 980px;
			height: 76px;
			margin: 0 auto;
			padding: 0;
			color: #777777;
		}
		.footerTop {
			background-color: #FFFFFF;
			width: 980px;
			height: 20px;			
			margin: 0 auto;
			padding: 0;
		}	
		.errorMsg {
			color: red;
		}	
	</style>
</head>
<body>
	<div class="topBar">
		<div class="topBarContainer">
			<div style="witdh: 100px; float: left;">
				Wassup!!!
			</div>
			<div class="loginContainer">
				<span class="topBarLinks">
					<sec:authorize var="loggedIn" access="isAuthenticated()" />
					<c:choose>
						<c:when test="${loggedIn}">
							<sec:authentication  property="principal.username" /> | 
							<a href="${pageContext.request.contextPath}/logout.do">Logout</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/signup.do">Signup</a>  |  
							<a href="${pageContext.request.contextPath}/login.do">Login</a>
						</c:otherwise>
					</c:choose>
				</span>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="header">
			<div class="headerLogo">
				<a href="${pageContext.request.contextPath}/home.do">
					<img src="${pageContext.request.contextPath}/resources/images/sajhasiteLogo.png" />
				</a>
			</div>
			<div class="headerMenu">
			<a href="${pageContext.request.contextPath}/posts.do">Posts</a>  |  
			<a href="${pageContext.request.contextPath}/categories.do">Categories</a>  |  
			<a href="${pageContext.request.contextPath}/locations.do">Locations</a>  |  
			<a href="${pageContext.request.contextPath}/users.do">Users</a>  |  
			<a href="${pageContext.request.contextPath}/createpost.do"> >> Create Post << </a>
			</div>
		</div>	
		<div class="content">
			<div class="contentTitleContainer">
				<span style="font-weight: bold;"><tiles:getAsString name="contentTitle" /></span>
				<hr />
			</div>
			<div class="contentBody">
				<tiles:insertAttribute name="content" />
			</div>
		</div>		
	</div>
	<div class="bottomBar">
		<div class="footerTop"></div>
		<div class="footer">
			<div style="width: 200px; float: left;">
				<span style="font-weight: regular;">ShitIsUnderConstruction<sup>TM</sup></span>
			</div>
			<div style="width: 400px; float: right; text-align: right;">
				<span style="font-weight: regular;">
				${pageContext.servletContext.serverInfo}
				</span>
			</div>
		</div>
	</div>
</body>
</html>