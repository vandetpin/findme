<%@ include file="header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h3>Advance Search</h3>
		
	</div>
</div>
<hr>

<div class="row">

<div class="col-lg-4">
<form class="role" method="get" action="<c:url value='/search/advance/'></c:url>">
	<div class="form-group">
		<label>By Name</label>
		<input class="form-control input-sm" name="byname">
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
		<input class="form-control input-sm" name="byphone">
	</div>
	
	
	<button type="submit" class="btn btn-default">Submit</button>
	
</form>

</div>


<div class="col-lg-8">
<h1>Search Result</h1>
<c:forEach var="professional" items="${professionals}" varStatus="i">
		<div class="col-md-3 col-sm-6 hero-feature">
			<div class="thumbnail">
				<img src="${professional.profilePicture}" alt="">
				<div class="caption">
					<h3>${professional.firstName}${professional.lastName}</h3>
					<p>${professional.otherInfo}</p>
					<p>
						<a href="/home/details/${professional.id}" class="btn btn-primary">Details</a>
						<a href="/home/register/${professional.id}"
							class="btn btn-default">Register</a>
					</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>


</div>
<%@ include file="footer.jsp"%>