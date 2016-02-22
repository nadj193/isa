<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="manageri" type="java.util.List" scope="session"/>
<jsp:useBean id="restorani" type="java.util.List" scope="session"/>

<fmt:setBundle basename="messages.messages"/>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Manager List</title>
  	<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta HTTP-EQUIV="Expires" CONTENT="-1">
	<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
			
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
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
	<ul>
  		<li><a href="adminhome.jsp">HomePage</a></li>
  		<li><a class="active" href="adminRestoran.jsp">Restoran</a></li>
  		<li><a href="adminManageri.jsp">Manager</a></li>
  		<li class="navbar-right"><a href="./LogoutController">Logout</a></li>
	</ul>
	<% if(manageri.isEmpty()) { %>
		<br /> <h1 align="center"> Managers list are empty </h1>
		<div class="col-md-4 col-md-offset-4 panel panel-default">
		<a class="btn btn-lg btn-primary btn-block" href="./PrepareCreateManagerController">addNewManager</a>
		</div>
		<% } else { %>
	<div class="container">
	<h2 align="center">Managers List</h2>
	
	<input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
	<br />
	
		<table class="table order-table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Password</th>
					<th>Restoran</th>
					<th> &nbsp; </th>
					<th> &nbsp; </th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${manageri}" var="manager">
				<tr>
					<td>${manager.name}</td>
					<td>${manager.lastName}</td>
					<td>${manager.email}</td>
					<td>${manager.password}</td>
					<td>${manager.restoran.name}</td>
					<td><a href="./PrepareUpdateManagerController?managerId=${manager.id}">update</a></td>
					<td><a href="./DeleteManagerController?managerId=${manager.id}">delete</a></td>			
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
		<a class="btn btn-lg btn-primary btn-block" href="./PrepareCreateManagerController">addNewManager</a>
		</div>
		<% } %>
		
	</body>	
</html>