<%@ include file="header.jsp"%>

<div class="container">
<div class="row">
	<div class="col-lg-12">
		<h3>Advance Search</h3>
		
	</div>
</div>
<hr>

<div class="row">

<div class="col-lg-4">
<form class="role" method="get" action="<c:url value='/advance'></c:url>">
	<div class="form-group">
		<label>By Name</label>
		<input class="form-control input-sm" name="byname" value="${param.byname }">
	</div>
	
	
	<div class="form-group">
		<label>By Type </label>
		<select name="bytype" class="form-control input-sm">
				<option value="">--ALL--</option>
				<option value="0">Doctor</option>
				<option value="1">Lawyer</option>
				<option value="2">Barber</option>
				<option value="3">Music Teacher</option>
				<option value="4">TM Teacher</option>
			</select>
	</div>
	
	
	<div class="form-group">
		<label>By Phone</label>
		<input class="form-control input-sm" name="byphone" value="${param.byphone }">
	</div>
	
	
	<button type="submit" class="btn btn-default">Submit</button>
	
</form>

</div>


<div class="col-lg-8">
<h3>Search Result</h3>
<c:forEach var="professional" items="${professionals}" varStatus="i">
		<div class="col-md-4  hero-feature">
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
</div>
<%@ include file="footer_nojs.jsp"%>