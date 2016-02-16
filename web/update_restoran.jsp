<!DOCTYPE html>
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
  		<li><a class="active" href="manager_home.jsp">Restoran</a></li>
  		<li><a href="#menu">Menu</a></li>
	</ul>
		<div class="container">
      <form action="./UpdateRestoranController" method="post" class="updateManagerForm" accept-charset="ISO-8859-1">
        <h2 align="center">Restoran update</h2>
        <div class="form-group">
        	<label for="restoranName">Restoran name</label>
        	<input type="text" id="restoranName" name="restoranName" class="form-control" placeholder="name">
        </div>
        <div class="form-group">
        	<label for="restoranDescription">Restoran description</label>
        	<input type="text" id="restoranDescription" class="form-control" placeholder="description" required>
        </div>
        <div class="form-group">
			<input type="submit" name="submit" value="Update"/>
		</div>
      </form>
    </div>
	</body>	
</html>