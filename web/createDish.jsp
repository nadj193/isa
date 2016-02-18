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
  		<li><a class="active" href="manager_home.jsp">HomePage</a></li>
  		<li><a href="update_restoran.jsp">Update restoran</a></li>
  		<li><a href="restoranMenu.jsp">Menu</a></li>
  		<li><a href="./PrepareTableConfigurationController">Table configuration</a></li>
  		<li class="navbar-right"><a href="./LogoutController">Logout</a></li>
	</ul>
	<h2 align="center">New dish</h2>
		<div class="col-md-4 col-md-offset-4 panel panel-default">
      <form action="./CreateDishController" method="post" class="createDishForm" accept-charset="ISO-8859-1">
        
        <div class="form-group">
        	<label for="dishName">Dish name</label>
        	<input type="text" id="dishName" name="dishName" class="form-control" placeholder="name" autofocus>
        </div>
        <div class="form-group">
        	<label for="dishDescription">Dish description</label>
        	<input type="text" id="dishDescription" name = "dishDescription" class="form-control" placeholder="description" required>
        </div>
        <div class="form-group">
        	<label for="dishPrice">Dish price(RSD)</label>
        	<input type="text" id="dishPrice" name = "dishPrice" class="form-control" placeholder="/" required>
        </div>
        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Create"/>
		</div>
      </form>
    </div>
	</body>	
</html>