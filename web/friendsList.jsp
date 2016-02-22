<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="friends" type="java.util.List" scope="session"/>
<jsp:useBean id="guest" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest" scope="session"/>

<fmt:setBundle basename="messages.messages"/>

<html>
<head> 
	<title>Friends list</title>
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
<body>
	<c:if test="${sessionScope.guest==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
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
	<% if(friends.isEmpty()) { %>
		<br /> <h1 align="center"> Friends list are empty </h1>
		<% } else { %>
	
	<section class="container">

	<h2 align="center">Friends List</h2>

	<input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
	<br />

	<table class="table order-table table-hover sortable">
		<thead>
			<tr>
				<th>Name</th>
				<th>LastName</th>
				<th> &nbsp; </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${friends}" var="friend">
				<tr>
					<td>${friend.name}</td>
					<td>${friend.lastName}</td>
					<td><a href="./RemoveFriendController?id=${friend.id}">Remove friend from friends list</a></td> 
				</tr>
				</c:forEach>
		</tbody>
	</table>

</section>
<% } %>
		
	</body>	
</html>