<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="restoranMenu" type="java.util.List" scope="session"/>
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
	<c:if test="${sessionScope.manager==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<!--Navigation bar -->
		<ul>
  			<li><a class="active" href="manager_home.jsp">HomePage</a></li>
  			<li><a href="update_restoran.jsp">Update restoran</a></li>
  			<li><a href="restoranMenu.jsp">Menu</a></li>
  			<li><a href="./PrepareTableConfigurationController">Table configuration</a></li>
  			<li class="navbar-right"><a href="./LogoutController">Logout</a></li>
		</ul>
		
		<!-- Menu table -->
		<div class="container">
		<h2 align="center">Restorans menu</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Dish name</th>
					<th>Description</th>
					<th>Price(RSD)</th>
					<th> &nbsp; </th>
					<th> &nbsp; </th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${restoranMenu}" var="dish">
				<tr>
					<td>${dish.name}</td>
					<td>${dish.description}</td>
					<td>${dish.price}</td>
					<td><a href="./PrepareUpdateDishController?dishId=${dish.id}">update</a></td>
					<td><a href="./DeleteDishController?dishId=${dish.id}">delete</a></td>			
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-lg btn-primary btn-block" href="./createDish.jsp">addNewDish</a>
		</div>
	</body>	
</html>