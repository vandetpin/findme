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
			<a class="navbar-brand" href="<c:url value='/'></c:url>">FindMe</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/About'></c:url>">About</a></li>
				<li><a href="<c:url value='/Services'></c:url>">Services</a></li>
				<li><a href="<c:url value='/Contact'></c:url>">Contact</a></li>
				<li><a href="<c:url value='/Search'></c:url>">Search</a></li>
				<li><a href="<c:url value='/Register'></c:url>">SignUp/Login</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>
	
	<div class="container">
	
	
	<div class="row">
	<div class="searchBox">
	<form role="form" method="get" action="<c:url value='/search'></c:url>">
		
		<div class="col-lg-11">
			<div class="input-group">
				<input type="text" class="form-control input-lg" name="s" id="s" placeholder="Search for..." value="${param.s}">
				<span class="input-group-btn">
					<button class="btn btn-primary btn-lg" type="submit">Go!</button>
				</span>
			</div>
			<!-- /input-group -->
			
		</div>
		<!-- /.col-lg-6 -->
		
		<div class="col-lg-1"><a href="<c:url value='/search/advance'></c:url>">Advance Search</a></div>
		
	</form>
	</div>

</div>
	
	
	