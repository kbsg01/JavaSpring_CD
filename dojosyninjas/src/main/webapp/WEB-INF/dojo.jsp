<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dojo Page</title>
</head>
<body>
    <h1><c:out value="${dojo.name}"/> Ninjas</h1>

    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ninjas}" var="ninja">
                <tr>
                    <td><c:out value="${ninja.getFirstName()}"/></td>
                    <td><c:out value="${ninja.getLastName()}"/></td>
                    <td><c:out value="${ninja.getAge()}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>