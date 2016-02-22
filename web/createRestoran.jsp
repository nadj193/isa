<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="jela" type="java.util.List" scope="session"/>



<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>AddRestoran</title>
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
	function message() {
		var name = document.getElementById("name").value;
		var description = document.getElementById("description").value;
		
		if(!name.match(/\S/) || !description.match(/\S/) ) {
	        alert ("Field can't be empty!");
	        return false;
		} else	{
		return true;
		}
	}
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
		
		<h2 align="center">New restoran</h2>
		<div class="col-md-4 col-md-offset-4 panel panel-default">
      <form action="./CreateRestoranController" method="post" class="createRestoranForm" accept-charset="ISO-8859-1">
        <div class="form-group">
        	<label for="name">Restoran name</label>
        	<input type="text" id="name" name="name" class="form-control" placeholder="name" autofocus>
        </div>
        <div class="form-group">
        	<label for="description">Restoran description</label>
        	<input type="text" id="description" name = "description" class="form-control" placeholder="description" required>
        </div>

        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Create" onclick="return message();"/>
		</div>
      </form>
    </div>
		
	<body>
</html>