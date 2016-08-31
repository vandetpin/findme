<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FindMe Appointment Portal for Everyone</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
<link href="<c:url value='/static/css/jquery.datetimepicker.min.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/static/css/app.css'></c:url>" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="<c:url value='/static/js/html5shiv.js'></c:url>"></script>
        <script src="<c:url value='/static/js/respond.min.js'></c:url>"></script>
    <![endif]-->
</head>
<body>
	<script type="text/javascript">
		var homePath = '<c:url value='/'></c:url>';
	</script>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/home'></c:url>"><i class="fa fa-search-plus" aria-hidden="true"></i> FindMe </a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/home'></c:url>"> <i class="fa fa-home" aria-hidden="true"></i> Home</a></li>		
					<li><a href="<c:url value='/services'></c:url>">Services</a></li>
					<li><a href="<c:url value='/sntact'></c:url>">Contact Us</a></li>
					<li><a href="<c:url value='/about'></c:url>">About Us</a></li>
					<li><a href="<c:url value='/search'></c:url>">Search</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				
				<c:choose>
					<c:when test="${loggedAdmin != null && loggedAdmin == 'admin'}">
						<li><a class="" href="#login">Welcome Administrator!</a></li>
						<li><a href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> 
					</c:when>
					<c:when test="${loggedUser != null}">
						<li><a class="" href="#login">Welcome ${loggedUser.firstName } ${loggedUser.lastName}!</a></li>
						<li><a href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> 
					</c:when>
					<c:otherwise>
						<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="<c:url value="/login" />"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:otherwise>
				</c:choose>
	        	</ul> 
			</div>
			<!-- /.navbar-collapse -->
		</div> 
	<!-- /.container --> 
	</nav>