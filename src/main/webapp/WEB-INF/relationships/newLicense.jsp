<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>New License</h1>
<form:form action="/license/new" type="POST" modelAttribute="license">
    <p>
        <form:label path="person">Person:</form:label>
        <form:errors path="person"/>
        <form:select path="person"><c:forEach items="${person}" var="person">
        <form:option value="${person.id}"><c:out value="${person.firstName}"/></form:option>
        </c:forEach></form:select>
    </p>
    <p>
        <form:label path="state">State:</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="expirationDate">Expiration Date:</form:label>
        <form:errors path="expirationDate"/>
        <form:input path="expirationDate" type="date"/>
    </p>  
    <input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>