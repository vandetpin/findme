$(function () {
    //***********************************************************************************************************
    // Professional Page Script Goes here
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
                    $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th></tr></table>');
                    $(data).each(function (index, JAppointment) {
                        $('#appointmentListTable').append('<tr><td>' + JAppointment.name + '</td> <td>' + JAppointment.startDate + '</td><td>' + JAppointment.endDate + '</td><td>' + JAppointment.capacity + '</td><td>' + JAppointment.status + '</td></tr>');
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
                        $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            // Need Status 
                            $('#appointmentListTable').append('<tr><td>' + JAppointment.name + '</td> <td>' + JAppointment.startDate + '</td><td>' + JAppointment.endDate + '</td><td>' + JAppointment.capacity + '</td><td>' + JAppointment.status + '</td></tr>');
                        });
                        $('#appointmentList').append('<br /> <br />')
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
                        $('#appointmentList').append('<table id="appointmentListTable" class="table table-responsive table-hover"><tr class="info"><th>Appointment</th><th>Start Date/Time</th><th>End Date/Time</th><th>Capacity</th><th>Status</th></tr></table>');
                        $(data).each(function (index, JAppointment) {
                            $('#appointmentListTable').append('<tr><td>' + JAppointment.name + '</td> <td>' + JAppointment.startDate + '</td><td>' + JAppointment.endDate + '</td><td>' + JAppointment.capacity + '</td><td>' + JAppointment.status + '</td></tr>');
                        });
                        $('#appointmentList').append('<br /> <br />')
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
        var name = $('#searchClientNameProf').val();
        if (name == '') {
            alert('Search Fields are Empty, Loading all Clients');
            $.ajax({
                url: 'professionals/api/appointments'
                , method: 'get'
                , dataType: 'json'
                , success: function (data) {
                    if (data.length > 0) {
                        $('#noRecordFound1').hide();
                        $('#scheduleList').show();
                        $('#scheduleList').children().remove();
                        $('#scheduleList').append('<table id="scheduleListTable" class="table table-responsive table-hover"><tr><th>Client Name</th><th>Start<th>Message</th><th>Status</th></tr></table>');
                        $(data).each(function (index, JAppointment) {});
                    }
                    else {
                        $('#noRecordFound2').show();
                        $('#scheduleList').hide();
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
                    name: name
                }
                , method: 'get'
                , dataType: 'json'
                , success: function (data) {
                    $('#noRecordFound1').hide();
                    $('#scheduleList').show();
                    $('#scheduleList').children().remove();
                    if (data.length > 0) {
                        $('#scheduleList').append('<table id="scheduleListTable" class="table table-responsive table-hover"><tr><th>Client Name</th><th>Start<th>Message</th><th>Status</th></tr></table>');
                        $(data).each(function (index, JAppointment) {});
                    }
                    else {
                        $('#noRecordFound2').show();
                        $('#scheduleList').hide();
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