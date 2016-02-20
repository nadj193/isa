<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="friends" type="java.util.List" scope="session"/>
<!DOCTYPE html>
<jsp:useBean id="restoran" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" scope="session"/>
<jsp:useBean id="dateandtime" type="java.lang.String" scope="session"/>
<jsp:useBean id="duration" type="java.lang.String" scope="session"/>
<html>
  <head >

    <!-- Bootstrap -->
    <link href="./bootstrap.min.css" rel="stylesheet">

    
    <script src="sorttable.js"></script>
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

function check() {
	var checkedValue = null; 
	var inputElements = document.getElementsById("check");
	for(var i=0; inputElements[i]; ++i){
	      if(inputElements[i].checked){
	           checkedValue = inputElements[i].value;
	           alert("sd je:" +checkedValue);
	           break;
	      }
	}
	alert("dgsdd");
	
}

</script>
<%
ArrayList<Integer> checkedFriends = new ArrayList<Integer>();
%>
<script type="text/javascript">
	function foo(){
		alert("usao");
		var checkbox = document.getElementById("check");
  		if(checkbox.checked){
  			checkedFriends.add(checkbox.value);
  			<% session.setAttribute("checkedFriends",checkedFriends); %>
    		alert("checked");
  		};
	};
</script>
</head>
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
  	<h2 align="center">Restoran reservation step 2</h2>
  	
	<div class="col-md-4 col-md-offset-4 panel panel-default">
	<form action="./ReservationStep4Controller" method="post" class="updateGuestForm" accept-charset="ISO-8859-1">
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
        <label for="friend">Call friends</label> &nbsp;&nbsp;&nbsp;
        <input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
        <table class="table order-table table-hover sortable">
		<thead>
			<tr>
				<th>Name</th>
				<th>LastName</th>
				<th> Mark </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${friends}" var="friend">
				<tr>
					<td>${friend.name}</td>
					<td>${friend.lastName}</td>
					<td><input type="checkbox" id="check" name="check" value="${friend.id}" onclick = foo()>Check</td> 
					<td><input type="hidden" name="friendId" value="${friend.id}" /></td>
				</tr>
				</c:forEach>
		</tbody>
		</table>
		</div>
        
        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Next>>"/>
			<input type="hidden" name="restoranId" value="${restoran.id}" />
		</div>
		 </form>
	</div>
     
    
</body>
</html>