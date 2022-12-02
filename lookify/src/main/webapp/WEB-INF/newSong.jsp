<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
    <link rel="stylesheet" href="/css/new.css">
    <title>Add Song</title>
</head>
<body>
    <div class="navbar bg-light justify-content-end">
        <a class="btn btn-success d-flex" href="/dashboard">Dashboard</a>
    </div>

    <div class="box">
        <form:form class="form" action="/songs/new" method="post" modelAttribute="song">
            <div class="col">
                <form:label class="one" path="name">Name: </form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </div>
            
            <div class="col">
                <form:label class="one" path="artist">Artist: </form:label>
                <form:errors path="artist"/>
                <form:input path="artist"/>
            </div>
            
            <div class="col">
                <form:label class="one" path="rating">Rating: </form:label>
                <form:errors path="rating"/>
                <form:input  type="number" path="rating"/>
            </div>
            
            <div class="btn">
                <input class="inp" type="submit" value="Add Song">
            </div>
        </form:form>
    </div>


</body>
</html>