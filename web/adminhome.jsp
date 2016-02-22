<!DOCTYPE html>
<jsp:useBean id="admin" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin" scope="session"/>
<html>
  <head >
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminHomePage</title>
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

</head>
<body>
<ul>
  <li><a href="adminhome.jsp">HomePage</a></li>
  <li><a class="active" href="adminRestoran.jsp">Restoran</a></li>
  <li><a href="adminManageri.jsp">Manager</a></li>
  <li class="navbar-right"><a href="./LogoutController">Logout</a></li>
</ul>
<h2 align="center">Your profile</h2>
<div class="col-md-4 col-md-offset-4 panel panel-default">
<br />
<img src="./images/guest.jpg" alt="There is no picture" style="width:220px;height:220px; float: left"> 
<div class="col-md-6 col-md-offset-1 panel panel-default">
 <p> 
 <label for="name">Your name and lastname</label>
 <input type="text" id="name" name="name" class="form-control" value="${admin.name} ${admin.lastName}" readonly>
 </p>
 <p> 
 <label for="email">Your email</label>
 <input type="text" id="email" name="email" class="form-control" value="${admin.email}" readonly>
 </p>
 <p> 
 <label for="password">Your password</label>
 <input type="text" id="password" name="password" class="form-control" value="${admin.password}" readonly>
 </p>
</div> 
</div>
</body>
</html>
		
