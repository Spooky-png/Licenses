<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Person</title>
</head>
<body>
<h1><c:out value="${person.firstName}"></c:out> <c:out value="${person.lastName}"></c:out></h1>
<p><c:out value="${license.state}"></c:out></p>
<p><c:out value="${license.expirationDate}"></c:out></p>
</body>
</html>