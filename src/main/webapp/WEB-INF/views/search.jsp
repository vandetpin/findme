<%@ include file="header.jsp"%>
<div class="container">

<form role="form" method="get" action="<c:url value='/search'></c:url>">
	            <div class="input-group">
	              	<input type="text" name="s" value="${param.s}" class="form-control input-lg" placeholder="Search ...">
	              	<span class="input-group-btn">
	                <button class="btn btn-primary btn-lg" type="submit"><i class="fa fa-search"></i> Search</button>
	                <a href="<c:url value='/advance'></c:url>" class="btn btn-default btn-lg" type="button"><i class="fa fa-search-plus"></i> Advance</a>
	              </span> </div>
                    <!-- /input-group -->
                </form>



<div class="row">
            <div class="col-lg-12">
                <h3>Search Result</h3>
            </div>
        </div>
	


<div class="row text-center">

	<c:forEach var="professional" items="${professionals}" varStatus="i">
		<div class="col-md-3 col-sm-6 hero-feature">
			<div class="thumbnail">
				<img src="${professional.profilePicture}" alt="">
				<div class="caption">
					<h3>${professional.firstName}${professional.lastName}</h3>
					<p>${professional.otherInfo}</p>
					<p> 
                            	<a href="<c:url value='/home/details/${professional.id}'> 
                            		</c:url> " class="btn btn-primary">Details
                            	</a> 
                            	<c:if test="${professional.connected}">
                            		<span class="btn btn-success disabled-btn">Connected</span>
				                </c:if>
				                <c:if test="${not professional.connected}">
                            		<a href="<c:url value='/visitors/connect/${professional.id}'> 
                            		</c:url>" class="btn btn-default">Connect
                            	</a> 
				                </c:if>
                            </p>
				</div>
			</div>
		</div>
	</c:forEach>




</div>
</div>
<%@ include file="footer_nojs.jsp"%>