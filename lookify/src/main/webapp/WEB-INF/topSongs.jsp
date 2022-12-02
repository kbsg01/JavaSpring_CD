<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/top.css">
    <title>Search</title>
</head>
<body>
    <nav class="navbar bg-light">
        <div class="container-fluid">
            <h2>Top Ten Songs:</h2>
            <a class="btn btn-success" href="/dashboard">Dashboard</a>
        </div>
    </nav>
    <div class="box">
        <ul class="list-group">
            <c:forEach var="song" items="${songs}">
                <li class="list-group-item">${song.rating} - <a href="/songs/${song.id}"><c:out value="${song.name}"/></a> - ${song.artist}</li>
            </c:forEach>
        </ul>
    </div>

</body>
</html>