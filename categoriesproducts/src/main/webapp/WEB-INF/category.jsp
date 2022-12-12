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
    <title>Categories</title>
</head>
<body>
    <h1><c:out value="${category.getName()}"/></h1>

    <div>
        <h2>Products</h2>
        <div>
            <c:forEach items="${catProds}" var="product">
                <ul>
                    <li>
                        <c:out value="${product.getName()}"/>
                    </li>
                </ul>
            </c:forEach>
        </div>

        <form action="/categories/${category.getId()}/add" method="post">
            <label>Add Product</label>
            <select name="product">
                <c:forEach items="${products}" var="product">
                    <option value="${product.getId()}">
                        <c:out value="${product.getName()}"/>
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="Add">
        </form>

    </div>
</body>
</html>