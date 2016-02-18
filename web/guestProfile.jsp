<!DOCTYPE html>
<jsp:useBean id="guest" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest" scope="session"/>
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
</head>

<body>
<ul>
  <li><a href="guestHome.jsp">HomePage</a></li>
  <li><a class="active" href="guestProfile.jsp">Your profile</a></li>
  <li><a href="updateGuest.jsp">Edit profile</a></li>
  <li><a href="guestRestoran.jsp">Restorans List</a></li>
  <li><a href="friends">Friends List</a></li>
  <li class="navbar-right"><a href="./LogoutController">Logout</a></li>
</ul>
<h2 align="center">Your profile</h2>
<div class="col-md-4 col-md-offset-4 panel panel-default">
<br />
<img src="./images/guest.jpg" alt="There is no picture" style="width:220px;height:220px; float: left"> 
<div class="col-md-6 col-md-offset-1 panel panel-default">
 <p> 
 <label for="name">Your name and lastname</label>
 <input type="text" id="name" name="name" class="form-control" value="${guest.name} ${guest.lastName}" readonly>
 </p>
 <p> 
 <label for="adress">Your adress</label>
 <input type="text" id="adress" name="adress" class="form-control" value="${guest.adress}" readonly>
 </p>
 <p> 
 <label for="email">Your email</label>
 <input type="text" id="email" name="email" class="form-control" value="${guest.email}" readonly>
 </p>
 <p> 
 <label for="password">Your password</label>
 <input type="text" id="password" name="password" class="form-control" value="${guest.password}" readonly>
 </p>
</div> 
</div>
 

</body>
</html> 