<%@ include file="header.jsp"%>
    <div class="container">
        <div class="row">
            <h2><i class="fa fa-cogs" aria-hidden="true"></i> Admin Panel</h2>
            <hr />
            <div class="col-xs-5 col-sm-2">
                <div class="list-group" id="adminPageListTabs"> <a href="#adminProfessionalList" class="list-group-item active" aria-controls="home" role="tab" data-toggle="tab"><i class="fa fa-chevron-right" aria-hidden="true"></i> List of Professionals</a> <a href="#adminVisitorsList" class="list-group-item" aria-controls="home" role="tab" data-toggle="tab">List of Visitors</a> <a href="#adminUserList" class="list-group-item" aria-controls="home" role="tab" data-toggle="tab">List of User Accounts</a> </div>
            </div>
            <div class="col-xs-12 col-sm-10" style="border-left: 1px #efefef solid;">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="adminProfessionalList">
                        <h3>List Professional</h3>
                        <hr /> </div>
                    <div role="tabpanel" class="tab-pane" id="adminVisitorsList">
                        <h3>List Visitors</h3>
                        <hr /> </div>
                    <div role="tabpanel" class="tab-pane" id="adminUserList">
                        <h3>List User Account</h3>
                        <hr /> </div>
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp"%>