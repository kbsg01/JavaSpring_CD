<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Para usar enlace de formularios -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Person</title>
</head>
<body>
    <h1>New Person</h1>

    <form:form action="/persons/new" method="post" modelAttribute="person">
        <p>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName"/>
            <form:errors path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name</form:label>
            <form:input path="lastName"/>
            <form:errors path="lastName"/>
        </p>

        <input type="submit" value="Create">
    </form:form>
</body>
</html>