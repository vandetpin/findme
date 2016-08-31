$(function () {
    //***********************************************************************************************************
    // Professional Page Script Goes here
    // Auto Load Function
    $('#appointmentList').ready(function () {
        $.ajax({
            url: 'professionals/api/appointments'
            , method: 'get'
            , dataType: 'json'
            , success: function (data) {
                if (data.length > 0) {
                    $('#noRecordFound1').hide();
                    $('#appointmentList').show();
                    $('#appointmentList').children().remove();
                    $('#appointmentList').append('<h3> List of Appointments </h3>');
                    $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th><th></th></tr></table>');
                    $(data).each(function (index, JAppointment) {
                        var jstatus1, jstatus2;
                        if (JAppointment.status == 1) {
                            jstatus2 = "Active";
                            jstatus1 = '<a href="professionals/appointment/' + JAppointment.id + '/0" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                        }
                        else if (JAppointment.status == 0) {
                            jstatus2 = "Cancel";
                            jstatus1 = '<a href="professionals/appointment/' + JAppointment.id + '/1" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                        }
                        $('#appointmentListTable').append('<tr><td>' + JAppointment.name + '</td> <td>' + JAppointment.startDate + '</td><td>' + JAppointment.endDate + '</td><td>' + JAppointment.capacity + '</td><td>' + jstatus2 + '</td><td>' + jstatus1 + '</td></tr>');
                    });
                    $('#appointmentList').append('<br /> <br />')
                }
                else {
                    $('#noRecordFound1').show();
                    $('#appointmentList').hide();
                }
            }
            , error: function (jqXHR, exception) {
                if (jqXHR.status != 403 && jqXHR.status == 404) {
                    alert(jqXHR.status);
                    alert('Unable to get Information about professional From the Server, Something wrong happened ... ');
                    $(location).attr('href', 'login');
                }
            }
        });
    });
    $('#clientProfList').ready(function () {
        $.ajax({
            url: 'professionals/api/visitors'
            , data: {
                firstName: ''
                , lastName: ''
            }
            , method: 'get'
            , dataType: 'json'
            , success: function (data) {
                if (data.length > 0) {
                    if (data.length > 0) {
                        $('#noRecordFound2').hide();
                        $('#clientProfList').show();
                        $('#clientProfList').children().remove();
                        $('#clientProfList').append('<h3> List of Clients </h3>');
                        $('#clientProfList').append('<table id="scheduleListTable" class="table table-responsive table-hover"><tr><th>Appointment Name</th><th>Client Name</th><th>Start Date/Time</th><th>End Time/Date</th><th>Status</th><th></th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            $(JAppointment.appointments).each(function (index, appointments) {
                                var jstatus1, jstatus2;
                                if (appointments.appointment.status == 1) {
                                    jstatus2 = "Active";
                                    jstatus1 = '<a href="professional/appointment/' + JAppointment.id + '/' + JAppointment.status + '" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                                }
                                else if (appointments.appointment.status == 0) {
                                    jstatus2 = "Cancel";
                                    jstatus1 = '<a href="professional/appointment/' + JAppointment.id + '/' + JAppointment.status + '" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                                }
                                $('#scheduleListTable').append('<tr><th>' + appointments.appointment.name + '</th><th>' + JAppointment.visitor.firstName + ' ' + JAppointment.visitor.lastName + '</th><th>' + appointments.appointment.startDate + '</th><th>' + appointments.appointment.endDate + '</th><th>' + jstatus2 + '</th><th>' + jstatus1 + '</th> </tr>');
                            });
                        });
                    }
                    else {
                        $('#noRecordFound2').show();
                        $('#clientProfList').hide();
                    }
                }
            }
            , error: function (jqXHR, exception) {
                if (jqXHR.status != 403 && jqXHR.status == 404) {
                	
                    alert('Unable to get Information about client From the Server, Something wrong happened ... ');
                    $(location).attr('href', 'login');
                }
            }
        });
    });
    //******************************************** 
    // Date Function Here
    jQuery(function () {
        jQuery('#startDate').datetimepicker({
            format: 'Y-m-d H:m:s'
            , onShow: function (ct) {
                this.setOptions({
                    maxDate: jQuery('#endDate').val() ? jQuery('#endDate').val() : false
                })
            }
            , timepicker: true
        });
        jQuery('#endDate').datetimepicker({
            format: 'Y-m-d H:m:s'
            , onShow: function (ct) {
                this.setOptions({
                    minDate: jQuery('#startDate').val() ? jQuery('#startDate').val() : false
                })
            }
            , timepicker: true
        });
    });
    jQuery(function () {
        jQuery('#startDateModal').datetimepicker({
            format: 'Y-m-d H:m:s'
            , onShow: function (ct) {
                this.setOptions({
                    maxDate: jQuery('#endDateModal').val() ? jQuery('#endDateModal').val() : false
                })
            }
            , timepicker: true
        });
        jQuery('#endDateModal').datetimepicker({
            format: 'Y-m-d H:m:s'
            , onShow: function (ct) {
                this.setOptions({
                    minDate: jQuery('#startDateModal').val() ? jQuery('#startDateModal').val() : false
                })
            }
            , timepicker: true
        });
    });
    //********************************************
    // Search Appointment by Dates
    $('#searchAppointProfBtn').click(function () {
        var startDate = $('#startDate').val();
        var endDate = $('#endDate').val();
        if (startDate == '' && endDate == '') {
            alert('One of the dates fields are Empty, Loading all Appointments');
            $.ajax({
                url: 'professionals/api/appointments'
                , method: 'get'
                , dataType: 'json'
                , success: function (data) {
                    if (data.length > 0) {
                        $('#noRecordFound1').hide();
                        $('#appointmentList').show();
                        $('#appointmentList').children().remove();
                        $('#appointmentList').append('<h3> List of Appointments </h3>');
                        $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th><th></th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            var jstatus1, jstatus2;
                            if (JAppointment.status == 1) {
                                jstatus2 = "Active";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id + '/' + JAppointment.status + '" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                            }
                            else if (JAppointment.status == 0) {
                                jstatus2 = "Cancel";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id + '/' + JAppointment.status + '" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                            }
                            $('#appointmentListTable').append('<tr><td>' + JAppointment.name + '</td> <td>' + JAppointment.startDate + '</td><td>' + JAppointment.endDate + '</td><td>' + JAppointment.capacity + '</td><td>' + jstatus2 + '</td><td>' + jstatus1 + '</td></tr>');
                        });
                        $('#appointmentList').append('<br /> <br />');
                    }
                    else {
                        $('#noRecordFound1').show();
                        $('#appointmentList').hide();
                    }
                }
                , error: function () {
                    alert('Unable to get Information From the Server, Something wrong happened ... ');
                    $(location).attr('href', 'login');
                }
            });
        }
        else {
            $.ajax({
                url: 'professionals/api/appointments'
                , data: {
                    startDate: startDate
                    , endDate: endDate
                }
                , method: 'get'
                , dataType: 'json'
                , success: function (data) {
                    if (data.length > 0) {
                        $('#noRecordFound1').hide();
                        $('#appointmentList').show();
                        $('#appointmentList').children().remove();
                        $('#appointmentList').append('<h3> List of Appointments </h3>');
                        $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th><th></th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            var jstatus1, jstatus2;
                            if (JAppointment.status == 1) {
                                jstatus2 = "Active";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id + '/' + JAppointment.status + '" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                            }
                            else if (JAppointment.status == 0) {
                                jstatus2 = "Cancel";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id + '/' + JAppointment.status + '" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                            }
                            $('#appointmentListTable').append('<tr><td>' + JAppointment.name + '</td> <td>' + JAppointment.startDate + '</td><td>' + JAppointment.endDate + '</td><td>' + JAppointment.capacity + '</td><td>' + jstatus2 + '</td><td>' + jstatus1 + '</td></tr>');
                        });
                        $('#appointmentList').append('<br /> <br />');
                    }
                    else {
                        $('#noRecordFound1').show();
                        $('#appointmentList').hide();
                    }
                }
                , error: function () {
                    alert('Unable to get Information From the Server, Something wrong happened ... ');
                    $(location).attr('href', 'login');
                }
            });
        }
    });
    //*******************************************
    //Search Client by Name
    $('#searchClientsProfBtn').click(function () {
        var name = $('#searchClientsProfText').val();
        alert('Search Fields are Empty, Loading all Clients');
        $.ajax({
            url: 'professionals/api/visitors'
            , data: {
                firstName: name
                , lastName: name
            }
            , method: 'get'
            , dataType: 'json'
            , success: function (data) {
                if (data.length > 0) {
                    $('#noRecordFound2').hide();
                    $('#clientProfList').show();
                    $('#clientProfList').children().remove();
                    $('#clientProfList').append('<table id="scheduleListTable" class="table table-responsive table-hover"><tr><th>Appointment Name</th><th>Client Name</th><th>Start Date/Time</th><th>End Time/Date</th><th>Status</th><th></th></tr></table>');
                    $(data).each(function (index, JAppointment) {
                        $(JAppointment.appointments).each(function (index, appointments) {
                            var jstatus1, jstatus2;
                            if (appointments.appointment.status == 1) {
                                jstatus2 = "Active";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id + '/' + JAppointment.status + '" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                            }
                            else if (appointments.appointment.status == 0) {
                                jstatus2 = "Cancel";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id + '/' + JAppointment.status + '" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                            }
                            $('#scheduleListTable').append('<tr><th>' + appointments.appointment.name + '</th><th>' + JAppointment.visitor.firstName + ' ' + JAppointment.visitor.lastName + '</th><th>' + appointments.appointment.startDate + '</th><th>' + appointments.appointment.endDate + '</th><th>' + jstatus2 + '</th><th>' + jstatus1 + '</th> </tr>');
                        });
                    });
                }
                else {
                    $('#noRecordFound2').show();
                    $('#clientProfList').hide();
                }
            }
            , error: function () {
                alert('Unable to get Information From the Server, Something wrong happened ... ');
                $(location).attr('href', 'login');
            }
        });
    });
    //*******************************************
    // Tab Function Goes Here
    $('#proffesionalTabList').children().click(function () {
        $(this).parent().children().removeClass('active');
        $(this).parent().children().children().remove();
        $(this).prepend('<span class="glyphicon glyphicon-chevron-right"></span> ');
        $(this).addClass('active');
    });
    //*************************************************************************************************************
    // Visitors Dashboard Page goes here
    // Autoload goes here 
    $('#clientAppointmentList').ready(function () {
        $.ajax({
            url: 'visitors/api/appointments'
            , data: {
                startDate: ''
                , endDate: ''
            }
            , method: 'get'
            , dataType: 'json'
            , success: function (data) {
                if (data.length > 0) {
                    $('#noRecordFound3').hide();
                    $('#clientAppointmentList').show();
                    $('#clientAppointmentList').children().remove();
                    $('#clientAppointmentList').append('<h3> List of Appointments </h3>');
                    $('#clientAppointmentList').append('<table id="clientScheduleListTable" class="table table-responsive table-hover"><tr><th>Appointment Name</th><th>Looking Professional</th><th>Start Date/Time</th><th>End Time/Date</th><th>Status</th><th>Approval Status</th><th></th></tr></table>');
                    $(data).each(function (index, JAppointment) {
                        var jstatus1, jstatus2, isApproved;
                        if(JAppointment.isApproved) {
                        	isApproved = "Approved";
                        } else {
                        	isApproved = "Pending";
                        }
                        
                        if (JAppointment.appointment.status == 1) {
                            jstatus2 = "Active";
                            jstatus1 = '<a href="visitors/appointment/' + JAppointment.appointment.id + '/' + JAppointment.appointment.status + '" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                        }
                        else if (appointment.status == 0) {
                            jstatus2 = "Cancel";
                            jstatus1 = '<a href="visitors/appointment/' + JAppointment.id + '/' + JAppointment.appointment.status + '" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                        }
                        $('#clientScheduleListTable').append('<tr><th>' + JAppointment.appointment.name + '</th><th>' + JAppointment.appointment.professional.firstName + ' ' + JAppointment.appointment.professional.lastName + '</th><th>' + JAppointment.appointment.startDate + '</th><th>' + JAppointment.appointment.endDate + '</th><th>' + jstatus2 + '</th><th>' + isApproved + '</th><th>' + jstatus1 + '</th> </tr>');
                        $('#clientAppointmentList').append('<br /> <br />');
                    });
                }
                else {
                    $('#noRecordFound3').show();
                    $('#clientAppointmentList').hide();
                }
            }
            , error: function () {
                if (jqXHR.status != 403 && jqXHR.status == 404) {
                    alert('Unable to get Information about Visitor From the Server, Something wrong happened ... ');
                    $(location).attr('href', 'login');
                }
            }
        });
    });
    //**********************************
    //Date function goes here 
    jQuery(function () {
        jQuery('#startDateVisitor').datetimepicker({
            format: 'Y-m-d H:m:s'
            , onShow: function (ct) {
                this.setOptions({
                    maxDate: jQuery('#endDateVisitor').val() ? jQuery('#endDateVisitor').val() : false
                })
            }
            , timepicker: true
        });
        jQuery('#endDateVisitor').datetimepicker({
            format: 'Y-m-d H:m:s'
            , onShow: function (ct) {
                this.setOptions({
                    minDate: jQuery('#startDateVisitor').val() ? jQuery('#startDateVisitor').val() : false
                })
            }
            , timepicker: true
        });
    });
    //*********************************
    // Visior Appointment goes here
    $('#searchClinentAppointBtn').click(function () {
        var startDate = $('#startDateVisitor').val();
        var endDate = $('#endDateVisitor').val();
        if (startDate == '' || endDate == '') {
            alert('Search Fields are Empty, Loading all Clients Appointments');
        }
        $.ajax({
            url: 'visitors/api/appointments'
            , data: {
                startDate: startDate
                , endDate: endDate
            }
            , method: 'get'
            , dataType: 'json'
            , success: function (data) {
                if (data.length > 0) {
                    $('#noRecordFound3').hide();
                    $('#clientAppointmentList').show();
                    $('#clientAppointmentList').children().remove();
                    $('#clientAppointmentList').append('<h3> List of Appointments </h3>');
                    $('#clientAppointmentList').append('<table id="clientScheduleListTable" class="table table-responsive table-hover"><tr><th>Appointment Name</th><th>Looking Professional</th><th>Start Date/Time</th><th>End Time/Date</th><th>Status</th><th></th></tr></table>');
                    $(data).each(function (index, JAppointment) {
                        var jstatus1, jstatus2;
                        if (JAppointment.appointment.status == 1) {
                            jstatus2 = "Active";
                            jstatus1 = '<a href="visitors/appointment/' + JAppointment.appointment.id + '/' + JAppointment.appointment.status + '" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                        }
                        else if (appointment.status == 0) {
                            jstatus2 = "Cancel";
                            jstatus1 = '<a href="visitors/appointment/' + JAppointment.id + '/' + JAppointment.appointment.status + '" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                        }
                        $('#clientScheduleListTable').append('<tr><th>' + JAppointment.appointment.name + '</th><th>' + JAppointment.appointment.professional.firstName + ' ' + JAppointment.appointment.professional.lastName + '</th><th>' + JAppointment.appointment.startDate + '</th><th>' + JAppointment.appointment.endDate + '</th><th>' + jstatus2 + '</th><th>' + jstatus1 + '</th> </tr>');
                        $('#clientAppointmentList').append('<br /> <br />');
                    });
                }
                else {
                    $('#noRecordFound3').show();
                    $('#clientAppointmentList').hide();
                }
            }
            , error: function () {
                alert('Unable to get Information about Visitor From the Server, Something wrong happened ... ');
                $(location).attr('href', 'login');
            }
        });
    });
    //*******************************************
    // Tab Function Goes Here
    $('#visitorTabList').children().click(function () {
        $(this).parent().children().removeClass('active');
        $(this).parent().children().children().remove();
        $(this).prepend('<span class="glyphicon glyphicon-chevron-right"></span> ');
        $(this).addClass('active');
    });
    //*********************************************************************************************************************
    //Admin Page Script goes here 
    //*******************************************
    // Tab Function Goes Here
    $('#adminPageListTabs').children().click(function () {
        $(this).parent().children().removeClass('active');
        $(this).parent().children().children().remove();
        $(this).prepend('<span class="glyphicon glyphicon-chevron-right"></span> ');
        $(this).addClass('active');
    });
});