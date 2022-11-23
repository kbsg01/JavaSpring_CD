<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <title>Ninja Gold Game</title>
</head>
<body>
    <main>
        <h1 class="d-flex justify-content-center">Ninja Gold Game</h1>
        <div id="score">
            <h2>Your Gold: </h2>
            <h2 class="border border-dark rounded"><c:out value="${gold}"/></h2>
        </div>
        <form action="reset" method="get">
            <input type="hidden" name="reset" value="delete">
            <input type="submit" value="Reset">
        </form>
        
        <div class="places">

            <div id="farm" class="box border border-dark">
                <h2>Farm</h2>
                <p>(earns 10-20 gold)</p>
                <form action="process" method="post">
                    <input type="hidden" name="building" value="farm">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

            <div id="cave" class="box border border-dark">
                <h2>Cave</h2>
                <p>(earns 5-10 gold)</p>
                <form action="process" method="post">
                    <input type="hidden" name="building" value="cave">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

            <div id="house" class="box border border-dark">
                <h2>House</h2>
                <p>(earns 2-5 gold)</p>
                <form action="process" method="post">
                    <input type="hidden" name="building" value="house">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

            <div id="casino" class="box border border-dark">
                <h2>Casino</h2>
                <p>(earns/takes 0-50 gold)</p>
                <form action="process" method="post">
                    <input type="hidden" name="building" value="casino">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div id="spa" class="box border border-dark">
                <h2>SPA</h2>
                <p>(take 5-10 gold)</p>
                <form action="process" method="post">
                    <input type="hidden" name="building" value="spa">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
        </div>

        <div id="activities">
            <h2>Activities</h2>
            <div class="p-1 border border-dark rounded" id="activity-box">
                <c:forEach var="i" begin="0" end="${size}">
                    <p class="<c:out value="${updates.get(i).get(0)}"/>"><c:out value="${updates.get(i).get(1)}"/><c:out value="${updates.get(i).get(2)}"/></p>
                </c:forEach>
            </div>
        </div>
    </main>
</body>
</html>