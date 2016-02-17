<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="manager" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager" scope="session"/>
<jsp:useBean id="restorani" type="java.util.List" scope="session"/>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>Update Manager</title>
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
	<h2 align="center">Manager update</h2>
		<div class="col-md-4 col-md-offset-4 panel panel-default">
      <form action="./UpdateManagerController" method="post" class="updateManagerForm" accept-charset="ISO-8859-1">
        
        <div class="form-group">
        	<label for="name">Manager name</label>
        	<input type="text" id="name" name="name" class="form-control" value="${manager.name}">
        </div>
        <div class="form-group">
        	<label for="lastName">Manager lastname</label>
        	<input type="text" id="lastName" name = "lastName" class="form-control" value="${manager.lastName}" >
        </div>
        <div class="form-group">
        	<label for="email">Manager email</label>
        	<input type="text" id="email" name = "email" class="form-control" value="${manager.email}" disabled>
        </div>
        <div class="form-group">
        	<label for="password">Manager password</label>
        	<input type="text" id="password" name = "password" class="form-control" value="${manager.password}" >
        </div>
         <div class="form-group">
        	<label for="restoran">Manager restoran</label>
        	<select name="restoran" class="form-control">
					<c:forEach items="${restorani}" var="restoran">
						<c:if test="${manager.restoran.id == restoran.id}">
							<option value="${restoran.id}" selected="selected">${restoran.name}</option>
						</c:if>
						<c:if test="${manager.restoran.id != restoran.id}">
							<option value="${restoran.id}" >${restoran.name}</option>
						</c:if>
					</c:forEach>
			</select>
        </div>
        
        <div class="form-group">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" value="Update"/>
		</div>
      </form>
    </div>
	</body>	
</html>