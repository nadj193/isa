<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="manageri" type="java.util.List" scope="session"/>
<jsp:useBean id="restorani" type="java.util.List" scope="session"/>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>Lista menadzera</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<table class="listaMenadzeraTabela">
			<thead>
				<tr>
					<th>Ime</th>
					<th>Prezime</th>
					<th>Lozinka</th>
					<th>Restoran</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${manageri}" var="manager">
				<tr>
					<td>${manager.name}</td>
					<td>${manager.lastName}</td>
					<td>${manager.password}</td>
					<td>${manager.restoran.name}</td>
					<td><a href="./PrepareUpdateMenagerController?managerId=${manager.id}">promenaMenadzera</a></td>
					<td><a href="./DeleteManagerController?managerId=${manager.id}">obrisi</a></td>			
				</tr>
				</c:forEach>
			</tbody>
		</table>
		[<a href="./PrepareCreateManagerController">dodavanjeNovogMenadzera</a>]<br/>
		[<a href="./LogoutController">odjava</a>]<br/>
		
	</body>	
</html>