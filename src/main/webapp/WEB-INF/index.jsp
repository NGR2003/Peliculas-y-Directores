<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Peliculas</h1>
		<ul>
			<c:forEach items="${peliculas}" var="pelicula">
				<li>${pelicula}</li>
			</c:forEach>
		</ul>
	</body>
</html>