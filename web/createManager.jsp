<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>



<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>DodavanjeMenagera</title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<form action="./CreateManagerController" method="post"class="dodavanjeManageraForma" accept-charset="ISO-8859-1">
			<table class="dodavanjeManageraForma">
				<tr>
					<td>Ime:</td>
					<td><input type="text" name="ime" ></td>			
				</tr>
				<tr>
					<td>Prezime:</td>
					<td><input type="text" name="prezime" ></td>				
				</tr>
				
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" ></td>				
				</tr>
				
				<tr>
					<td>Lozinka:</td>
					<td><input type="text" name="lozinka" ></td>				
				</tr>
								
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="dodaj"/></td>				
				</tr>
			</table>							
		</form>
		[<a href="./adminManageri.jsp">listaMenadzera</a>]<br/>
		[<a href="./LogoutController"><fmt:message key="odjava"/></a>]<br/>
	<body>
</html>