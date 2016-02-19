<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="restorani" type="java.util.List" scope="session"/>

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
			<c:forEach items="${restorani}" var="restoran">
				<tr>
					<td>${restoran.name}</td>
					<td>${restoran.description}</td>	
					<td> 769m </td>	
					<td>${restoran.rating}</td>
					<td>5</td>
					<td><input type="button" class="btn btn-lg btn-primary btn-block" name="reserve" value="Reserve" onclick=""></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		
	</body>	
</html>