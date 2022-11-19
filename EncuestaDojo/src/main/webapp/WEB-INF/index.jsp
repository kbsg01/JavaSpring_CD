<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <title>Encuesta del Dojo Index</title>
</head>
<body>
    <div class="container border border-dark">
        <form  action="/result" method="post">
            
                <label for="name">Tu Nombre: </label>
                <input type="text" name="name" id="name">
            
            
                <label for="loc">Locacion del Dojo</label>
                <select name="location" id="loc">
                    <option value="Seattle">Seattle</option>
                    <option value="Silicon Valley">Silicon Valley</option>
                    <option value="Los Angeles">Los Angeles</option>
                    <option value="Chicago">Chicago</option>
                    <option value="Berkley">Berkley</option>
                </select>
            
            
                <label for="language">Lenguaje Favorito</label>
                <select name="language" id="language">
                    <option value="Python">Python</option>
                    <option value="Java">Java</option>
                    <option value="C#">C#</option>
                    <option value="Ruby">Ruby</option>
                    <option value="JavaScript">JavaScript</option>
                </select>
            
            
            <label for="comment">Comentario (Opcional)</label>
            <br>
            <textarea name="comment" id="comment" cols="30" rows="5"></textarea>
            <br>
            <input class="boton" type="submit" value="Enviar">
        </form>
    </div>
</body>
</html>