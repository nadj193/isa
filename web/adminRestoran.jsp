<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="restorani" type="java.util.List" scope="session"/>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>Lista restorana</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<table class="listaRestoranaTabela">
			<thead>
				<tr>
					<th>Naziv</th>
					<th>Opis</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${restorani}" var="restoran">
				<tr>
					<td>${restoran.name}</td>
					<td>${restoran.description}</td>
					<td><a href="./PrepareUpdateController?voziloId=${restoran.id}">promenaRestorana</a></td>
					<td><a href="./DeleteRestoranController?restoranId=${restoran.id}">obrisi</a></td>			
				</tr>
				</c:forEach>
			</tbody>
		</table>
		[<a href="./PrepareCreateRestoranController">dodavanjeNovogRestorana</a>]<br/>
		[<a href="./LogoutController">odjava</a>]<br/>
		
	</body>	
</html>