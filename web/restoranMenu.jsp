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
		
		<% if(restoranMenu.isEmpty()) { %>
		<br /> <h1 align="center"> Restorans menu are empty </h1>
		<div class="col-md-4 col-md-offset-4 panel panel-default">
		<a class="btn btn-lg btn-primary btn-block" href="./createDish.jsp">addNewDish</a>
		</div>
		<% } else { %>
		
		<!-- Menu table -->
		<div class="container">
		<h2 align="center">Restorans menu</h2>
		
		<input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
		<br />
		<table class="table order-table table-hover">
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
		<% } %>
	</body>	
</html>