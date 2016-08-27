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
		<label>By City</label>
		<input class="form-control input-sm" name="bycity">
	</div>
	
	<div class="form-group">
		<label>By Type </label>
		<select name="bytype" class="form-control input-sm">
				<option value="">--ALL--</option>
				<option value="DOCTOR">Doctor</option>
				<option value="LAYER">Lawyer</option>
				<option value="BARBER">Barber</option>
				<option value="MUSIC_TEACHER">Music Teacher</option>
			</select>
	</div>
	<div class="form-group">
		<label>By Phone</label>
		<input class="form-control input-sm" name="byphone">
	</div>
	<div class="form-group">
		<label>Join</label>
		<select name="join" class="form-control">
					<option value="OR">OR</option>
					<option value="AND">AND</option>
					<option value="LIKE">Contains</option>
				</select>
	</div>
	
	<button type="submit" class="btn btn-default">Submit</button>
	
</form>

</div>


<div class="col-lg-8">
<h1>Search Result</h1>

</div>


</div>
<%@ include file="footer.jsp"%>