<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Ninja</title>
</head>
<body>
    <h1>New Ninja</h1>

    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">

        <form:label path="dojo">Dojo:</form:label>
        <form:select path="dojo" name="dojo">
            <c:forEach items="${dojos}" var="dojo">
                <form:option value="${dojo}">
                    <c:out value="${dojo.getName()}"/>
                </form:option>
            </c:forEach>
        </form:select>

        <form:label path="firstName">First Name:</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>

        <form:label path="lastName">Last Name:</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>

        <form:label path="age">Age:</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>

        <input type="submit" value="Create">
    </form:form>
</body>
</html>