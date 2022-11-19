<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/result.css">
    <title>Encuesta del Dojo Index</title>
</head>
<body>
    <div class="container border border-dark">
        <h1>Genial, te gusta java tanto como a nosotros!</h1>
        <h3>Informacion Enviada</h3>
        <h4>Nombre: <c:out value="${name}"/></h4>
        <h4>Locacion del Dojo: <c:out value="${location}"/></h4>
        <h4>Lenguaje Favorito: <c:out value="${language}"/></h4>
        <h4>Comentario: <c:out value="${comment}"/></h4>
        <button><a href="/">Volver</a></button>
    </div>
</body>
</html>