<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"    rel="stylesheet"   integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"   crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"  integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"  crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"     integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"     crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"     integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"     crossorigin="anonymous"></script>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/index.css">
        <title>Languages</title>
    </head>
    <body>
        <h1>All Languages</h1>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Creator</th>
                    <th>Current Vesrion</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lenguajes}" var="lenguaje">
                    <tr>
                        <td><a class="link-info" href="languages/${lenguaje.id}"><c:out value="${lenguaje.name}"/></a></td>
                        <td><c:out value="${lenguaje.creator}"/></td>
                        <td><c:out value="${lenguaje.currentVersion}"/></td>
                        <td>
                            <a class="btn btn-primary" href="/languages/${lenguaje.id}/edit" >Edit</a>
                            <a class="btn btn-danger" href="/languages/${lenguaje.id}/delete">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h1>New Language</h1>
        <div class="form">
            <form:form action="/languages" method="post" modelAttribute="lenguaje">
                <div class="w-auto p-3">
                    <form:label path="name">Name: </form:label>
                    <form:errors path="name"/>
                    <form:input size="50" path="name"/>
                </div>
                <div class="w-auto p-3">
                    <form:label path="creator">Creator: </form:label>
                    <form:errors path="creator"/>
                    <form:input size="50" path="creator"/>
                </div>
                <div class="w-auto p-3">
                    <form:label path="currentVersion" >Version: </form:label>
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