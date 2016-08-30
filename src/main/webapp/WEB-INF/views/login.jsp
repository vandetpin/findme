<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login page</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet"> </head>

        <body>
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="<c:url value='/home'></c:url>"><i class="fa fa-search-plus" aria-hidden="true"></i> FindMe </a> </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>
            <div id="mainWrapper">
                <div class="login-container">
                    <div class="login-card"> </div>
                </div>
            </div>
            <div class="container" style="margin-top: 10%;">
                <c:if test="${not empty successMessage}">
                    <div class="alert alert-success alert-dismissible" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <p><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <span class="sr-only">Error:</span>Invalid username and password.</p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        <p><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <span class="sr-only">Error:</span>You have been logged out successfully.</p>
                    </div>
                </c:if>
                <div class="row">
                    <div class="col-xs-12 col-sm-4 col-sm-offset-2">
                        <h3>Please Sign in here</h3>
                        <hr />
                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                            <div class="input-group">
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                <input type="text" class="form-control input-lg" id="username" name="username" placeholder="Username" required> </div>
                            <br />
                            <div class="input-group">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                                <input type="password" class="form-control input-lg" id="password" name="password" placeholder="Password" required> </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <br />
                            <button class="btn btn-primary btn-block btn-lg" type="submit" ">Login</button>
                            <!-- /input-group -->
                        </form>
                    </div>
                    <div class="col-xs-12 col-sm-4 " style="border-left: 1px #efefef solid; height: 45%; ">
                        <h3>To Register</h3>
                        <hr />
                        <p>If you want to register as new: </p>
                        <p> Professional - <a href="<c:url value='/professionals/signup'></c:url>" class="btn btn-primary btn-xs ">Please click here </a> </p> 
                        <p> Visitors - <a href="<c:url value='/visitors/signup'></c:url>" class="btn btn-primary btn-xs ">Please click here </a> </p> </p> <br />
                        <p>If you are having any problem or wanting to contact FindMe Administration in person or on a phone call, please click here. </p> 
                    </div>
                        
                </div>
            </div>
        </body>

        </html>