<!DOCTYPE html>
<jsp:useBean id="restoran" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" scope="session"/>
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
	<%request.getSession().getAttribute("admin"); %>
  	<%if(request.getSession().getAttribute("admin") != null){%>
  		<ul>
  	  		 <li><a href="adminhome.jsp">HomePage</a></li>
  			 <li><a class="active" href="adminRestoran.jsp">Restoran</a></li>
  			 <li><a href="adminManageri.jsp">Manager</a></li>
  		 	<li class="navbar-right"><a href="./LogoutController">Logout</a></li>
  		</ul>
   	<% } 
   	else {%>
      	<ul>
  			<li><a class="active" href="manager_home.jsp">HomePage</a></li>
  			<li><a href="update_restoran.jsp">Update restoran</a></li>
  			<li><a href="restoranMenu.jsp">Menu</a></li>
  			<li><a href="./PrepareTableConfigurationController">Table configuration</a></li>
  			<li class="navbar-right"><a href="./LogoutController">Logout</a></li>
		</ul>
   	<% } %> 
   	<h2 align="center">Restoran update</h2>
	<div class="col-md-4 col-md-offset-4 panel panel-default">
      <form action="./UpdateRestoranController" method="post" class="updateManagerForm" accept-charset="ISO-8859-1">
        
        <div class="form-group">
        	<label for="restoranName">Restoran name</label>
        	<input type="text" id="restoranName" name="restoranName" class="form-control" value="${restoran.name}">
        </div>
        <div class="form-group">
        	<label for="restoranDescription">Restoran description</label>
        	<input type="text" id="restoranDescription" name = "restoranDescription" class="form-control" value="${restoran.description}" required>
        </div>
        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Update"/>
		</div>
      </form>
    </div>
	</body>	
</html>