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
        <title>Edit: <c:out value="${lenguaje.name}"/></title>
    </head>
    <body>
        <div class="d-flex flex-row-reverse m-2">
            <a class="btn btn-danger m-1" href="/languages/${lenguaje.id}/delete">Delete</a>
            <a class="btn btn-primary m-1" href="/languages">Dashboard</a>
        </div>
        <div class="d-flex justify-content-around">
            <form:form action="/languages/${lenguaje.id}" method="post" modelAttribute="lenguaje">
                <input type="hidden" name="_method" value="put">
                <div class="w-auto p-3">
                    <form:label class="me-5" path="name">Name </form:label>
                    <form:errors path="name"/>
                    <form:input size="50" path="name"/>
                </div>
                <div class="w-auto p-3">
                    <form:label  class="me-5" path="creator">Creator </form:label>
                    <form:errors path="creator"/>
                    <form:input size="50" path="creator"/>
                </div>
                <div class="w-auto p-3">
                    <form:label path="currentVersion">Current Version </form:label>
                    <form:errors path="currentVersion"/>
                    <form:input size="50" path="currentVersion"/>
                </div>
                <div class="d-flex justify-content-end">
                    <input type="submit" value="Sumbit">
                </div>
            </form:form>
        </div>
    </body>
</html>