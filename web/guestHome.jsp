<!DOCTYPE html>
<html>
  <head >
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GuestHome</title>
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
  <li><a href="guestHome.jsp">HomePage</a></li>
  <li><a class="active" href="guestProfile.jsp">Your profile</a></li>
  <li><a href="updateGuest.jsp">Edit profile</a></li>
  <li><a href="guestRestoran.jsp">Restorans List</a></li>
  <li><a href="./PrepareFriendsController">Friends List</a></li>
  <li><a href="./PrepareAddFriendsController">Add Friends</a></li>
  <li class="navbar-right"><a href="./LogoutController">Logout</a></li>
</ul>
	<div class="container">
		<h2 align="center">My visits</h2>
		<table class="table table-hover,sortable">
			<thead class="sortable">
				<tr>
					<th>Restoran</th>
					<th>Date</th>
					<th>Rating</th>
					<th>Friends</th>
					<th> &nbsp; </th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td>Dva stapica</td>
				<td>21.02.2015</td>	
				<td>5.0</td>	
				<td>Mika, Pera</td>
				<td><a href="./PrepareRateRestoranController?visitedRestoranId=1">Rate</a></td>
			</tr>
			<tr>
				<td>Dunavska terasa</td>
				<td>25.02.2015</td>	
				<td>5.0</td>	
				<td>Mika, Pera</td>
				<td><a href="./PrepareRateRestoranController?visitedRestoranId=1">Rate</a></td>
			</tr>
			</tbody>
		</table>
		</div>
</body>
</html>
		
