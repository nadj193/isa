<!DOCTYPE html>
<jsp:useBean id="guest" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest" scope="session"/>
<jsp:useBean id="visitedRestoran" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" scope="session"/>
<jsp:useBean id="visitDate" type="java.lang.String" scope="session"/>
<jsp:useBean id="visitDuration" type="java.lang.String" scope="session"/>
<html>
<head>
	<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	body {
    <!-- background-color:#d3d3d3; -->
    align:center;
	}	
	</style>
	<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>


<script>
function validate2() {
	var rate = document.getElementById("rate");
	if(rate.value >= 1 && rate.value < 6) {
		return true;
	} else {
		alert("You must enter number from 1 to 5 for rate!");
	  	return false;
	}
	  /* if(rate.value!='1' || rate.value!='2' || rate.value!='3' || rate.value!='4' || rate.value!='5')
		  {
	  	alert("You must enter number from 1 to 5 for rate!");
	  	return false;
		  }
	  return true; */
}
</script>


</head>

<body>
<ul>
  <li><a href="guestHome.jsp">HomePage</a></li>
  <li><a class="active" href="guestProfile.jsp">Your profile</a></li>
  <li><a href="updateGuest.jsp">Edit profile</a></li>
  <li><a href="guestRestoran.jsp">Restorans List</a></li>
  <li><a href="./PrepareFriendsController">Friends List</a></li>
  <li><a href="./PrepareAddFriendsController">Add Friends</a></li>
  <li class="navbar-right"><a href="./LogoutController">Logout</a></li>
</ul>
<h2 align="center">Rate restoran</h2>
	<div class="col-md-4 col-md-offset-4 panel panel-default">
      <form action="./RateRestoranController" method="post" class="rateRestoranForm" accept-charset="ISO-8859-1">
        
        <div class="form-group">
        	<label for="restoran">Restoran</label>
        	<input type="text" id="restoran" name="restoran" class="form-control" value="${visitedRestoran.name}" readonly>
        </div>
        <div class="form-group">
        	<label for="date">Date</label>
        	<input type="text" id="date" name="date" class="form-control" value="${visitDate}" readonly>
        </div>
        <div class="form-group">
        	<label for="duration">Duration</label>
        	<input type="text" id="duration" name = "duration" class="form-control" value="${visitDuration}" readonly>
        </div>
        <div class="form-group">
        	<label for="friends">Friends</label>
        	<input type="text" id="friends" name = "friends" class="form-control" value="Mika, Zika" readonly>
        </div>
        <div class="form-group">
        	<label for="rate">Rate</label>
        	<input type="text" id="rate" name = "rate" class="form-control" value="1" maxlength='1' autofocus/>
        </div>
        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Rate" onclick="return validate2();" />
		</div>
      </form>
    </div>
</body>
</html> 