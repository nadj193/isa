<!DOCTYPE html>
<jsp:useBean id="restoran" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" scope="session"/>
<html>
<head>
	<title>ManagerHomePage</title>
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
</head>
<body>
<!-- <jsp:include page="manager_navigation_bar.jsp"/> -->
<ul>
  <li><a class="active" href="manager_home.jsp">HomePage</a></li>
  <li><a href="update_restoran.jsp">Update restoran</a></li>
  <li><a href="restoranMenu.jsp">Menu</a></li>
  <li><a href="./PrepareTableConfigurationController">Table configuration</a></li>
  <li><a href="showTableConfiguration.jsp">Show table configuration</a></li>
  <li class="navbar-right"><a href="./LogoutController">Logout</a></li>
</ul>
<h1 align="center">${restoran.name}</h1>
  <img src="./images/restoran.jpg" alt="Mountain View" style="width:1920px;height:500px;"> 
<h2 align="center"> ${restoran.description}</h2>
</body>
</html>