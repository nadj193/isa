<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Restoran table configuration</title>
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
	<style>
		input[type=submit]{
 			color: black;
			font-size: 7pt;
 			width: 50px;
 			height: 30px;
 			border: 2px solid #000;
 			margin: 0;
 			padding: 3px;
 			background-color:white; 
		}
	</style>
	<script type="text/javascript">
		function btnColor(btn) {
    		var property=document.getElementById(btn);
    		property.style.background-color=green;
    		property.value=10;
    		window.location = '/GeneralInfo.jsp';
    	}
		function  buttonClick(element) {
			element.style.background-color=green;
			element.value=10;
			var row = element.parentNode.parentNode.rowIndex;
			var column = element.parentNode.cellIndex;
		    //window.location = './addRestoranTableController?row=row&column=column';
		    document.location.href="./AddRestoranTableController?row=row&column=column";
		}
    </script>
}
	</head>
	<c:if test="${sessionScope.manager==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<!--Navigation bar -->
		<ul>
  			<li><a class="active" href="manager_home.jsp">Restoran</a></li>
  			<li><a href="restoranMenu.jsp">Menu</a></li>
		</ul>
		
		<!-- Menu table -->
		<table class="restoranTableConfiguration" style="width:50px">
    		<tr>
    			<td>
                	<input id="edit1" type="submit" name="edit" value="edit" onclick="buttonClick(this)">
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        	</tr>
        	<tr>
    			<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        	</tr>
        	<tr>
    			<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        	</tr>
        	<tr>
    			<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        	</tr>
        	<tr>
    			<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        		<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
               	<td>
    				<form name="f1" action="./addRestoranTableController" method="post" accept-charset="ISO-8859-1">
                		<input id="edit1" type="submit" name="edit" value="edit">
               		</form>
               	</td>
        	</tr>
		</table>	
	</body>	
</html>