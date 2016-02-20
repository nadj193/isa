<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="friendsCallList" type="java.util.ArrayList" scope="session"/>
<!DOCTYPE html>
<jsp:useBean id="restoran" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" scope="session"/>
<jsp:useBean id="dateandtime" type="java.lang.String" scope="session"/>
<jsp:useBean id="duration" type="java.lang.String" scope="session"/>
<html>
  <head >

    <!-- Bootstrap -->
    <link href="./bootstrap.min.css" rel="stylesheet">

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
<body>
<ul>
	<li><a href="login.jsp">Login</a></li>
  	<li><a href="registration.jsp">Register</a></li>
</ul>
  	<h2 align="center">Confirm arrival</h2>
  	
	<div class="col-md-4 col-md-offset-4 panel panel-default">
	<form action="./ReservationMergeController" method="post" class="updateGuestForm" accept-charset="ISO-8859-1">
        <div class="form-group">
        	<label for="name">Restoran</label>
        	<b><input type="text" id="name" name="name" class="form-control" value="${restoran.name}" readonly></b>
        </div>
        <div class="form-group">
        	<label for="lastName">Date and Time</label>
        	<b><input type="text" id="dateandtime" name="dateandtime" class="form-control" value="${dateandtime}" readonly></b>
        </div>
        <div class="form-group">
        	<label for="duration">Duration</label>
        	<b><input type="text" min="1" max="24" id="duration" name = "duration" class="form-control" value="${duration} hours" readonly></b>
        </div>
        <div class="form-group">
        	<label for="friends">Friends</label>
        	<b><input type="text" id="friends" name="friends" class="form-control" value="${friendsCallList.name}" readonly></b>
        </div>
        
        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Coming"/>
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Not coming"/>
			<input type="hidden" name="restoranId" value="${restoran.id}" />
		</div>
		 </form>
	</div>
     
    
</body>
</html>