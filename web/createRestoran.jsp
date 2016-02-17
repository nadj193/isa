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
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<form action="./CreateRestoranController" method="post"class="dodavanjeRestoranaForma" accept-charset="ISO-8859-1">
			<table class="dodavanjeRestoranaForma">
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" ></td>			
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="description" ></td>				
				</tr>
								
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Submit"/></td>				
				</tr>
			</table>							
		</form>
		[<a href="./adminRestoran.jsp">RestoranList</a>]<br/>
		[<a href="./LogoutController">Logout</a>]<br/>
	<body>
</html>