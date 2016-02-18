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
	
	<script>
	function message() {
		var pass = document.getElementById("password");
		var repeatPass = document.getElementById("repeatpassword");
		if(pass.value!=repeatPass.value)
			{
			alert("You must enter same password!");
			}
		else
			{
			alert("Mail with activation link is sent on your email account. Please chack your mail, you can't login before activation your account!");
			}
	}
	</script>
	
	</head>

	<body>
	<ul>
  		<li><a href="login.jsp">Login</a></li>
  		<li><a href="register.jsp">Register</a></li>
	</ul>
	<h2 align="center">Registration</h2>
		<div class="col-md-4 col-md-offset-4 panel panel-default">
		<form action="./PrepareRegisterController" method="post" class="prijavaForma" accept-charset="ISO-8859-1">
			<div class="form-group">
				<label for="name">Name:</label>
				<input type="text" id="name" name="name" class="form-control" placeholder="name">
			</div>
			<div class="form-group">
				<label for="lastName">LastName:</label>
				<input type="text" id="lastName" name="lastName" class="form-control" placeholder="lastName">
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" id="email" name="email" class="form-control" placeholder="email">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="password">
			</div>	
			<div class="form-group">
				<label for="password">Repeat password:</label>
				<input type="password" id="repeatpassword" name="repeatpassword" class="form-control" placeholder="password">
			</div>
			<div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Sign up" onclick="message();"/>
			</div>					
		</form>
		</div>
	</body>	
</html>