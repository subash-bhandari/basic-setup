<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>	
	<style type="text/css">
		body {
		    margin: 0;		    
		}
		div .loginContainer a:link {color:#FFFFFF;}      /* unvisited link */
		div .loginContainer a:visited {color:#FFFFFF;}  /* visited link */
		div .loginContainer a:hover {color:#FFFFFF;}  /* mouse over link */
		div .loginContainer a:active {color:#FFFFFF;}  /* selected link */
		.topBar {
			height: 32px;
			background-color: #003366;
			color: #FFFFFF;
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
			padding-right: 5px;
			width: 160px;
			height: 34px;
			float: right;
		}
		.container {
			width: 980px;			
			margin: 0 auto;
			padding: 0;
			border: 0;
			font-size: 100%;
			vertical-align: baseline;
			background: transparent;
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
			padding: 34px 0 20px 5px;
			margin-top: 10px;
			width: 720px;
		}
		.content {
		
		}
		.contentTitleContainer {
		}
		.contentBody {
			padding-top: 20px;
			padding-bottom: 50px;
		}
		.bottomBar {
			background-color: #336699;
			padding: 0;
		}
		.footer {
			width: 980px;
			height: 76px;
			margin: 0 auto;
			padding: 0;
		}
		.footerTop {
			background-color: #FFFFFF;
			width: 980px;
			height: 20px;			
			margin: 0 auto;
			padding: 0;
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
					<a href="${pageContext.request.contextPath}/signup.do">Signup</a>  |  
					<a href="${pageContext.request.contextPath}/login.do">Login</a>
				</span>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="header">
			<div class="headerLogo">
				<a href="${pageContext.request.contextPath}/home.do">
					<img src="${pageContext.request.contextPath}/resources/images/sajhasiteLogo.png" /></div>
				</a>
			<div class="headerMenu">
			Posts  |  Categories  |  Locations  |  Users
			</div>
		</div>	
		<div class="content">
			<div class="contentTitleContainer">
				<tiles:getAsString name="contentTitle" />
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
				<span style="font-weight: bold; color: #FFFFFF;">ShitIsUnderConstruction<sup>TM</sup></span>
			</div>
			<div style="width: 200px; float: right; text-align: right;">
				${application.serverInfo}
			</div>
		</div>
	</div>
</body>
</html>