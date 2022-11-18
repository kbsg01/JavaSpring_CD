<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
    <title>Codigo Secreto</title>
</head>
<body>
    <h2 id="error"><c:out value="${error}"/></h2>
    <h1>¿Cual es el código?</h1>
    <form action="/code" method="post">
        <p><input type="password" name="code" id="filed"></p>
        <br>
        <p><input type="submit" value="Enviar"></p>
    </form>
</body>
</html>
<!-- <input id="field" type="text" name="code"> -->