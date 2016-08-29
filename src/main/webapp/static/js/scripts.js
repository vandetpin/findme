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
                    $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th><th></th></tr></table>');
                    $(data).each(function (index, JAppointment) {
                        var jstatus1, jstatus2;
                        if(JAppointment.status == 1){
                            jstatus2 = "Active";
                            jstatus1 = '<a href="professionals/appointment/' + JAppointment.id +'/0" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                        }else if(JAppointment.status == 0){
                            jstatus2 = "Cancel";
                            jstatus1 = '<a href="professionals/appointment/' + JAppointment.id +'/1" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
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
            , error: function () {
                alert('Unable to get Information From the Server1');
            }
        });
    });
    
    $('#clientProfList').ready(function(){
        $.ajax({
                url: 'professionals/api/visitors'
                , data : {firstName:'', lastName:''}
                , method: 'get'
                , dataType: 'json'
                , success: function (data) {
                    if (data.length > 0) {
                        if (data.length > 0) {
                        $('#noRecordFound2').hide();
                        $('#clientProfList').show();
                        $('#clientProfList').children().remove();
                        $('#clientProfList').append('<table id="scheduleListTable" class="table table-responsive table-hover"><tr><th>Appointment Name</th><th>Client Name</th><th>Start Date/Time</th><th>End Time/Date</th><th>Status</th><th></th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            $(JAppointment.appointments).each(function (index, appointments){
                                var jstatus1, jstatus2;
                                if(appointments.appointment.status == 1){
                                    jstatus2 = "Active";
                                    jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                                }else if(appointments.appointment.status == 0){
                                    jstatus2 = "Cancel";
                                    jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                                }
                                $('#scheduleListTable').append('<tr><th>' + appointments.appointment.name +'</th><th>' + JAppointment.visitor.firstName + ' ' +  JAppointment.visitor.lastName + '</th><th>' + appointments.appointment.startDate + '</th><th>' + appointments.appointment.endDate + '</th><th>' + jstatus2 +'</th><th>' + jstatus1 +'</th> </tr>');
                            });
                        });
                    }
                    else {
                        $('#noRecordFound2').show();
                        $('#clientProfList').hide();
                    }}
                }, error: function () {
                    alert('Unable to get Information From the Server');
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
                        $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th><th></th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            var jstatus1, jstatus2;
                            if(JAppointment.status == 1){
                                jstatus2 = "Active";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                            }else if(JAppointment.status == 0){
                                jstatus2 = "Cancel";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
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
                    alert('Unable to get Information From the Server');
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
                        $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th><th></th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            var jstatus1, jstatus2;
                            if(JAppointment.status == 1){
                                jstatus2 = "Active";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                            }else if(JAppointment.status == 0){
                                jstatus2 = "Cancel";
                                jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
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
                    alert('Unable to get Information From the Server');
                }
            });
        }
    });
    //*******************************************
    //Search Client by Name
    $('#searchClientsProfBtn').click(function () {
        var name = $('#searchClientsProfText').val();
        if (name == '') {
            alert('Search Fields are Empty, Loading all Clients');
            $.ajax({
                url: 'professionals/api/visitors'
                , data : {firstName:'', lastName:''} 
                , method: 'get'
                , dataType: 'json'
                , success: function (data) {
                    if (data.length > 0) {
                        $('#noRecordFound2').hide();
                        $('#clientProfList').show();
                        $('#clientProfList').children().remove();
                        $('#clientProfList').append('<table id="scheduleListTable" class="table table-responsive table-hover"><tr><th>Appointment Name</th><th>Client Name</th><th>Start Date/Time</th><th>End Time/Date</th><th>Status</th><th></th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            $(JAppointment.appointments).each(function (index, appointments){
                                var jstatus1, jstatus2;
                                if(appointments.appointment.status == 1){
                                    jstatus2 = "Active";
                                    jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                                }else if(appointments.appointment.status == 0){
                                    jstatus2 = "Cancel";
                                    jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                                }
                                $('#scheduleListTable').append('<tr><th>' + appointments.appointment.name +'</th><th>' + JAppointment.visitor.firstName + ' ' +  JAppointment.visitor.lastName + '</th><th>' + appointments.appointment.startDate + '</th><th>' + appointments.appointment.endDate + '</th><th>' + jstatus2 +'</th><th>' + jstatus1 +'</th> </tr>');
                            });
                        });
                    }
                    else {
                        $('#noRecordFound2').show();
                        $('#clientProfList').hide();
                    }
                }
                , error: function () {
                    alert('Unable to get Information From the Server');
                }
            });
        }
        else {
            $.ajax({
                url: 'professionals/api/visitors'
                , data: {firstName: name, lastName: name}
                , method: 'get'
                , dataType: 'json'
                , success: function (data) {
                    if (data.length > 0) {
                        $('#noRecordFound2').hide();
                        $('#clientProfList').show();
                        $('#clientProfList').children().remove();
                        $('#clientProfList').append('<table id="scheduleListTable" class="table table-responsive table-hover"><tr><th>Appointment Name</th><th>Client Name</th><th>Start Date/Time</th><th>End Time/Date</th><th>Status</th><th></th></tr></table>');
                        $(data).each(function (index, JAppointment) { 
                            $(JAppointment.appointments).each(function (index, appointments){ 
                                var jstatus1, jstatus2;
                                if(appointments.appointment.status == 1){
                                    jstatus2 = "Active";
                                    jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Cancel</a>';
                                }else if(appointments.appointment.status == 0){
                                    jstatus2 = "Cancel";
                                    jstatus1 = '<a href="professional/appointment/' + JAppointment.id +'/'+ JAppointment.status +'" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i>  Active</a>';
                                }
                                $('#scheduleListTable').append('<tr><th>' + appointments.appointment.name +'</th><th>' + JAppointment.visitor.firstName + ' ' +  JAppointment.visitor.lastName + '</th><th>' + appointments.appointment.startDate + '</th><th>' + appointments.appointment.endDate + '</th><th>' + jstatus2 +'</th><th>' + jstatus1 +'</th> </tr>');
                            });
                        });
                    }
                    else {
                        $('#noRecordFound2').show();
                        $('#clientProfList').hide();
                    }
                }
                , error: function () {
                    alert('Unable to get Information From the Server');
                }
            });
        }
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
    // Client Dashboard Page goes here
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
});