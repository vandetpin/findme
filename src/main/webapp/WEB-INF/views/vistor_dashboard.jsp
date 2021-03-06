<%@ include file="header.jsp"%>
    <div class="container">
        <div id="addClientAppoint" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Please Enter the Appointment Detail Information</h4> </div>
                    <div class="modal-body">
                        <div class="row form-horizontal">
                            <div class="col-xs-12 col-sm-12">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <h5 class="text-info">&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-info-circle"></i> Please choose Profession your looking for to make an appointment</h5>
                                <br />
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Looking Profession</label>
                                    <div class="col-xs-5 col-sm-5">
                                        <select id="registerVisitorProfession" name="profName" class="form-control"></select>
                                    </div>
                                </div>
                                <hr />
                                <h5 class="text-info">&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-info-circle"></i> Please choose an appointment here</h5>
                                <br />
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Looking Appointment</label>
                                    <div class="col-xs-5 col-sm-5">
                                        <select id="registerVisitorProAppoint" name="profName" class="form-control"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Appointment Start Date</label>
                                    <div class="col-xs-5 col-sm-5">
                                        <input id="startDateVisitorModal" readonly type="text" class="form-control" name="appStartTime" placeholder="Start Date/Time" required> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Appointment End Date</label>
                                    <div class="col-xs-5 col-sm-5">
                                        <input id="endDateVisitorModal" readonly type="text" class="form-control" name="appEndTime" placeholder="End Date/Time" required> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="visitorMakeAppointmentbtn" type="button" class="btn btn-success"><i class="fa fa-plus"></i> Make New Appointment</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
        <hr />
        <div class="row">
            <div class="col-xs-12 col-sm-12">
                <div class="row">
                    <div class="col-xs-6 col-md-2"> <a href="#" class="thumbnail"><img src="${visitor.profilePicture}" alt=""></a> </div>
                    <div class="col-xs-12 col-md-8">
                        <h3>&nbsp;&nbsp;&nbsp; ${visitor.lastName} ${visitor.firstName}</h3>
                        <dl class="row"> <dt class="col-sm-3 text-right">Email:</dt>
                            <dd class="col-sm-9">${visitor.emailAddress}</dd> <dt class="col-sm-3 text-right">Phone:</dt>
                            <dd class="col-sm-9">${visitor.phoneNumber}</dd> <dt class="col-sm-3 text-right">Address:</dt>
                            <dd class="col-sm-9">${visitor.address.street}, ${visitor.address.city}, ${visitor.address.state} ${visitor.address.zip}</dd> <dt class="col-sm-3 text-right">Profession:</dt>
                            <dd class="col-sm-9">${visitor.otherInfo}</dd>
                        </dl>
                    </div>
                    <div class="col-xs-6 col-sm-2">
                        <button id="visitorMakeAppointment" class="btn btn-primary btn-block" data-toggle="modal" data-target="#addClientAppoint">Make Appointment</button>
                    </div>
                </div>
            </div>
        </div>
        <hr />
        <div class="row">
            <div class="col-xs-12 col-sm-12">
                <div class="row">
                    <div class="col-xs-6 col-sm-2">
                        <div class="">
                            <div id="visitorTabList" class="list-group" role="tablist"> <a class="active list-group-item" role="tab" data-toggle="tab" href="#professionalAppoin"><span class="glyphicon glyphicon-chevron-right"></span> List of Appointments</a> <a class="list-group-item" role="tab" data-toggle="tab" href="#professionalListTab"> List of Professional</a>
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
                                                <input id="startDateVisitor" type="text" class="form-control" placeholder="Start Date/Time" aria-describedby="basic-addon1"> <span class="input-group-addon" id="basic-addon1">To</span>
                                                <input id="endDateVisitor" type="text" class="form-control" placeholder="End Date/Time" aria-describedby="basic-addon1"> <span class="input-group-btn">
	                	    					<button id="searchClinentAppointBtn" class="btn btn-primary" type="button"><i class="fa fa-search"></i> Go</button>
	                	    				</span> </div>
                                            <br /> </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <br />
                                    <div class="col-xs-12 col-sm-12">
                                        <div class="row">
                                            <div id="clientAppointmentList" class="col-xs-12 col-sm-12"> </div>
                                        </div>
                                        <!-- If No Appointment found -->
                                        <div class="row">
                                            <div id="noRecordFound3" class="col-xs-12 col-sm-12" hidden="hidden">
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
                            <div id="professionalListTab" class="tab-pane fade in" role="tabpanel"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>