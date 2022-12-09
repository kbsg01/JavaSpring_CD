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
    <title>Document</title>
</head>
<body>
    <h1>New License</h1>

    <form:form action="/licenses/new" method="post" modelAttribute="license">
        <p>
            <form:label path="person">Person</form:label>
            <form:select path="person">
                <c:forEach items="${persons}" var="person">
                    <form:option value="${person.id}" label="${person.getFirstName()} ${person.getLastName()}" />
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="state">state</form:label>
            <form:input path="state"/>
        </p>
        <p>
            <form:label path="expirationDate"> Expiration Date</form:label>
            <form:input path="expirationDate" type="date"/>
            <form:errors path="expirationDate"/>
        </p>

        <input type="submit" value="Create">
    </form:form>
</body>
</html>