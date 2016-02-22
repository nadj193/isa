<!DOCTYPE html>
<jsp:useBean id="visitedRestorans" type="java.util.List" scope="session"/>
<jsp:useBean id="guestFriends" type="java.util.List" scope="session"/>
<jsp:useBean id="guest" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest" scope="session"/>
<%@ page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation" %>
<%@ page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" %>
<%@ page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable" %>
<%@ page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest" %>
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
  <li class="navbar-right"><font color="white">Welcome,</font><a href="updateGuest.jsp">${guest.name}</a> </li>
  
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
			<%for(int i=0; i < visitedRestorans.size(); i++){%>
				<tr>
					<%if(!(((Reservation)visitedRestorans.get(i)).getTables().isEmpty())) {%>
						<td><%=((Restoran)((RestoranTable)((Reservation)visitedRestorans.get(i)).getTables().toArray()[0]).getRestoran()).getName()%></td>
					<%} else {%>
						<td>&nbsp;</td>
					<%}%>
					<td><%=((Reservation)visitedRestorans.get(i)).getDate()%></td>	
					<td><%=((Restoran)((RestoranTable)((Reservation)visitedRestorans.get(i)).getTables().toArray()[0]).getRestoran()).getAverageRate()%></td>	
					<td><%=guestFriends.get(i)%></td>
					<td><a href="./PrepareRateRestoranController?visitedRestoranId=<%=((Restoran)((RestoranTable)((Reservation)visitedRestorans.get(i)).getTables().toArray()[0]).getRestoran()).getId()%>&visitDate=<%=((Reservation)visitedRestorans.get(i)).getDate()%> &visitDuration=<%=((Reservation)visitedRestorans.get(i)).getDuration()%>&visitFriends=<%=guestFriends.get(i)%> ">Rate</a></td>
				</tr>
			<%}%>
			</tbody>
		</table>
		</div>
</body>
</html>
		
