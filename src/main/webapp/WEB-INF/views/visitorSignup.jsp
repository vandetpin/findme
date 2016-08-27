<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Visitor Signup</title>
    <link href="<c:url value='../static/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='../static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Visitor signup</h1>
		<form class="form-horizontal" method="post" enctype="multipart/form-data" action="?${_csrf.parameterName}=${_csrf.token}" >
			<fieldset>
				<legend>Basic information</legend>
				
				<div class="form-group">
					<label class="col-md-3 control-label">Upload profile picture</label>
					<div class="col-md-9">
						<input type="file" id="file" name="file"  />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">First name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="firstName"
							placeholder="First name">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Last name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="lastName"
							placeholder="Last name">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Email</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="emailAddress"
							placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Phone number</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="phoneNumber"
							placeholder="Phone number">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Date of birth</label>
					<div class="col-md-9">
						<input type="text" class="form-control"  name="dateOfBirth"
							placeholder="Date of birth">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Gender</label>
					<div class="col-md-9">
						<select class="form-control" name="gender">
							<option value="M">Male</option>
							<option value="F">Female</option>
						</select>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>Address</legend>
				<div class="form-group">
						<label class="col-md-3 control-label">Street</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="street"
								placeholder="Street">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">City</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="city"
								placeholder="City">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">State</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="state"
								placeholder="State">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Zip</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="zip"
								placeholder="Zip">
						</div>
					</div>
			</fieldset>
			<fieldset>
				<legend>User account</legend>
				<div class="form-group">
					<label class="col-md-3 control-label">Username</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="username"
							placeholder="Username">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Password</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="password"
							placeholder="Password">
					</div>
				</div>
			</fieldset>
			<div class="form-group">
				<div class="col-md-9 col-md-offset-3">
					<button type="submit" class="btn btn-primary">Signup</button>
				</div>
			</div>
			<img alt="" src="/static/2c50a9538a37ef3f47561c6f636efe59.jpg" />
		</form>
	</div>
</body>
</html>