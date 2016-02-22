<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" %>
<%@ page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest" %>
<jsp:useBean id="restorani" type="java.util.List" scope="session"/>
<jsp:useBean id="guest" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest" scope="session"/>
<html>
	<head>
		<title>Restorans List</title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="sorttable.js"></script>
		
		<script>
(function(document) {
	'use strict';

	var LightTableFilter = (function(Arr) {

		var _input;

		function _onInputEvent(e) {
			_input = e.target;
			var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
			Arr.forEach.call(tables, function(table) {
				Arr.forEach.call(table.tBodies, function(tbody) {
					Arr.forEach.call(tbody.rows, _filter);
				});
			});
		}

		function _filter(row) {
			var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
			row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
		}

		return {
			init: function() {
				var inputs = document.getElementsByClassName('light-table-filter');
				Arr.forEach.call(inputs, function(input) {
					input.oninput = _onInputEvent;
				});
			}
		};
	})(Array.prototype);

	document.addEventListener('readystatechange', function() {
		if (document.readyState === 'complete') {
			LightTableFilter.init();
		}
	});

})(document);
</script>
		  
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
	<c:if test="${sessionScope.guest==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
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
		<h2 align="center">Restorans List</h2>
		<input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
		<br />
		<table class="table order-table table-hover sortable">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Distance </th>
					<th>Average rating</th>
					<th>Your and friends rating</th>
					<th> Reservation </th>
					<th> &nbsp; </th>
				</tr>
			</thead>
			<tbody>
			<%for(int i=0; i < restorani.size(); i++){%>
				<tr>
					<td><%=((Restoran)restorani.get(i)).getName()%></td>
					<td><%=((Restoran)restorani.get(i)).getDescription()%></td>	
					<td><%=((Restoran)restorani.get(i)).getDistance()%></td>	
					<td><%=((Restoran)restorani.get(i)).getAverageRate()%></td>
					<td><%=((Restoran)restorani.get(i)).getAverageRateByGuestAndFriends(((Guest)guest).getId(),((Guest)guest).getFriends())%></td>
					<td><a href="./ReservationStep1Controller?restoranId=<%=((Restoran)restorani.get(i)).getId()%>">Reservation</a></td>
					<td><a href="./ShowRestoranMenuController?restoranId=<%=((Restoran)restorani.get(i)).getId()%>">Restoran menu</a></td>
				</tr>
			<%}%>
			<!--
			<c:forEach items="${restorani}" var="restoran">
				<tr>
					<td>${restoran.name}</td>
					<td>${restoran.description}</td>	
					<td>796</td>	
					<td>${restoran.rating}</td>
					<td>5</td>
					<td><input type="button" class="btn btn-lg btn-primary btn-block" name="reserve" value="Reserve" onclick=""></td>
				</tr>
				</c:forEach>-->
			</tbody>
		</table>
		</div>
		
	</body>	
</html>