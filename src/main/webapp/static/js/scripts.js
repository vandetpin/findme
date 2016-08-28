$(function () {
    //***********************************************************************************************************
    // Professional Page Script Goes here
    //********************************************
    // Date Function Here
    jQuery(function () {
        jQuery('#startDate').datetimepicker({
            format: 'Y/m/d H:m'
            , onShow: function (ct) {
                this.setOptions({
                    maxDate: jQuery('#endDate').val() ? jQuery('#endDate').val() : false
                })
            }
            , timepicker: true
        });
        jQuery('#endDate').datetimepicker({
            format: 'Y/m/d H:m'
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
            format: 'Y/m/d H:m'
            , onShow: function (ct) {
                this.setOptions({
                    maxDate: jQuery('#endDateModal').val() ? jQuery('#endDateModal').val() : false
                })
            }
            , timepicker: true
        });
        jQuery('#endDateModal').datetimepicker({
            format: 'Y/m/d H:m'
            , onShow: function (ct) {
                this.setOptions({
                    minDate: jQuery('#startDateModal').val() ? jQuery('#startDateModal').val() : false
                })
            }
            , timepicker: true
        });
    });
    //********************************************
    // New Appointment --- Button
    $('#').click(function () {
        var startDate = $('#startDate').val();
        var endDate = $('#endDate').val();
        $.ajax({
            url: ''
            , data: {
                startDate: startDate
                , endDate: endDate
            }
            , method: 'post'
            , dataType: 'json'
            , success: function (data) {}
            , error: function () {}
        })
    });
    //*******************************************
    // Tab Function Goes Here
    $('#proffesionalTabList').children().click(function () {
        $(this).parent().children().removeClass('active');
        $(this).parent().children().children().remove();
        $(this).prepend('<span class="glyphicon glyphicon-chevron-right"></span> ');
        $(this).addClass('active');
    });
});