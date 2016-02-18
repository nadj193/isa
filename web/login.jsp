<!DOCTYPE html>
<html>
	<head>
	<title>Login</title>
	<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	body {
    <!-- background-color:#d3d3d3; -->
    align:center;
	}
		
	</style>
	<style type="text/css">
	body {
    <!-- background-color:#d3d3d3; -->
    align:center;
	}	
	</style>
	
	<style>
		thead th { text-align:left; background: lightgrey;}
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
  		<li><a href="login.jsp">Login</a></li>
  		<li><a href="registration.jsp">Register</a></li>
	</ul>
	<h2 align="center">Login</h2>
		<div class="col-md-4 col-md-offset-4 panel panel-default">
		<form action="./LoginController" method="post" class="prijavaForma" accept-charset="ISO-8859-1">
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" id="email" name="email" class="form-control" placeholder="email" autofocus>
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="password">
			</div>	
			<div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Sign in"/>
			</div>					
		</form>
		</div>
	</body>	
</html>