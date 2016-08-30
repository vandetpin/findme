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
                        <h3><i class="fa fa-list" aria-hidden="true"></i> List Professionals</h3>
                        <br />
                        <c:choose>
                            <c:when test="${professionals != null}">
                                <div class="row">
                                    <div class="col-sm-8">
                                        <table class="table table-reSsponsive table-hover">
                                            <tr>
                                                <th></th>
                                                <th>Full Name</th>
                                                <th>Type</th>
                                                <th>Status</th>
                                                <th></th>
                                            </tr>
                                            <c:forEach items="${professionals}" var="professional">
                                                <tr>
                                                    <td style="width: 10px;"><i class="fa fa-2x fa-user"></i></td>
                                                    <td>${professional.lastName} ${professional.firstName}</td>
                                                    <td>${professional.type}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${professional.active == true}"> Active </c:when>
                                                            <c:otherwise> <a class="btn btn-success"> Inactive </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${professional.active == true}"> <a class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i> Disable</a> </c:when>
                            <c:otherwise> <a class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i> Active</a> </c:otherwise>
                            </c:choose>
                            </td>
                            </tr>
                            </c:forEach>
                            </table>
                            <br />
                            <br />
                            <br /> </div>
                            </div>
                            </c:when>
                            <c:otherwise>
                                <div class="row">
                                    <div id="noRecordFound1" class="col-xs-12 col-sm-12">
                                        <hr />
                                        <h4>Sorry, No Professionals found in the record!</h4>
                                        <br />
                                        <br />
                                        <br />
                                        <br /> </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="adminVisitorsList">
                        <h3><i class="fa fa-list" aria-hidden="true"></i> List Visitors</h3>
                        <hr /> </div>
                    <div role="tabpanel" class="tab-pane" id="adminUserList">
                        <h3><i class="fa fa-list" aria-hidden="true"></i> List User Account</h3>
                        <hr /> </div>
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp"%>