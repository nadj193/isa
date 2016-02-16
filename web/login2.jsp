<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User loggin page</title>
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
	body {
    <!-- background-color:#d3d3d3; -->
    align:center;
	}
	
	#menu {
    width: 550px;
    height: 35px;
    font-size: 16px;
    font-family: Tahoma, Geneva, sans-serif;
    font-weight: bold;
    text-align: center;
    text-shadow: 3px 2px 3px #333333;
    background-color: #8AD9FF;
     border-radius: 8px;
}

#menu li {
display: inline;
padding: 20px;
}

#menu a {
    text-decoration: none;
    color: #00F;
    padding: 8px 8px 8px 8px;
}
	
</style>

</head>
<body>

	<jsp:include page="navigacija.jsp" />
	<div class="col-md-4 col-md-offset-4 panel panel-default">
		<form id="userLoginForm">
			<div class="form-group">
				<label for="username">Username:</label>
				<input type="text" id="username" name="uname" class="form-control" placeholder="username">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" id="password" name="pwd" class="form-control" placeholder="password">
			</div>	
			
			<button id="userLoginBtn" type="button" class="btn btn-primary" onclick="sendLoginParams()">Submit</button>
		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="Skripta.js"></script>
	

</body>
</html>