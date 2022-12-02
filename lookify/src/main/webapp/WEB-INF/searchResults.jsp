<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <!-- Bootstrap -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search</title>
</head>
<body>
    <nav class="navbar bg-light">
        <div class="container-fluid">
            <p class="fw-b">Search by artist: <c:out value="${search}"/></p>
            <form:form class="d-flex" action="/songs/search" method="post">
                <input class="form-control me-2" type="text" name="search">
                <input class="btn btn-outline-success" type="submit" value="New Search">
            </form:form> 
            <a class="btn btn-success" href="/dashboard">Dashboard</a>
        </div>
    </nav>

    <table class="table table-striped table-hover mt-2">
        <thead>
            <tr>
                <th>Name</th>
                <th>Rating</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="song" items="${songs}">
                <tr>
                    <td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
                    <td><c:out value="${song.rating}"/></td>
                    <td><a href="/songs/${song.id}/delete">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>