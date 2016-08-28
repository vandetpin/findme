<%@ include file="header.jsp"%>
    <div class="container">
        <div id="addAppoint" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Please Enter the Appointment Detail Information</h4> </div>
                    <div class="modal-body">
                        <form class="form-horizontal" method="post" enctype="multipart/form-data" action="?${_csrf.parameterName}=${_csrf.token}">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Appointment Name</label>
                                        <div class="col-xs-9 col-sm-5">
                                            <input type="text" class="form-control" name="firstName" placeholder="First name"> </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Start Date</label>
                                        <div class="col-xs-9 col-sm-5">
                                            <input id="startDateModal" type="text" class="form-control" name="startDate" placeholder="Start Date/Time"> </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">End Date</label>
                                        <div class="col-xs-9 col-sm-5">
                                            <input id="endDateModal" type="text" class="form-control" name="endDate" placeholder="End Date/Time"> </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Capacity</label>
                                        <div class="col-xs-6 col-sm-3">
                                            <input type="number" min="1" class="form-control" name="capacity" placeholder="Capacity"> </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Description</label>
                                        <div class="col-xs-9 col-sm-5">
                                            <textarea name="description" class="form-control" placeholder="Appointment description ...." rows="3"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        <button type="button" class="btn btn-success"><i class="fa fa-plus"></i> Add Appointment</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
        <hr />
        <div class="row">
            <div class="col-xs-12 col-sm-9">
                <div class="row">
                    <div class="col-xs-6 col-md-2"> <a href="#" class="thumbnail"><img src="<c:url value='/static/img/placeholder.png'></c:url>" alt="..."></a> </div>
                    <div class="col-xs-12 col-md-6">
                        <h3>Name Goes Here</h3>
                        <dl> <dt>{Name}</dt>
                            <dd>{Property}</dd>
                        </dl>
                    </div>
                    <div class="col-xs-6 col-sm-3">
                        <button class="btn btn-primary btn-block" data-toggle="modal" data-target="#addAppoint">New Appointment</button>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-3">
                <div class="panel panel-default">
                    <div class="panel-heading">New Appointment</div>
                    <div class="panel-body">
                        <p>There are {number} new appointments you need to approve</p> <a href="#" class="btn btn-primary"><span class="glyphicon glyphicon-hand-right"></span> List the Appointments</a> </div>
                </div>
            </div>
        </div>
        <hr />
        <div class="row">
            <div class="col-xs-12 col-sm-12">
                <div class="row">
                    <div class="col-xs-6 col-sm-3">
                        <div class="">
                            <div class="list-group"> <a href="#" class="active list-group-item "><span class="glyphicon glyphicon-chevron-right"></span> List of Appointments</a> <a href="#" class="list-group-item ">List of Clients</a>
                                <!-- Your Code Goes here -->
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-9">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12">
                                <h4>Search Appointment Now</h4>
                                <hr />
                                <div class="col-xs-12 col-sm-12">
                                    <div class="input-group"> <span class="input-group-addon" id="basic-addon1">From</i></span>
                                        <input id="startDate" type="text" class="form-control" placeholder="Start Date/Time" aria-describedby="basic-addon1"> <span class="input-group-addon" id="basic-addon1">To</span>
                                        <input id="endDate" type="text" class="form-control" placeholder="End Date/Time" aria-describedby="basic-addon1"> <span class="input-group-btn">
	                	    					<button class="btn btn-primary" type="button"><i class="fa fa-search"></i> Go</button>
	                	    				</span> </div>
                                    <br /> </div>
                            </div>
                        </div>
                        <div class="row">
                            <br />
                            <div class="col-xs-12 col-sm-12">
                                <div class="row">
                                    <div id="appointmentList" class="col-xs-12 col-sm-12">
                                        <table class="table table-responsive table-hover">
                                            <tr>
                                                <th>Appointment</th>
                                                <th>Start Date/Time</th>
                                                <th>End Date/Time</th>
                                                <th>Capacity</th>
                                            </tr>
                                            <!-- Your Code Goes here -->
                                        </table>
                                    </div>
                                </div>
                                <div class="row">
                                    <div id="scheduleList" class="col-xs-12 col-sm-12" hidden="hidden">
                                        <table class="table table-responsive table-hover">
                                            <tr>
                                                <th>Client Name</th>
                                                <th>Start Date/Time</th>
                                                <th>Message</th>
                                                <th>Status</th>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <!-- If No Appointment found -->
                                <div class="row">
                                    <div id="noRecordFound" class="col-xs-12 col-sm-12" hidden="hidden">
                                        <hr />
                                        <h4>No Appointment found in the record!</h4>
                                        <h5>Please click New Appointment button at the top to create an appointment.</h5> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>