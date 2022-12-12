<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Product</title>
</head>
<body>
    <h1>New Product</h1>
    <form:form method="POST" action="/products/new" modelAttribute="product">
        <div>
            <form:label path="name">Name:</form:label>
            <form:input path="name" />			
        </div>
        <div>
            <form:label path="description">Description:</form:label>
            <form:input path="description" />			
        </div>
        <div>
            <form:label path="price">Price:</form:label>
            <form:input type="number" step="0.1" path="price" />			
        </div>
        <input type="submit" value="Create" >
    </form:form>
</body>
</html>
