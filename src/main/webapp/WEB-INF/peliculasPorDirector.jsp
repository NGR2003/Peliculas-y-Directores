<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>Películas del Director ${nombreDirector}</h1>
		<c:if test="${peliculasDelDirector != null}">
		    <ul>
		        <c:forEach var="pelicula" items="${peliculasDelDirector}">
		            <li>${pelicula}</li>
		        </c:forEach>
		    </ul>
		</c:if>
		<c:if test="${error != null}">
		    <p>${error}</p>
		</c:if>
	</body>
</html>