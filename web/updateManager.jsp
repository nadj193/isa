<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="manager" type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager" scope="request"/>
<jsp:useBean id="restorani" type="java.util.List" scope="session"/>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>Update Manager</title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<form action="./UpdateManagerController" method="post" class="promenaManagerForma" accept-charset="ISO-8859-1">
			<table class="promenaManagerTabela">
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" value="${manager.name}"></td>			
				</tr>
				<tr>
					<td>LastName:</td>
					<td><input type="text" name="lastName" value="${manager.lastName}"></td>				
				</tr>
				
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" value="${manager.email}" disabled></td>				
				</tr>
				
				<tr>
					<td>Password:</td>
					<td><input type="text" name="password" value="${manager.password}"></td>				
				</tr>
				<tr>
					<td>Restoran:</td>
					<td>
						<select name="restoran">
						<c:forEach items="${restorani}" var="restoran">
							<c:if test="${manager.restoran.id == restoran.id}">
								<option value="${restoran.id}" selected="selected">${restoran.name}</option>
							</c:if>
							<c:if test="${manager.restoran.id != restoran.id}">
								<option value="${restoran.id}" >${restoran.name}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>				
				</tr>	
									
				<tr>
					<td><input type="hidden" name="id" value="${manager.id}"></td>
					<td><input type="submit" name="submit" value="Update"/></td>				
				</tr>
			</table>											
		</form>
		[<a href="./ReadAdminMenagersController">ManagerList</a>]<br/>
		[<a href="./LogoutController">Logout</a>]<br/>
	</body>	
</html>