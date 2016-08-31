<%@ include file="header.jsp"%>


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
						<a href="/home/details/${professional.id}" class="btn btn-primary">Details</a>
						<a href="/home/register/${professional.id}"
							class="btn btn-default">Register</a>
					</p>
				</div>
			</div>
		</div>
	</c:forEach>




</div>
<%@ include file="footer.jsp"%>