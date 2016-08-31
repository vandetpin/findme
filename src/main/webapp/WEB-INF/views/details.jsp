<%@ include file="header.jsp"%>

<div class="container">


<div class="row">


	<div class="col-md-3 col-sm-6 hero-feature">
		<div class="thumbnail">
			<img src="${professional.profilePicture}" alt="">

		</div>
	</div>

	<div class="col-md-9 col-sm-6">
		<h3>${professional.firstName}${professional.lastName}</h3>
		<p>${professional.otherInfo}</p>
		<p>
			<strong>Total Appointment: ${totalClient.size()}</strong>
		</p>
		<div class="row">

			<c:forEach var="client" items="${totalClient}" end="5">
				<div class="col-md-4"><h4>${client.name}</h4>
					<p>Capacity: ${client.capacity } </p>
					<c:choose>
						<c:when test="${loggedUser != null}">
							<a href="${client.id}" class="btn btn-success">Apply Appointment</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value='/visitors/signup?id=${professional.id}'> </c:url>" class="btn btn-success">Register</a>
						</c:otherwise>
					</c:choose>
					</div>
			</c:forEach>
		</div>
	</div>




</div>
</div>
<%@ include file="footer_nojs.jsp"%>