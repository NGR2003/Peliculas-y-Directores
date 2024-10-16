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
		<h1>detalle pelicula</h1>
		<c:choose>
			<c:when test="${nombrePelicula != null}">
				<h2>Nombre Pelicula: ${nombrePelicula}</h2>
				<h3>Autor: ${nombreDirector}</h3>
			</c:when>
			<c:otherwise>
            	<p>${error}</p>
        	</c:otherwise>
		</c:choose>
	</body>
</html>