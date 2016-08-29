<%@ include file="header.jsp"%>
    <div class="container">
        <div id="addAppoint" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form class="form-horizontal" method="post" action="professionals/appointment/add">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Please Enter the Appointment Detail Information</h4> </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <div class="form-group">
                                <label class="col-md-3 control-label">Appointment Name</label>
                                <div class="col-xs-9 col-sm-5">
                                    <input type="text" class="form-control" name="name" placeholder="Appointment name" required> </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">Start Date</label>
                                <div class="col-xs-9 col-sm-5">
                                    <input id="startDateModal" type="text" class="form-control" name="appStartTime" placeholder="Start Date/Time" required> </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">End Date</label>
                                <div class="col-xs-9 col-sm-5">
                                    <input id="endDateModal" type="text" class="form-control" name="appEndTime" placeholder="End Date/Time" required> </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">Capacity</label>
                                <div class="col-xs-6 col-sm-3">
                                    <input type="number" min="1" class="form-control" name="capacity" placeholder="Capacity" required> </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">Description</label>
                                <div class="col-xs-9 col-sm-5">
                                    <textarea name="description" class="form-control" placeholder="Appointment description ...." rows="4" required></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success"><i class="fa fa-plus"></i> Add Appointment</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                </div>
            </form>
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
                    <div class="col-xs-12 col-md-7">
                        <h3>&nbsp;&nbsp;&nbsp; ${professional.lastName} ${professional.firstName}</h3>
                        <dl class="row"> <dt class="col-sm-3 text-right">Email:</dt>
                            <dd class="col-sm-9">${professional.emailAddress}</dd> <dt class="col-sm-3 text-right">Phone:</dt>
                            <dd class="col-sm-9">${professional.phoneNumber}</dd> <dt class="col-sm-3 text-right">Address:</dt>
                            <dd class="col-sm-9">${professional.address.street}, ${professional.address.city}, ${professional.address.state} ${professional.address.zip}</dd> <dt class="col-sm-3 text-right">Profession:</dt>
                            <dd class="col-sm-9">${professional.otherInfo}</dd>
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
                    <div class="col-xs-6 col-sm-2">
                        <div class="">
                            <div id="proffesionalTabList" class="list-group" role="tablist"> <a class="active list-group-item" role="tab" data-toggle="tab" href="#professionalAppoin"><span class="glyphicon glyphicon-chevron-right"></span> List of Appointments</a> <a class="list-group-item" role="tab" data-toggle="tab" href="#professionalClient">List of Clients</a>
                                <!-- Your Code Goes here -->
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-10" style="border-left: 1px #efefef solid;">
                        <div class="tab-content">
                            <div id="professionalAppoin" class="tab-pane fade in active" role="tabpanel">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-12">
                                        <div class="col-xs-12 col-sm-12">
                                            <div class="input-group"> <span class="input-group-addon" id="basic-addon1">Search Appointment</i></span>
                                                <input id="startDate" type="text" class="form-control" placeholder="Start Date/Time" aria-describedby="basic-addon1"> <span class="input-group-addon" id="basic-addon1">To</span>
                                                <input id="endDate" type="text" class="form-control" placeholder="End Date/Time" aria-describedby="basic-addon1"> <span class="input-group-btn">
	                	    					<button id="searchAppointProfBtn" class="btn btn-primary" type="button"><i class="fa fa-search"></i> Go</button>
	                	    				</span> </div>
                                            <br /> </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <br />
                                    <div class="col-xs-12 col-sm-12">
                                        <div class="row">
                                            <div id="appointmentList" class="col-xs-12 col-sm-12"> </div>
                                        </div>
                                        <!-- If No Appointment found -->
                                        <div class="row">
                                            <div id="noRecordFound1" class="col-xs-12 col-sm-12" hidden="hidden">
                                                <hr />
                                                <h4>No Appointment found in the record!</h4>
                                                <h5>Please click New Appointment button at the top to create an appointment.</h5>
                                                <br />
                                                <br />
                                                <br />
                                                <br /> </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="professionalClient" class="tab-pane fade in" role="tabpanel">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-12">
                                        <div class="col-xs-12 col-sm-12">
                                            <div class="input-group"> <span class="input-group-addon" id="basic-addon1">Search Client</i></span>
                                                <input id="searchClientsProfText" type="text" class="form-control" placeholder="Search by First / Last Name ..." aria-describedby="basic-addon1"><span class="input-group-btn">
	                	    					<button id="searchClientsProfBtn" class="btn btn-primary" type="button"><i class="fa fa-search"></i> Go</button>
	                	    				</span> </div>
                                            <br /> </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <br />
                                    <div class="col-xs-12 col-sm-12">
                                        <div class="row">
                                            <div id="clientProfList" class="col-xs-12 col-sm-12" hidden="hidden"> </div>
                                        </div>
                                        <!-- If No Appointment found -->
                                        <div class="row">
                                            <div id="noRecordFound2" class="col-xs-12 col-sm-12">
                                                <hr />
                                                <h4>No Clients found in the record!</h4>
                                                <br />
                                                <br />
                                                <br />
                                                <br /> </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>