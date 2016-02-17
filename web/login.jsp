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
	</head>

	<body>
		<div class="container">
		<form action="./LoginController" method="post" class="prijavaForma" accept-charset="ISO-8859-1">
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" id="email" name="email" class="form-control" placeholder="email">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="password">
			</div>	
			<div class="form-group">
			<input type="submit" name="submit" value="Sign in"/>
			</div>					
		</form>
		</div>
	</body>	
</html>