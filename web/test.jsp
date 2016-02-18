
<html>
	<head>
		<title>Restorans List</title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="sorttable.js"></script>
		
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
  		<li><a href="guestHome.jsp">HomePage</a></li>
  		<li><a class="active" href="guestProfile.jsp">Your profile</a></li>
  		<li><a href="guestRestoran.jsp">Restorans List</a></li>
  		<li><a href="friends">Friends List</a></li>
  		<li class="navbar-right"><a href="./LogoutController">Logout</a></li>
	</ul>
	<div class="container">
		<h2 align="center">Restorans List</h2>
		<table class="table table-hover,sortable">
			<thead class="sortable">
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Distance </th>
					<th>Average rating</th>
					<th>Your and friends rating</th>
					<th> Reservation </th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Iriski</td>
					<td>Lep</td>	
					<td> 769m </td>	
					<td>5</td>
					<td>5</td>
					<td><input type="button" class="btn btn-lg btn-primary btn-block" name="reserve" value="Reserve" onclick=""></td>
				</tr>
				<tr>
					<td>Novosadski</td>
					<td>Lepsi</td>	
					<td> 22769m </td>	
					<td>5</td>
					<td>5</td>
					<td><input type="button" class="btn btn-lg btn-primary btn-block" name="reserve" value="Reserve" onclick=""></td>
				</tr>
				<tr>
					<td>Rumski</td>
					<td>Krs</td>	
					<td> 40769m </td>	
					<td>2</td>
					<td>3</td>
					<td><input type="button" class="btn btn-lg btn-primary btn-block" name="reserve" value="Reserve" onclick=""></td>
				</tr>
				<tr>
					<td>Kovacevic</td>
					<td>Lep</td>	
					<td> 456 </td>	
					<td>4</td>
					<td>5</td>
					<td><input type="button" class="btn btn-lg btn-primary btn-block" name="reserve" value="Reserve" onclick=""></td>
				</tr>
			</tbody>
		</table>
		</div>
		
	</body>	
</html>