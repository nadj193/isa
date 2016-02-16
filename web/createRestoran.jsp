<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="jela" type="java.util.List" scope="session"/>



<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>DodavanjeRestorana</title>
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
					<td>Naziv:</td>
					<td><input type="text" name="naziv" ></td>			
				</tr>
				<tr>
					<td>Opis:</td>
					<td><input type="text" name="opis" ></td>				
				</tr>
								
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="dodaj"/></td>				
				</tr>
			</table>							
		</form>
		[<a href="./adminRestoran.jsp">listaRestorana</a>]<br/>
		[<a href="./LogoutController"><fmt:message key="odjava"/></a>]<br/>
	<body>
</html>