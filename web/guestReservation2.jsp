<!DOCTYPE html>
<jsp:useBean id="restoran" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran" scope="session"/>
<jsp:useBean id="dateandtime" type="java.lang.String" scope="session"/>
<jsp:useBean id="duration" type="java.lang.String" scope="session"/>
<jsp:useBean id="reservationTables" type="java.util.List" scope="session"/>
<jsp:useBean id="reservedTables" type="java.util.List" scope="session"/>
<%@ page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable" %>
<html>
  <head >
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GuestHome</title>
    <meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta HTTP-EQUIV="Expires" CONTENT="-1">

    <!-- Bootstrap -->
    <link href="./bootstrap.min.css" rel="stylesheet">

    <!-- Naknadni css -->
    <link rel="stylesheet" type="text/css" href="style.css">

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

<!-- 
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
 -->

<script>
function validate() {
	var duration = document.getElementById("duration");
	var dateandtime = document.getElementById("dateandtime");
	if(reservedTables === undefined || reservedTables.length == 0 || reservedTables.isEmpty()) {
		alert("You must select table!");
		return false;
	}else {
		return true;
	}
		
}
</script>
<script  src="http://code.jquery.com/jquery-1.9.1.min.js" ></script>     
<script>
    $(document).ready(function(){
        $("#myTable td").click(function() {     
 
            var column_num = parseInt( $(this).index() ) + 1;
            var row_num = parseInt( $(this).parent().index() )+1;    
            window.location.href = "./AddReservationTableController?row=" +  row_num + "&column=" + column_num;
        });
    });
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
      <form action="./ReservationStep3Controller" method="post" class="updateGuestForm" accept-charset="ISO-8859-1">
        
        <div class="form-group">
        	<label for="name">Restoran</label>
        	<b><input type="text" id="name" name="name" class="form-control" value="${restoran.name}" readonly></b>
        </div>
        <div class="form-group">
        	<label for="lastName">Date and Time</label>
        	<b><input type="text" id="dateandtime" name="dateandtime" class="form-control" value="${dateandtime}" readonly></b>
        </div>
        <div class="form-group">
        	<label for="duration">Duration(hours)</label>
        	<b><input type="text" min="1" max="24" id="duration" name = "duration" class="form-control" value="${duration}" readonly></b>
        </div>
        <div class="col-md-4 col-md-offset-4 panel panel-default">
    	<table id="myTable" border="1" style="border-collapse: collapse;" cellpadding="15" class="table table-hover">  	
    	<%for(int i = 0; i < 5; i++){%>
    		<tr>
    		<% for(int j = 0; j < 8; j++){
    			if ((RestoranTable)reservationTables.get(i*8+j) != null) {%>
    				<%if(((RestoranTable)reservationTables.get(i*8+j)).getIsReserved()) {%>
    					<td bgcolor='red'><%} else { %>
    						<td bgcolor='green' > <%} %>
    						<%=((RestoranTable)reservationTables.get(i*8+j)).getOrdinal()%></td>
    			<%} else {%>
    				<td>&nbsp;</td>
    			<%}
    		}%>
    		</tr>
    	<%}%>
    	</table>
    </div>
        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Next>>" onclick="return validate();"/>
			<input type="hidden" name="restoranId" value="${restoran.id}" />
		</div>
      </form>
    </div>
</body>
</html>