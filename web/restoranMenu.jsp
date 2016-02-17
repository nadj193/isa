<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="restoranMenu" type="java.util.List" scope="session"/>
<html>
	<head>
		<title>Restoran menu</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
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
  			<li><a class="active" href="manager_home.jsp">Restoran</a></li>
  			<li><a href="#menu">Menu</a></li>
		</ul>
		
		<!-- Menu table -->
		<table class="restoranMenuTable">
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
					<td><a href="./PrepareUpdateDishController?dishId=${dish.id}">update</a></td>
					<td><a href="./DeleteDishController?dishId=${dish.id}">delete</a></td>			
				</tr>
				</c:forEach>
			</tbody>
		</table>
		[<a href="./createDish.jsp">addNewDish</a>]<br/>
		[<a href="./LogoutController">logOut</a>]<br/>
		
	</body>	
</html>