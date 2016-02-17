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
	<div class="container">
	<h2 align="center">Managers List</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>LastName</th>
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
		
		
	</body>	
</html>