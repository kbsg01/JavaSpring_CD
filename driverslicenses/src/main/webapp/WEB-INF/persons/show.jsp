<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1><c:out value="${person.getFirstName()} ${person.getLastName()}"/></h1>
    <h2>License Number: <c:out value="${person.license.getNumber()}"/></h2>
    <h2>State: <c:out value="${person.license.getState()}"/></h2>
    <h2>Expiration Date: <c:out value="${person.license.getExpirationDate()}"/></h2>
</body>
</html>