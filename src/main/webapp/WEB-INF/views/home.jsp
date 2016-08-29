<%@ include file="header.jsp"%>



<div class="container">
	<div class="jumbotron">
	    <div class="row">
	        <div class="col-sm-8">
	            <h2>An excellent way to make an appointment</h2>
                <p>FindMe is an online  </p>
                <p><a class="btn btn-primary" href="#" role="button">Learn more <i class="fa fa-angle-double-right"></i> </a></p>
	        </div>
	        <div class="col-sm-4">
	            <img style="width: 300px;" src="<c:url value='/static/img/calendar_icon.png'></c:url>" alt="calendar" />
	        </div>
	    </div>
	  	
	</div>
</div>

<div class="container">
	<div class="row ">
        <div class="col-lg-12"> 
        	<form role="form" method="get" action="<c:url value='/search'></c:url>">
	            <div class="input-group">
	              	<input type="text" class="form-control input-lg" placeholder="Search ...">
	              	<span class="input-group-btn">
	                <button class="btn btn-primary btn-lg" type="submit"><i class="fa fa-search"></i> Search</button>
	                <a href="<c:url value='/search/advance'></c:url>" class="btn btn-default btn-lg" type="button"><i class="fa fa-search-plus"></i> Advance</a>
	              </span>
	            </div><!-- /input-group -->
	       </form> 
        <hr />
        </div><!-- /.col-lg-6 -->
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
</div>
<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="footer.jsp"%>