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
    <title>Products</title>
</head>
<body>
    <h1><c:out value="${product.getName()}"/></h1>

    <div>
        <h2>Categories</h2>
        <div>
            <ul>
                <c:forEach items="${prodCats}" var="category">

                        <li>
                            <c:out value="${category.getName()}"/>
                        </li>
                    
                </c:forEach>
            </ul>
        </div>

        <form action="/products/${product.getId()}/add" method="post">
            <label>Add Categories</label>
            <select name="category">
                <c:forEach items="${categories}" var="cetegory">
                    <option value="${category.getId()}">
                        <c:out value="${category.getName()}"/>
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>