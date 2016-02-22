<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="restoranMenu" type="java.util.List" scope="session"/>
<jsp:useBean id="guest" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest" scope="session"/>
<html>
	<head>
		<title>Restoran menu</title>
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
	<c:if test="${sessionScope.guest==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<!--Navigation bar -->
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
		
		<% if(restoranMenu.isEmpty()) { %>
		<br /> <h1 align="center"> Restorans menu are empty </h1>
		<div class="col-md-4 col-md-offset-4 panel panel-default">
		</div>
		<% } else { %>
		
		<!-- Menu table -->
		<div class="container">
		<h2 align="center">Restorans menu</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Dish name</th>
					<th>Description</th>
					<th>Price(RSD)</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${restoranMenu}" var="dish">
				<tr>
					<td>${dish.name}</td>
					<td>${dish.description}</td>
					<td>${dish.price}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<% } %>
	</body>	
</html>