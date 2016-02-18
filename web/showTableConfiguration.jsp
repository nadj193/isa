<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="restoranTables" type="java.util.List" scope="session"/>
<!doctype html>
<html>
<head>
<title>Restoran table configuration</title>
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
<!--CSS -->
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
    td{
        cursor:pointer;
        background: -moz-linear-gradient(top, #ffffff, #D1E3E9);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#ffffff), to(#D1E3E9));
        text-align:center;
    }
 
    td:hover{
        background: -moz-linear-gradient(top, #249ee4, #057cc0);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#249ee4), to(#057cc0));
    }
 
    td:active
    {
        background: -moz-linear-gradient(top, #057cc0, #249ee4);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#057cc0), to(#249ee4));
    }
 
    #result{
        font-weight:bold;
        font-size:16pt;
    }
</style>
</head>
<body>
<!--Navigation bar -->
<ul>
  	<li><a class="active" href="manager_home.jsp">HomePage</a></li>
  	<li><a href="update_restoran.jsp">Update restoran</a></li>
  	<li><a href="restoranMenu.jsp">Menu</a></li>
  	<li><a href="./PrepareTableConfigurationController">Table configuration</a></li>
  	<li class="navbar-right"><a href="./LogoutController">Logout</a></li>
</ul>

<!--Table -->    
<div id="result"> </div>
<h2 align="center">Restoran table configuration</h2>
<br/><br/>
	<div class="col-md-4 col-md-offset-4 panel panel-default">
    <table id="myTable" border="1" style="border-collapse: collapse;" cellpadding="15" class="table table-hover">  	
    	<%for(int i = 0; i < 5; i++){%>
    		<tr>
    		<% for(int j = 0; j < 8; j++){
    			if ((Integer)restoranTables.get(i*8+j) != -1) {%>
    				<td><%=(Integer)restoranTables.get(i*8+j)%></td>
    			<%} else {%>
    				<td>&nbsp;</td>
    			<%}
    		}%>
    		</tr>
    	<%}%>
    </table>
    </div>
</body>
</html>