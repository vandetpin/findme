<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home Page</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>


<body>

	<!-- Header should go here -->




	<div class="container">

		<div class="row">
			<form class="form-inline" method="get" action="search/">
				<div class="form-group">
					<label for="search">Search</label> 
					<input type="search" id="search" name="s" class="form-control">
				</div>
				<button type="submit" class="btn btn-primary">Search</button>
				<small><a href="/search/advance">Advance Search</a></small>
			</form>

		</div>


		<div class="row text-center">

			<c:forEach var="professional" items="${professionals}" varStatus="i">
				<div class="col-md-3 col-sm-6 hero-feature">
					<div class="thumbnail">
						<img src="${professional.profilePicture}" alt="">
						<div class="caption">
							<h3>${professional.firstName}${professional.lastName}</h3>
							<p>${professional.otherInfo}</p>
							<p>
								<a href="/home/details/${professional.Id}"
									class="btn btn-primary">Details</a> <a
									href="/home/register/${professional.Id}"
									class="btn btn-default">Register</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>




		</div>
	</div>

	<!-- Footer should go here -->

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>