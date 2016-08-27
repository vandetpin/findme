<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visitor - Home</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>


<body>
	
	<!-- Header should go here -->
	
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-8">
                <div class="row">
                    <div class="col-xs-6 col-md-3">
                         <a href="#" class="thumbnail"><img src="..." alt="..."></a>
                    </div>
                    <div class="col-xs-12 col-md-7">
                        <h3>Name Goes Here</h3>
                        <dl>
                          <dt>{Name}</dt> <dd>{Property}</dd>
                        </dl>
                    </div>
                    <div class="col-xs-6 col-md-2">
                        <button class="btn btn-primary btn-block">New Appointment</button>
                    </div>
                </div>
	            <div class="row">
                   <hr/>
                    <div class="col-xs-12 col-sm-4">
                        <div class="well">
                            <div class="list-group">
                                  <a href="#" class="list-group-item ">List of Appointments</a>
                                  <a href="#" class="list-group-item ">List of Clients</a>
                                  <!-- Your Code Goes here -->
                            </div>
                        </div>
                    </div>
	                <div class="col-xs-12 col-sm-8">
	                    <table class="table table-responsive table-hover">
	                        <tr>
	                            <th>Appointment</th>
	                            <th>Start Date/Time</th>
	                            <th>End Date/Time</th>
	                            <th>Status</th>
	                        </tr>
	                        <!-- Your Code Goes here -->
	                    </table>
	                </div>
	            </div>
	        </div>
	        <div class="col-xs-12 col-sm-4">
	            <div class="panel panel-default">
                    <div class="panel-heading">New Appointment</div>
                    <div class="panel-body"> 
                        <p>There are {number} new appointments you need to approve</p>
                        <a href="#" class="btn btn-success">Yes</a>
                        <a href="#" class="btn btn-danger">No</a>
                    </div>
                </div>
	        </div>
	    </div>
	</div>
	
	<!-- Footer should go here -->
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>