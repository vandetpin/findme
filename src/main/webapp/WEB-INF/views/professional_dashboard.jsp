<%@ include file="header.jsp"%>
	
	<div class="container">
		<hr />
	    <div class="row">
	        <div class="col-xs-12 col-sm-9">
                <div class="row">
                    <div class="col-xs-6 col-md-3">
                         <a href="#" class="thumbnail"><img src="..." alt="..."></a>
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <h3>Name Goes Here</h3>
                        <dl>
                          <dt>{Name}</dt> <dd>{Property}</dd>
                        </dl>
                    </div>
                    <div class="col-xs-6 col-md-3">
                        <button class="btn btn-primary btn-block">New Appointment</button>
                    </div>
                </div>
                <hr />
	            <div class="row">
                    <div class="col-xs-12 col-sm-4">
                        <div class="well">
                            <div class="list-group">
                                  <a href="#" class="active list-group-item "><span class="glyphicon glyphicon-chevron-right"></span> List of Appointments</a>
                                  <a href="#" class="list-group-item ">List of Clients</a>
                                  <!-- Your Code Goes here -->
                            </div>
                        </div>
                    </div>
	                <div class="col-xs-12 col-sm-8">
	                	<div class="row">
	                	    <div class="col-xs-12 col-sm-12">
	                	    		<h4>Search Appointment Now</h4> <hr />
	                	    		<div class="input-group">
	                	    			<span class="input-group-addon" id="basic-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
  										<input id="startdate" type="text" class="form-control" placeholder="Start Date/Time" aria-describedby="basic-addon1">
  										<input id="enddate" type="text" class="form-control" placeholder="End Date/Time" aria-describedby="basic-addon1">
  										<span class="input-group-addon" id="basic-addon1">
  											<button class="btn btn-default" type="button">Search!</button>
  										</span>
									</div>
									<br />
                            </div>
	                	</div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12">
                                <table class="table table-responsive table-hover">
	                                <tr>
	                                    <th>Appointment</th>
	                                    <th>Start Date/Time</th>
	                                    <th>End Date/Time</th>
	                                    <th>Status</th>
	                                </tr>
	                            <!-- Your Code Goes here -->
	                            </table>
	                            <!-- If No Appointment found -->
	                            <hr />
	                            <h4>No Appointment found in the record!</h4>
	                            <h5>Please click New Appointment button at the top to create an appointment.</h5>
                            </div>
                        </div>
	                </div>
	            </div>
	        </div>
	        <div class="col-xs-12 col-sm-3">
	            <div class="panel panel-default">
                    <div class="panel-heading">New Appointment</div>
                    <div class="panel-body"> 
                        <p>There are {number} new appointments you need to approve</p>
                        <a href="#" class="btn btn-primary"><span class="glyphicon glyphicon-hand-right"></span> List the Appointments</a>
                    </div>
                </div>
	        </div>
	    </div>
	</div><script type="text/javascript">
	 	$('#enddate').datetimepicker();
	 </script>
	
	<%@ include file="footer.jsp"%>

	 
