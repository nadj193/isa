<!DOCTYPE html>
<jsp:useBean id="restoran" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" scope="session"/>
<html>
  <head >
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GuestHome</title>
    <meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta HTTP-EQUIV="Expires" CONTENT="-1">

    <!-- Bootstrap -->
    <link href="./bootstrap.min.css" rel="stylesheet">

    <!-- Naknadni css -->
    <link rel="stylesheet" type="text/css" href="style.css">

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
function validate() {
	var duration = document.getElementById("duration");
	if(duration.value < 1 || rate.value >24) {
		alert("You must enter number from 1 to 24 for duration!");
		return false;
	} else {
		return true;
	  	
	}
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
  	<h2 align="center">Restoran reservation step 1</h2>
	<div class="col-md-4 col-md-offset-4 panel panel-default">
      <form action="./ReservationStep2Controller" method="post" class="updateGuestForm" accept-charset="ISO-8859-1">
        
        <div class="form-group">
        	<label for="name">Restoran</label>
        	<b><input type="text" id="name" name="name" class="form-control" value="${restoran.name}" readonly></b>
        </div>
        <div class="form-group">
        	<label for="lastName">Date and Time</label>
        	<input type="datetime-local" id="dateandtime" name="dateandtime" class="form-control">
        </div>
        <div class="form-group">
        	<label for="duration">Duration(hours)</label>
        	<input type="number" min="1" max="24" id="duration" name = "duration" class="form-control" >
        </div>
        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Next>>" onclick="return validate();"/>
			<input type="hidden" name="restoranId" value="${restoran.id}" />
		</div>
      </form>
    </div>
</body>
</html>