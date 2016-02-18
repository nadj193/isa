<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="restoranTables" type="java.util.List" scope="session"/>
<!doctype html>
<html>
<head>
<title>Define restoran's table configuration</title>
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
<!--JAVASCRIPT -->
<script  src="http://code.jquery.com/jquery-1.9.1.min.js" ></script>     
<script>
    $(document).ready(function(){
        $("#myTable td").click(function() {     
 
            var column_num = parseInt( $(this).index() ) + 1;
            var row_num = parseInt( $(this).parent().index() )+1;    
            window.location.href = "./AddRestoranTableController?row=" +  row_num + "&column=" + column_num;
        });
    });
</script>
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
<br/>
<h2 align="center">Define restoran's table configuration</h2>
<br/><br/>
	<div class="col-md-4 col-md-offset-4 panel panel-default">
    <table id="myTable" border="1" style="border-collapse: collapse;" cellpadding="15" class="table table-hover">
    	<%if (restoranTables == null) {%>
    		<!--1st ROW-->
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
        </tr>
 
        <!--2nd ROW-->
        <tr>
            <td>9</td>
            <td>10</td>
            <td>11</td>
            <td>12</td>
            <td>13</td>
            <td>14</td>
            <td>15</td>
            <td>16</td>
        </tr>
 
        <!--3rd ROW-->
        <tr>
            <td>17</td>
            <td>18</td>
            <td>19</td>
            <td>20</td>
            <td>21</td>
            <td>22</td>
            <td>23</td>
            <td>24</td>
        </tr>
 
        <!--4th ROW-->
        <tr>
            <td>25</td>
            <td>23</td>
            <td>27</td>
            <td>28</td>
            <td>29</td>
            <td>30</td>
            <td>31</td>
            <td>32</td>
        </tr>
 
        <!--5th ROW-->
        <tr>
            <td>33</td>
            <td>34</td>
            <td>35</td>
            <td>36</td>
            <td>37</td>
            <td>38</td>
            <td>39</td>
            <td>40</td>
        </tr>
    	
    	<%}else{
    	for(int i = 0; i < 5; i++){%>
    		<tr>
    		<% for(int j = 0; j < 8; j++){
    			if ((Integer)restoranTables.get(i*8+j) != -1) {%>
    				<td><%=(Integer)restoranTables.get(i*8+j)%></td>
    			<%} else {%>
    				<td>&nbsp;</td>
    			<%}
    		}%>
    		</tr>
    	<%}
    	}%>
    </table>
    <br/>
    <form action="./SaveRestoranTableConfiguration" method="post" class="saveRestoranTableConfigurationForm" accept-charset="ISO-8859-1">
    <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Save"/>
	</div>
	</form>
    </div>
</body>
</html>